package com.marketing.smscampaing.services;

import com.marketing.smscampaing.dtos.GenderDTO;

import java.util.List;

public interface GenderService {
    List<GenderDTO> findAllGenders();
}
