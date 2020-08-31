package com.marketing.smscampaing.services;

import com.marketing.smscampaing.dtos.CampaingMessageDTO;
import com.marketing.smscampaing.model.domain.entity.CampaingMessage;

import java.util.List;

public interface CampaingMessageService {
    CampaingMessageDTO getCampaingByName(String name,Long id);
    List<CampaingMessage> findPaginated(int pageNo, int pageSize);
    List<CampaingMessageDTO> findPaginatedDTO(int pageNo, int pageSize);

}
