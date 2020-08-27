package com.marketing.smscampaing.controllers.generate;

import com.marketing.smscampaing.dtos.*;
import com.marketing.smscampaing.services.*;
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
    private final GenderService genderService;
    private final CountryService countryService;
    private final PhonesNumberService phonesNumberService;

    @PostMapping
    @ResponseBody
    public String showLastClients(Model model){
        List<PhoneDTO> phoneDTOS = phonesNumberService.showAllPhones();
        log.info("phoneDTOS before mapping: {}", phoneDTOS.toString());
        model.addAttribute("phones",phoneDTOS);
        log.info("phoneDTOS after mapping: {}", phoneDTOS.toString());
        return phoneDTOS.toString();
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
        List<GenderDTO> allGenders = genderService.findAllGenders();
        model.addAttribute("allGenders",allGenders);
        log.info("genders list: {}", allGenders.toString());
        List<CountryDTO> allCountries = countryService.findAllCountries();
        model.addAttribute("allCountries",allCountries);
        log.info("occupations list: {}", allCountries);
        return "generate-clients";

    }


}
