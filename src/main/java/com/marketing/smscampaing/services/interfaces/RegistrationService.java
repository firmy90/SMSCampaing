package com.marketing.smscampaing.services.interfaces;

import com.marketing.smscampaing.dtos.ChangePasswordDTO;
import com.marketing.smscampaing.dtos.RegistrationDTO;

public interface RegistrationService {

    void register(RegistrationDTO registrationDTO);
    int changePassword(ChangePasswordDTO changePasswordDTO);
    ChangePasswordDTO getDataToChangePassword();
    RegistrationDTO getLastRegisterUser();
}
