package com.marketing.smscampaing.controllers;

import com.marketing.smscampaing.dtos.PhoneDTO;
import com.marketing.smscampaing.services.PhonesNumberService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/phones")
public class PhoneNumberController {
    private final PhonesNumberService phonesNumberService;

    @GetMapping
    public String showAllPhoneNumbers(Model model){
        List<PhoneDTO> phoneDTOS = phonesNumberService.showAllPhones();
        model.addAttribute("phones",phoneDTOS);
        return "/phones-page";
    }
}
