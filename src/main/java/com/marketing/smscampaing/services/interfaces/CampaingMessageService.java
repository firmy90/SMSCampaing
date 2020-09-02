package com.marketing.smscampaing.services.interfaces;

import com.marketing.smscampaing.dtos.CampaingMessageDTO;
import com.marketing.smscampaing.model.domain.entity.CampaingMessage;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CampaingMessageService {
    CampaingMessageDTO getCampaingByName(String name,Long id);
    Page<CampaingMessageDTO> findPaginatedDTO(int pageNo, int pageSize);

}
