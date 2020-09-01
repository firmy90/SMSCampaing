package com.marketing.smscampaing.services;

import com.marketing.smscampaing.dtos.ChangePasswordDTO;
import com.marketing.smscampaing.dtos.RegistrationDTO;

public interface RegistrationService {

    void register(RegistrationDTO registrationDTO);
    void changePassword(ChangePasswordDTO changePasswordDTO);
    ChangePasswordDTO getDataToChangePassword();
}
