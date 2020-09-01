package com.marketing.smscampaing.controllers;

import com.marketing.smscampaing.dtos.ChangePasswordDTO;
import com.marketing.smscampaing.services.RegistrationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Slf4j
@Controller
@AllArgsConstructor
@RequestMapping("/change/password")
public class UserChangePasswordController {
    private final RegistrationService registrationService;


    @GetMapping
    public String prepareRegistrationPage(@ModelAttribute("passwordData") ChangePasswordDTO changePasswordDTO, Model model) {
        ChangePasswordDTO dataToChangePassword = registrationService.getDataToChangePassword();
        dataToChangePassword.setPassword(null);
        log.debug("PasswordData: {}", dataToChangePassword);
        model.addAttribute("passwordData", dataToChangePassword);
        log.debug("Data from modelAttribute changePasswordDTO: {}", model.getAttribute("paswordData"));
        return "change-password-page";
    }

    @PostMapping
    public String procesRegistrationPage(@ModelAttribute("passwordData") @Valid ChangePasswordDTO changePasswordDTO, BindingResult results, Model model) {
        if (results.hasErrors()) {
            log.debug("Data from changePasswordDTO: {}", changePasswordDTO);
            model.addAttribute("passwordData", changePasswordDTO);
            ChangePasswordDTO passwordData = (ChangePasswordDTO) model.getAttribute("passwordData");
            log.debug("PasswordData taken from model Attribute: {}", passwordData);
            return "change-password-page";
        }
        registrationService.changePassword(changePasswordDTO);
        return "redirect:/";
    }
}
