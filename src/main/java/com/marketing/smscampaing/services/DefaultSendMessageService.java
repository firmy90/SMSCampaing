package com.marketing.smscampaing.services;

import com.marketing.smscampaing.dtos.CampaingMessageDTO;
import com.marketing.smscampaing.dtos.PhoneDTO;
import com.marketing.smscampaing.integration.MainAPI;
import com.marketing.smscampaing.model.domain.entity.*;
import com.marketing.smscampaing.model.repositories.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;

import java.io.IOException;

import static java.time.LocalDateTime.now;

@Service
@AllArgsConstructor
@Slf4j
public class DefaultSendMessageService implements SendMessageService {
    private final CampaingMessageRepository campaingMessageRepository;
    private final ModelMapper modelMapper;
    private final AuthorizationRepository authorizationRepository;
    private final CampaingRepository campaingRepository;
    private final ClientsCampaingRepository clientsCampaingRepository;
    private final PhoneNumbersRepository phoneNumbersRepository;

    @Override
    public int sendMessage(PhoneDTO phoneDTO, CampaingMessageDTO campaingMessageDTO) throws IOException {
        if (campaingMessageDTO.getAuthorizationParameter().getId()==1){
//            int code = MainAPI.sendMessagesToClient(campaingMessageDTO.getAuthorizationParameter().getUrl(),
//                    phoneDTO.getNumber(),
//                    campaingMessageDTO.getContent(),
//                    campaingMessageDTO.getAuthorizationParameter().getApiKey());
            int code = 202;
            log.debug("Result code from service: {}",code);
            log.debug("Parameter campaingMessageDTO: {}",campaingMessageDTO);
            log.debug("Parameter phoneDTO: {}",phoneDTO);
            return code;
        }
        return 0;
    }



    @Override
    @Transactional
    public void saveCampaignMessage(PhoneDTO phoneDTO, CampaingMessageDTO campaingMessageDTO, int status){
        log.debug("Campaing message before mapping: {}", campaingMessageDTO);
        CampaingMessage campaingMessage = new CampaingMessage();

        Long authId = campaingMessageDTO.getAuthorizationParameter().getId();
        AuthorizationParameter authorization = authorizationRepository.findFirstById(authId);
        campaingMessage.setAuthorization(authorization);
        campaingMessage.setAuthorizationId(authorization.getId());

        Campaing campaing = campaingRepository.findAllById(campaingMessageDTO.getId());
        log.debug("Campaing chosen from query: {}",campaing);
        campaingMessage.setCampaing(campaing);
        campaingMessage.setCampaingId(campaing.getId());

        Client client = clientsCampaingRepository.findClientByUid(phoneDTO.getClientUid());
        campaingMessage.setClient(client);
        campaingMessage.setClientId(client.getUid());

        Phone phone = phoneNumbersRepository.findFirstById(phoneDTO.getId());
        campaingMessage.setPhone(phone);
        campaingMessage.setPhoneId(phone.getId());
        campaingMessage.setContent(campaingMessageDTO.getContent());
        if (status == 202){
            campaingMessage.setSendingStatus(true);
            campaingMessage.setSendingDate(now());
        }
        log.debug("Campaing message after mapping from  DTO: {}", campaingMessage);
        campaingMessageRepository.save(campaingMessage);

    }
}
