package com.marketing.smscampaing.services;

import com.marketing.smscampaing.dtos.AuthorizationParameterDTO;
import com.marketing.smscampaing.dtos.CampaingDTO;
import com.marketing.smscampaing.dtos.CampaingMessageDTO;
import com.marketing.smscampaing.model.domain.entity.AuthorizationParameter;
import com.marketing.smscampaing.model.domain.entity.Campaing;
import com.marketing.smscampaing.model.domain.entity.CampaingMessage;
import com.marketing.smscampaing.model.repositories.AuthorizationRepository;
import com.marketing.smscampaing.model.repositories.CampaingMessageRepository;
import com.marketing.smscampaing.model.repositories.CampaingRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
@Slf4j
public class DefaultCampaingMessageService implements CampaingMessageService {

    private final CampaingMessageRepository campaingMessageRepository;
    private final CampaingRepository campaingRepository;
    private final AuthorizationRepository authorizationRepository;
    private final ModelMapper modelMapper;


    @Override
    public CampaingMessageDTO getCampaingByName(String cname, Long authId) {
        Campaing firstByCname = campaingRepository.findFirstByCname(cname);
        log.debug("Chosen campaing message name: {}", firstByCname.toString());
//        CampaingMessage firstByCampaing = campaingMessageRepository.findFirstByCampaingId(firstByCname.getId());
//        log.debug("Chosen campaing Message message name: {}", firstByCampaing.toString());
        AuthorizationParameter byId = authorizationRepository.findFirstById(authId);
        log.debug("Chosen authorization repository before mapping: {}", byId.toString());
        AuthorizationParameterDTO authorizationParameterDTO = modelMapper.map(byId, AuthorizationParameterDTO.class);
        log.debug("Chosen authorization repository after mapping: {}", authorizationParameterDTO.toString());
        CampaingMessageDTO campaingMessageDTO = modelMapper.map(firstByCname, CampaingMessageDTO.class);
        log.debug("Chosen campaing after mapping: {}", campaingMessageDTO.toString());
        campaingMessageDTO.setAuthorizationParameter(authorizationParameterDTO);
        log.debug("Chosen campaing message DTO after mapping: {}", campaingMessageDTO.toString());
        return campaingMessageDTO;
    }
}
