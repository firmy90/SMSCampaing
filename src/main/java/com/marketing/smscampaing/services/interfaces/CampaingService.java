package com.marketing.smscampaing.services.interfaces;

import com.marketing.smscampaing.dtos.CampaingDTO;

import java.util.List;

public interface CampaingService {

    List<CampaingDTO> showLastCampaings();

}
