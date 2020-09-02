package com.marketing.smscampaing.controllers;

import com.marketing.smscampaing.dtos.ClientDTO;
import com.marketing.smscampaing.dtos.GenderDTO;
import com.marketing.smscampaing.dtos.OccupationDTO;
import com.marketing.smscampaing.services.interfaces.CreateClientService;
import com.marketing.smscampaing.services.interfaces.GenderService;
import com.marketing.smscampaing.services.interfaces.OccupationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@Slf4j
@AllArgsConstructor
@RequestMapping("/create/client")
public class CreateClientController {

    private final GenderService genderService;
    private final OccupationService occupationService;
    private final CreateClientService createClientService;

    @GetMapping
    public String prepareClient(@ModelAttribute("clientData") ClientDTO clientDTO,Model model) {
        List<GenderDTO> genders = genderService.findAllGenders();
        log.debug("genders: {}", genders);
        model.addAttribute("genders", genders);

        List<OccupationDTO> occupations = occupationService.showOccupations();
        log.debug("occupations: {}", occupations);
        model.addAttribute("occupations", occupations);
        model.addAttribute("clientData",new ClientDTO());

        return "create-client";

    }

    @PostMapping
    public String createClient(@ModelAttribute("clientData") @Valid ClientDTO clientDTO, BindingResult bindingResult,
                               @RequestParam(required = false, defaultValue = "UNKNOWN") String gender,
                               @RequestParam(required = false, defaultValue = "Other") String occupation,
                               Model model) {
        if(bindingResult.hasErrors()){
            List<GenderDTO> genders = genderService.findAllGenders();
            log.debug("genders: {}", genders);
            model.addAttribute("genders", genders);

            List<OccupationDTO> occupations = occupationService.showOccupations();
            log.debug("occupations: {}", occupations);
            model.addAttribute("occupations", occupations);
            model.addAttribute("clientData",clientDTO);
            log.debug("ClientDTO with errors: {}", clientDTO);
            log.debug("Chosen gender: {}",gender);
            log.debug("Chosen occupation: {}",occupation);

            return "create-client";
        }
        log.debug("Chosen gender: {}",gender);
        log.debug("Chosen occupation: {}",occupation);
        clientDTO.setGenderGender(gender);
        clientDTO.setOccupationOccupation(occupation);
        log.debug("Client before saving to database: {}", clientDTO);
        boolean res = createClientService.createClient(clientDTO);
        if (res){
            clientDTO.setCode(1);
            model.addAttribute("clientData",clientDTO);
        }
        return "redirect:/show/clients";

    }

}
