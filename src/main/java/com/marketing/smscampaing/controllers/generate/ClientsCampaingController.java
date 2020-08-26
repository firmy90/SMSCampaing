package com.marketing.smscampaing.controllers.generate;

import com.marketing.smscampaing.dtos.ClientsPhoneCountryDTO;
import com.marketing.smscampaing.dtos.OccupationDTO;
import com.marketing.smscampaing.dtos.PurposeDTO;
import com.marketing.smscampaing.dtos.TypeDTO;
import com.marketing.smscampaing.services.OccupationService;
import com.marketing.smscampaing.services.PurposeService;
import com.marketing.smscampaing.services.TypeService;
import com.marketing.smscampaing.services.generate.ClientsCampaingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/generate/clients")
public class ClientsCampaingController {
    private final ClientsCampaingService clientsCampaingService;
    private final OccupationService occupationService;
    private final TypeService typeService;
    private final PurposeService purposeService;

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
        List<TypeDTO> allTypes = typeService.findAllTypes();
        model.addAttribute("allTypes",allTypes);
        List<PurposeDTO> allPurposes = purposeService.findAllPurposes();
        model.addAttribute("allPurposes",allPurposes);
        return "generate-clients";

    }


}
