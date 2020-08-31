package com.marketing.smscampaing.services.implementations;

import com.marketing.smscampaing.model.repositories.UserRepository;
import com.marketing.smscampaing.services.ValidationService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Getter @Setter @Slf4j
@Service
public class DefaultValidationService implements ValidationService {
    private final UserRepository userRepository;
    @Override
    public boolean isUniqueUsername(String username) {

        return !userRepository.existsByUsername(username);
    }
}
