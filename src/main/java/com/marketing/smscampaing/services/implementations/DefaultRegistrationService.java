package com.marketing.smscampaing.services.implementations;

import com.marketing.smscampaing.dtos.ChangePasswordDTO;
import com.marketing.smscampaing.dtos.RegistrationDTO;
import com.marketing.smscampaing.model.domain.entity.User;
import com.marketing.smscampaing.model.repositories.UserRepository;
import com.marketing.smscampaing.services.interfaces.RegistrationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Slf4j
@AllArgsConstructor
public class DefaultRegistrationService implements RegistrationService {
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Override
    public void register(RegistrationDTO registrationDTO) {
        log.debug("Registration data to create user: {}", registrationDTO);
        User user = modelMapper.map(registrationDTO, User.class);
        log.debug("User after mapping from registrationData: {}", user);
        String encdodedPswd = passwordEncoder.encode(registrationDTO.getPassword());
        user.setPassword(encdodedPswd);
        user.setVisible(Boolean.TRUE);
        log.debug("User before action save: {}", user);
        userRepository.save(user);
        log.debug("User after action save: {} ", userRepository.findUserByUsername(user.getUsername()));

    }

    @Override
    @Transactional
    public int changePassword(ChangePasswordDTO changePasswordDTO) {
        log.debug("Change password data of the user : {}", changePasswordDTO);
        User user = modelMapper.map(changePasswordDTO, User.class);
        log.debug("User after mapping from passwordData: {}", user);
        String encdodedPswd = passwordEncoder.encode(changePasswordDTO.getPassword());
        user.setPassword(encdodedPswd);
        user.setVisible(Boolean.TRUE);
        log.debug("User before updated password {}", user);
        int i = userRepository.updateUserPassword(user.getPassword(), user.getUsername());
        log.debug("User after updated password: {} ", userRepository.findUserByUsername(user.getUsername()));
        log.debug("Number of values changed by update: {}", i);
        return i;
    }

    @Override
    public ChangePasswordDTO getDataToChangePassword() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        log.debug("Username of the present user: {}", name);
        User userByUsername = userRepository.findUserByUsername(name);
        log.debug("Data from user taken from query by name: {}", userByUsername);
        ChangePasswordDTO map = modelMapper.map(userByUsername, ChangePasswordDTO.class);
        log.debug("Mapped data to ChangePasswordDTO: {} ", map);

        return map;
    }

    @Override
    public RegistrationDTO getLastRegisterUser() {
        User firstByIdOrderByIdDesc = userRepository.findFirstdOrderByIdDesc();
        log.debug("User taken from database: {}", firstByIdOrderByIdDesc);
        RegistrationDTO userMapped = modelMapper.map(firstByIdOrderByIdDesc, RegistrationDTO.class);
        log.debug("User after mapping to RegistrationDTO: {}", userMapped);

        return userMapped;
    }


}
