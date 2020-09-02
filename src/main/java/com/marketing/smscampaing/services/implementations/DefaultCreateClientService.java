package com.marketing.smscampaing.services.implementations;

import com.marketing.smscampaing.dtos.ClientDTO;
import com.marketing.smscampaing.model.domain.entity.Client;
import com.marketing.smscampaing.model.domain.entity.Gender;
import com.marketing.smscampaing.model.domain.entity.Occupation;
import com.marketing.smscampaing.model.domain.entity.enums.GenderEnum;
import com.marketing.smscampaing.model.domain.entity.enums.OccupationDefaultEnum;
import com.marketing.smscampaing.model.repositories.GenderRepository;
import com.marketing.smscampaing.model.repositories.OccupationRepository;
import com.marketing.smscampaing.model.repositories.UserInsertRepository;
import com.marketing.smscampaing.services.interfaces.CreateClientService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@Slf4j
@AllArgsConstructor
public class DefaultCreateClientService implements CreateClientService {
    private final UserInsertRepository userInsertRepository;
    private final ModelMapper modelMapper;
    private final GenderRepository genderRepository;
    private final OccupationRepository occupationRepository;

    @Override
    public boolean createClient(ClientDTO clientDTO) {
        Client client = new Client();
        Gender firstByGender = genderRepository.findFirstByGender(clientDTO.getGenderGender());
        log.debug("Gender from database taken using query: {}", firstByGender);
        if (firstByGender == null) {
            firstByGender = genderRepository.findFirstByGender(GenderEnum.UNKNOWN.toString());
        }
        log.debug("Gender from database taken using default value: {}", firstByGender);
        Occupation firstByOccupation = occupationRepository.findFirstByOccupation(clientDTO.getOccupationOccupation());
        log.debug("Occupation from database taken using query: {}", firstByOccupation);
        if (firstByOccupation == null) {
            firstByOccupation = occupationRepository.findFirstByOccupation(OccupationDefaultEnum.Other.toString());
        }
        log.debug("Occupation from database taken using default value: {}", firstByOccupation);
        log.debug("clientDTO before mapping: {}", clientDTO);
        modelMapper.map(clientDTO, client);
        log.debug("client after mapping: {}", client);
        client.setOccupation(firstByOccupation);
        client.setOccupationId(firstByOccupation.getId());
        client.setGender(firstByGender);
        client.setGenderId(firstByGender.getId());
        client.setBirthdate(LocalDate.parse(clientDTO.getBirthdate()));
        log.debug("client after mapping and setting occupation and gender: {}", client);
        return userInsertRepository.createClient(client);

    }
}
