package com.marketing.smscampaing.services.generate;

import com.marketing.smscampaing.dtos.ClientsPhoneCountryDTO;
import com.marketing.smscampaing.model.domain.entity.Client;
import com.marketing.smscampaing.model.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.util.List;

@Service
@Transactional
@Slf4j
@AllArgsConstructor
public class DefaultClientsCampaingService {
//        implements ClientsCampaingService {
    private final ModelMapper modelMapper;
//    private final ClientsCampaingService clientsCampaingService;


//    @Override
//    public List<Client> showLastClients(ClientsPhoneCountryDTO clientsPhoneCountryDTO) {
//        log.info("Registration data to get clients: {}", clientsPhoneCountryDTO);
//        List<Client> clients = modelMapper.map(clientsPhoneCountryDTO, (Type) Client.class);
//        log.info("Clients after mapping from lastClients: {}",clients);
//
//        return clients;
//    }
}
