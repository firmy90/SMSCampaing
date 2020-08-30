package com.marketing.smscampaing.services;

import com.marketing.smscampaing.dtos.AuthorizationParameterDTO;

import java.util.List;

public interface AuthorizationService {
    AuthorizationParameterDTO getauthorizationParametersById(Long id);
    List<AuthorizationParameterDTO> findAllAuthorizations();
}
