package com.marketing.smscampaing.services.implementations;

import com.marketing.smscampaing.dtos.RegistrationDTO;
import com.marketing.smscampaing.model.domain.entity.User;
import com.marketing.smscampaing.model.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
@AllArgsConstructor
public class DefaultRegistrationService implements RegistrationService {

    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;


    @Override
    public void register(RegistrationDTO registrationDTO) {
        log.debug("Registration data to create user: {}", registrationDTO);
        User user = modelMapper.map(registrationDTO,User.class);
        log.debug("User after mapping from registrationData: {}", user);
        String encdodedPswd = passwordEncoder.encode(registrationDTO.getPassword());
        user.setPassword(encdodedPswd);
        user.setVisible(Boolean.TRUE);
        log.debug("User before action save: {}", user);
        userRepository.save(user);
        log.debug("User after action save: {} ",userRepository.findUserByUsername(user.getUsername()));

    }

}
