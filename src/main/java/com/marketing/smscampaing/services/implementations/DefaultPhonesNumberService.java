package com.marketing.smscampaing.services.implementations;

import com.marketing.smscampaing.dtos.ClientDTO;
import com.marketing.smscampaing.dtos.PhoneDTO;
import com.marketing.smscampaing.model.domain.entity.*;
import com.marketing.smscampaing.model.repositories.*;
import com.marketing.smscampaing.services.interfaces.PhonesNumberService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class DefaultPhonesNumberService implements PhonesNumberService {
    private final PhoneNumbersRepository phoneNumbersRepository;
    private final TypeRepository typeRepository;
    private final PurposeRepository purposeRepository;
    private final OccupationRepository occupationRepository;
    private final GenderRepository genderRepository;
    private final CountryRepository countryRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<PhoneDTO> showAllPhones() {
        List<Phone> phones = phoneNumbersRepository.findAllVisible();
        ModelMapper myModel = new ModelMapper();
        log.debug("Phones before mapping: {}", phones.toString());

        List<PhoneDTO> phonesDTO = phones.stream().map(el -> myModel.map(el, PhoneDTO.class)).collect(Collectors.toList());
        log.debug("PhonesDTO after mapping: {}", phonesDTO.toString());
        return phonesDTO;
    }

    @Override
    public List<PhoneDTO> showByParams(LocalDate min, LocalDate max, List<String> gender, List<String> occupation, List<String> purpose, List<String> types, List<String> country) {
        if (gender.isEmpty()) {
            List<Gender> all = genderRepository.findAll();
            gender = all.stream().map(Gender::getGender).collect(Collectors.toList());
        }
        if (occupation.isEmpty()) {
            List<Occupation> all = occupationRepository.findAll();
            occupation = all.stream().map(Occupation::getOccupation).collect(Collectors.toList());
        }
        if (purpose.isEmpty()) {
            List<Purpose> all = purposeRepository.findAll();
            purpose = all.stream().map(Purpose::getPurpose).collect(Collectors.toList());
        }
        if (types.isEmpty()) {
            List<Type> all = typeRepository.findAll();
            types = all.stream().map(Type::getType).collect(Collectors.toList());
        }
        if (country.isEmpty()) {
            List<Country> all = countryRepository.findAll();
            country = all.stream().map(Country::getName).collect(Collectors.toList());
        }
        List<Phone> phones = phoneNumbersRepository.findAllByParamRequests(min, max, gender, occupation, purpose, types, country);
        ModelMapper myModel = new ModelMapper();
        log.debug("Phones from query before mapping: {}", phones.toString());
        List<PhoneDTO> phonesDTO = phones.stream().map(
                el -> myModel.map(el, PhoneDTO.class)
        ).collect(Collectors.toList());
        log.debug("Phones from query  after mapping: {}", phonesDTO.toString());
        return phonesDTO;
    }

    @Override
    public Page<PhoneDTO> findPaginatedDTO(int pageNo, int pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(Sort.Direction.DESC, "id"));
        Page<Phone> all = phoneNumbersRepository.findAll(paging);
        log.debug("Page with clients: {}", all);
        ModelMapper myModel = new ModelMapper();
        Page<PhoneDTO> phoneDTOS = myModel.map(all, Page.class);
        log.debug("Page of phone DTO after mapping: {}", phoneDTOS);

        return phoneDTOS;
    }
}


