package com.marketing.smscampaing.services;

import com.marketing.smscampaing.dtos.AuthorizationParameterDTO;

public interface MessageSenderService {
     boolean sendMessage(AuthorizationParameterDTO parameters);
}
