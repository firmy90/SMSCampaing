package com.marketing.smscampaing.services.implementations;

import com.marketing.smscampaing.dtos.AuthorizationParameterDTO;
import com.marketing.smscampaing.model.domain.entity.AuthorizationParameter;
import com.marketing.smscampaing.model.repositories.AuthorizationRepository;
import com.marketing.smscampaing.services.interfaces.AuthorizationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class DefaultAuthorizationService implements AuthorizationService {
    private final AuthorizationRepository authorizationRepository;

    @Override
    public AuthorizationParameterDTO getauthorizationParametersById(Long id) {
        return null;
    }

    @Override
    public List<AuthorizationParameterDTO> findAllAuthorizations() {
        List<AuthorizationParameter> auths = authorizationRepository.findAllByActiveIsTrue();
        ModelMapper myModel = new ModelMapper();
        List<AuthorizationParameterDTO> authsdto = auths
                .stream()
                .map(el -> myModel.map(el, AuthorizationParameterDTO.class)).collect(Collectors.toList());
        log.debug("All authorization parameters: {}", authsdto.toString());
        return authsdto;
    }
}
