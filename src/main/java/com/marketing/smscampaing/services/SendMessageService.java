package com.marketing.smscampaing.services;

import com.marketing.smscampaing.dtos.CampaingMessageDTO;
import com.marketing.smscampaing.dtos.PhoneDTO;

import java.io.IOException;

public interface SendMessageService {

    int sendMessage(PhoneDTO phoneDTO, CampaingMessageDTO campaingMessageDTO) throws IOException;
}
