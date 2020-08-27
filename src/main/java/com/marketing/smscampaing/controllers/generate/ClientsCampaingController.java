package com.marketing.smscampaing.controllers.generate;

import com.marketing.smscampaing.dtos.*;
import com.marketing.smscampaing.services.OccupationService;
import com.marketing.smscampaing.services.PurposeService;
import com.marketing.smscampaing.services.SelectorsService;
import com.marketing.smscampaing.services.TypeService;
import com.marketing.smscampaing.services.generate.ClientsCampaingService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller @Slf4j
@AllArgsConstructor
@RequestMapping("/generate/clients")
public class ClientsCampaingController {
    private final ClientsCampaingService clientsCampaingService;
    private final OccupationService occupationService;
    private final TypeService typeService;
    private final PurposeService purposeService;
    private final SelectorsService selectorsService;

    @PostMapping
    @ResponseBody
    public String showLastClients(Model model){
        List<ClientsPhoneCountryDTO> clientsPhoneCountryDTOS = clientsCampaingService.showLastClients();
        model.addAttribute("clients", clientsPhoneCountryDTOS);
        return clientsPhoneCountryDTOS.toString();
//        return "generate-clients";

    }

    @GetMapping
    public String filtrClients(Model model){
        List<OccupationDTO> occupationDTOS = occupationService.showOccupations();
        model.addAttribute("allOccupations", occupationDTOS);
        log.info("occupations list: {}", occupationDTOS.toString());
        List<TypeDTO> allTypes = typeService.findAllTypes();
        model.addAttribute("allTypes",allTypes);
        List<PurposeDTO> allPurposes = purposeService.findAllPurposes();
        model.addAttribute("allPurposes",allPurposes);
        SelectorsDTO allSelectors = selectorsService.findAllSelectors();
        log.info("allSelectors: {}", allSelectors.toString());
        List<String> genderGender = allSelectors.getGenders();
        model.addAttribute("allGenders",genderGender);
        log.info("genders list: {}", genderGender.toString());
        model.addAttribute("allOccupations",allSelectors.getOccupations());
        log.info("occupations list: {}", allSelectors.getOccupations().toString());
        return "generate-clients";

    }


}
