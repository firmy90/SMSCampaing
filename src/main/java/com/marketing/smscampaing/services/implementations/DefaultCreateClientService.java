package com.marketing.smscampaing.services.implementations;

import com.marketing.smscampaing.dtos.ClientDTO;
import com.marketing.smscampaing.model.domain.entity.Client;
import com.marketing.smscampaing.model.domain.entity.Gender;
import com.marketing.smscampaing.model.domain.entity.Occupation;
import com.marketing.smscampaing.model.repositories.GenderRepository;
import com.marketing.smscampaing.model.repositories.OccupationRepository;
import com.marketing.smscampaing.model.repositories.UserInsertRepository;
import com.marketing.smscampaing.services.interfaces.CreateClientService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
@Slf4j
@AllArgsConstructor
public class DefaultCreateClientService implements CreateClientService {
    private final UserInsertRepository userInsertRepository;
    private final ModelMapper modelMapper;
    private final GenderRepository genderRepository;
    private final OccupationRepository occupationRepository;
    @Override
    public void createClient(ClientDTO clientDTO) {
        Client client = new Client();
        Gender firstByGender = genderRepository.findFirstByGender(clientDTO.getGenderGender());
        Occupation firstByOccupation = occupationRepository.findFirstByOccupation(clientDTO.getOccupationOccupation());
        log.debug("clientDTO before mapping: {}",clientDTO);
        modelMapper.map(clientDTO,client);
        log.debug("client after mapping: {}", client);
        client.setOccupation(firstByOccupation);
        client.setOccupationId(firstByOccupation.getId());
        client.setGender(firstByGender);
        client.setBirthdate(LocalDate.parse(clientDTO.getBirthdate()));
        log.debug("client after mapping and setting occpuation and gender: {}", client);
        userInsertRepository.createClient(client);

    }
}
