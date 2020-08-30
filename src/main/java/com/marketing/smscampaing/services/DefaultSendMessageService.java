package com.marketing.smscampaing.services;

import com.marketing.smscampaing.dtos.CampaingMessageDTO;
import com.marketing.smscampaing.dtos.PhoneDTO;
import com.marketing.smscampaing.integration.MainAPI;
import com.marketing.smscampaing.model.domain.entity.CampaingMessage;
import com.marketing.smscampaing.model.repositories.CampaingMessageRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@AllArgsConstructor
@Slf4j
public class DefaultSendMessageService implements SendMessageService {
    private final CampaingMessageRepository campaingMessageRepository;

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

//            campaingMessageRepository.save();
            return code;
        }

        return 0;
    }
}
