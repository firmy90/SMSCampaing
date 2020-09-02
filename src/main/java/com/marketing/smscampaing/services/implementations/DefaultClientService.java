package com.marketing.smscampaing.services.implementations;

import com.marketing.smscampaing.dtos.ClientDTO;
import com.marketing.smscampaing.model.domain.entity.Client;
import com.marketing.smscampaing.model.repositories.ClientRepository;
import com.marketing.smscampaing.services.interfaces.ClientService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class DefaultClientService implements ClientService {
    private final ClientRepository clientRepository;

    @Override
    public Page<ClientDTO> findPaginatedDTO(int pageNo, int pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(Sort.Direction.DESC, "uid"));
        Page<Client> all = clientRepository.findAll(paging);
        log.debug("Page with clients: {}", all);
        ModelMapper mapper = new ModelMapper();
        Page<ClientDTO> clientDTOS = mapper.map(all, Page.class);
        log.debug("Page of clients DTO after mapping: {}", clientDTOS);
        return clientDTOS;
    }
}



