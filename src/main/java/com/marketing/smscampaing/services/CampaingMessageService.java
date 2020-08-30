package com.marketing.smscampaing.services;

import com.marketing.smscampaing.dtos.CampaingMessageDTO;

public interface CampaingMessageService {
    CampaingMessageDTO getCampaingByName(String name,Long id);
}
