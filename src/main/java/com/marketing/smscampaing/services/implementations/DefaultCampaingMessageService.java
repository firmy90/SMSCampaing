package com.marketing.smscampaing.services.implementations;

import com.marketing.smscampaing.dtos.AuthorizationParameterDTO;
import com.marketing.smscampaing.dtos.CampaingMessageDTO;
import com.marketing.smscampaing.model.domain.entity.AuthorizationParameter;
import com.marketing.smscampaing.model.domain.entity.Campaing;
import com.marketing.smscampaing.model.domain.entity.CampaingMessage;
import com.marketing.smscampaing.model.repositories.AuthorizationRepository;
import com.marketing.smscampaing.model.repositories.CampaingMessageRepository;
import com.marketing.smscampaing.model.repositories.CampaingRepository;
import com.marketing.smscampaing.services.interfaces.CampaingMessageService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class DefaultCampaingMessageService implements CampaingMessageService {
    private final CampaingMessageRepository campaingMessageRepository;
    private final CampaingRepository campaingRepository;
    private final AuthorizationRepository authorizationRepository;
    private final ModelMapper modelMapper;


    @Override
    public CampaingMessageDTO getCampaingByName(String name, Long id) {
        Campaing firstByCname = campaingRepository.findFirstByCname(name);
        log.debug("Chosen campaing message name: {}", firstByCname.toString());
        AuthorizationParameter byId = authorizationRepository.findFirstById(id);
        log.debug("Chosen authorization repository before mapping: {}", byId.toString());
        AuthorizationParameterDTO authorizationParameterDTO = modelMapper.map(byId, AuthorizationParameterDTO.class);
        log.debug("Chosen authorization repository after mapping: {}", authorizationParameterDTO.toString());
        CampaingMessageDTO campaingMessageDTO = modelMapper.map(firstByCname, CampaingMessageDTO.class);
        log.debug("Chosen campaing after mapping: {}", campaingMessageDTO.toString());
        campaingMessageDTO.setAuthorizationParameter(authorizationParameterDTO);
        log.debug("Chosen campaing message DTO after mapping: {}", campaingMessageDTO.toString());
        return campaingMessageDTO;
    }

    @Override
    public Page<CampaingMessageDTO> findPaginatedDTO(int pageNo, int pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(Sort.Direction.DESC, "id"));
        Page<CampaingMessage> all = campaingMessageRepository.findAll(paging);
        log.debug("Page of Message Campaing: {}", all);
        ModelMapper mapper = new ModelMapper();
        Page<CampaingMessageDTO>  map = (Page<CampaingMessageDTO>) mapper.map(all, Page.class);
        log.debug("Page<CampaingMessageDTO>: {}",map);
        return map;
    }
}

