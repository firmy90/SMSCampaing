package com.marketing.smscampaing.controllers;

import com.marketing.smscampaing.dtos.RegistrationDTO;
import com.marketing.smscampaing.services.RegistrationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/register")
public class RegistrationController {
    private final RegistrationService registrationService;

    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }


    @GetMapping
    public String prepareRegistrationPage(Model model) {
        model.addAttribute("registrationData", new RegistrationDTO());
        return "registration-page";
    }

    @PostMapping
    public String procesRegistrationPage(@ModelAttribute("registrationData") RegistrationDTO registrationDTO) {
        registrationService.register(registrationDTO);
        return "redirect:/";
    }
}
