package com.marketing.smscampaing.services.implementations;

import com.marketing.smscampaing.dtos.ClientsPhoneCountryDTO;
import com.marketing.smscampaing.model.domain.entity.Client;
import com.marketing.smscampaing.model.repositories.ClientsCampaingRepository;
import com.marketing.smscampaing.services.interfaces.ClientsCampaingService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
@AllArgsConstructor
public class DefaultClientsCampaingService  implements ClientsCampaingService {
    private final ModelMapper modelMapper;
    private final ClientsCampaingRepository clientsCampaingRepository;



    @Override
    public List<ClientsPhoneCountryDTO> showLastClients() {
        List<Client> clientsPhonesCountryOrderByUpdateDesc = clientsCampaingRepository.findClientsPhonesCountryOrderByUpdateDesc();
        log.info("Clients before mapping from lastClients: {}", clientsPhonesCountryOrderByUpdateDesc);
        ModelMapper myModel = new ModelMapper();
        myModel.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        List<ClientsPhoneCountryDTO> clients = clientsPhonesCountryOrderByUpdateDesc
                .stream()
                .map(el -> myModel.map(el, ClientsPhoneCountryDTO.class))
                .collect(Collectors.toList());
        log.info("Clients after mapping from lastClients: {}",clients);

        return clients;
    }


}
