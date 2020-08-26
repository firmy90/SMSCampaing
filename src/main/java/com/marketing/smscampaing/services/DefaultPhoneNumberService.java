package com.marketing.smscampaing.services;

import com.marketing.smscampaing.dtos.PhoneDTO;
import com.marketing.smscampaing.model.domain.entity.Phone;
import com.marketing.smscampaing.model.repositories.PhoneNumbersRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service @Slf4j @AllArgsConstructor
public class DefaultPhoneNumberService implements PhonesNumberService{
    private final PhoneNumbersRepository phoneNumbersRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<PhoneDTO> showAllPhones() {
        List<Phone> phones = phoneNumbersRepository.findAllVisible();
        ModelMapper myModel = new ModelMapper();
        myModel.getConfiguration().setAmbiguityIgnored(true);
        log.info("Phones before mapping: {}", phones.toString());

        List<PhoneDTO> phonesDTO = phones.stream().map(el -> myModel.map(el, PhoneDTO.class)).collect(Collectors.toList());
        log.info("Phones after mapping: {}", phonesDTO.toString());
        return phonesDTO;
    }


}
