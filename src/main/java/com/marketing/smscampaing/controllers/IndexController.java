package com.marketing.smscampaing.controllers;

import com.marketing.smscampaing.dtos.CampaingDTO;
import com.marketing.smscampaing.services.interfaces.CampaingService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller @Slf4j
@RequestMapping("/")
@AllArgsConstructor
public class IndexController {
    private final CampaingService campaingService;

    @GetMapping
    public String showWelcomePage(Model model){
        List<CampaingDTO> campaingDTOS = campaingService.showLastCampaings();
        model.addAttribute("campaings",campaingDTOS);
        log.debug("Campaings: {}", campaingDTOS.toString());
        return "index";
    }
}
