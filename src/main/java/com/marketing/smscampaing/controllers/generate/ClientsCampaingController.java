package com.marketing.smscampaing.controllers.generate;

import com.marketing.smscampaing.dtos.ClientsPhoneCountryDTO;
import com.marketing.smscampaing.services.generate.ClientsCampaingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/generate/clients")
public class ClientsCampaingController {
//    private final ClientsCampaingService clientsCampaingService;
//
//    @GetMapping
//    public String showLastClients(Model model){
//        model.addAttribute("lastClients", new ClientsPhoneCountryDTO());
//        return "clients-page";
//
//    }


}
