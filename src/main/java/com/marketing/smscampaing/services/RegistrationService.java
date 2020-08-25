package com.marketing.smscampaing.services;

import com.marketing.smscampaing.dtos.RegistrationDTO;
import com.marketing.smscampaing.model.domain.entity.User;

public interface RegistrationService {

    void register(RegistrationDTO registrationDTO);
}
