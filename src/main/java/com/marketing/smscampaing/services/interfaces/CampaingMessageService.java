package com.marketing.smscampaing.services.interfaces;

import com.marketing.smscampaing.dtos.CampaingMessageDTO;

import java.util.List;

public interface CampaingMessageService {
    CampaingMessageDTO getCampaingByName(String name,Long id);
    List<CampaingMessageDTO> findPaginatedDTO(int pageNo, int pageSize);

}
