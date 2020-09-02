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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        return "/admin/admin-register-page";
    }

    @PostMapping
    public String procesRegistrationPage(@ModelAttribute("registrationData") @Valid RegistrationDTO registrationDTO,
                                         BindingResult results, Model model, RedirectAttributes redirectAttributes) {
        if (results.hasErrors()) {
            return "/admin/admin-register-page";
        }
        registrationService.register(registrationDTO);
        log.debug("Newly added user: {}", registrationDTO);
        model.addAttribute("registrationData", registrationDTO);
        redirectAttributes.addFlashAttribute("AttributeUsername", registrationDTO.getUsername());
        redirectAttributes.addFlashAttribute("AttributeName", registrationDTO.getName());
        redirectAttributes.addFlashAttribute("AttributeSurname", registrationDTO.getSurname());
        return "redirect:/admin/register/show";
    }

    @GetMapping("/show")
    public String showAddedUser(@ModelAttribute("registrationData") RegistrationDTO registrationDTO, Model model) {
        String attributeUsername = (String) model.getAttribute("AttributeUsername");
        log.debug("Model AttributeUsername: {}", attributeUsername);
        log.debug("Model AttributeName: {}", model.getAttribute("AttributeName"));
        log.debug("Model AttributeSurname: {}", model.getAttribute("AttributeSurname"));
        if (attributeUsername==null){
            RegistrationDTO lastRegisterUser = registrationService.getLastRegisterUser();
            log.debug("Model AttributeUsername from database: {}", lastRegisterUser.getUsername());
            log.debug("Model AttributeName from database: {}", lastRegisterUser.getName());
            log.debug("Model AttributeSurname from database: {}", lastRegisterUser.getSurname());
            model.addAttribute("AttributeUsername",lastRegisterUser.getUsername());
            model.addAttribute("AttributeName",lastRegisterUser.getName());
            model.addAttribute("AttributeSurname",lastRegisterUser.getSurname());
        }
        return "/admin/admin-register-show-page";

    }


}
