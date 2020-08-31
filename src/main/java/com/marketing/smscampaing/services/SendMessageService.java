package com.marketing.smscampaing.services;

import com.marketing.smscampaing.dtos.CampaingMessageDTO;
import com.marketing.smscampaing.dtos.PhoneDTO;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

public interface SendMessageService {

    int sendMessage(PhoneDTO phoneDTO, CampaingMessageDTO campaingMessageDTO) throws IOException;

    void saveCampaignMessage(PhoneDTO phoneDTO, CampaingMessageDTO campaingMessageDTO, int status);
}
