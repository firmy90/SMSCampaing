package com.marketing.smscampaing.services;

import com.marketing.smscampaing.dtos.PurposeDTO;

import java.util.List;

public interface PurposeService {
    List<PurposeDTO> findAllPurposes();
}
