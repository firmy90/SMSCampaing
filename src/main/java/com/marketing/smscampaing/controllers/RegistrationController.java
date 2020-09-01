package com.marketing.smscampaing.controllers;

import com.marketing.smscampaing.dtos.RegistrationDTO;
import com.marketing.smscampaing.services.interfaces.RegistrationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
@RequestMapping("/admin/register")
public class RegistrationController {
    private final RegistrationService registrationService;


    @GetMapping
    public String prepareRegistrationPage(Model model) {
        model.addAttribute("registrationData", new RegistrationDTO());
        return "admin-register-page";
    }

    @PostMapping
    public String procesRegistrationPage(@ModelAttribute("registrationData") @Valid RegistrationDTO registrationDTO,
                                         BindingResult results) {
        if(results.hasErrors()){
            return "admin-register-page";
        }
        registrationService.register(registrationDTO);
        return "redirect:/";
    }
}
