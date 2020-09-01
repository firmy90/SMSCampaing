package com.marketing.smscampaing.services.interfaces;

import com.marketing.smscampaing.dtos.GenderDTO;

import java.util.List;

public interface GenderService {
    List<GenderDTO> findAllGenders();
}
