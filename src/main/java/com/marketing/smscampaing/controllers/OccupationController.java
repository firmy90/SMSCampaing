package com.marketing.smscampaing.controllers;

import com.marketing.smscampaing.dtos.OccupationDTO;
import com.marketing.smscampaing.services.interfaces.OccupationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@AllArgsConstructor
@RequestMapping("/show/occupations")
public class OccupationController {
    private final OccupationService occupationService;

    @GetMapping
    public String showOccupations(Model model){
        List<OccupationDTO> occupations = occupationService.showOccupations();
        log.debug("Occupation DTO list: {}", occupations.toString());
        model.addAttribute("occupations", occupations);
        return "occupations-page";
    }
}
