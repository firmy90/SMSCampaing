package com.marketing.smscampaing.controllers;

import com.marketing.smscampaing.dtos.*;
import com.marketing.smscampaing.services.interfaces.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.List;

@Controller
@Slf4j
@AllArgsConstructor
@RequestMapping("/generate/clients")
public class ClientsCampaingController {
     private final OccupationService occupationService;
    private final TypeService typeService;
    private final PurposeService purposeService;
    private final GenderService genderService;
    private final CountryService countryService;
    private final PhonesNumberService phonesNumberService;

    @PostMapping
    public String showLastClients(@RequestParam(required = false, defaultValue = "0") String ageMin,
                                  @RequestParam(required = false, defaultValue = "") String ageMax,
                                  @RequestParam(required = false, defaultValue = "") List<String> gender,
                                  @RequestParam(required = false, defaultValue = "") List<String> occupation,
                                  @RequestParam(required = false, defaultValue = "") List<String> purpose,
                                  @RequestParam(required = false, defaultValue = "") List<String> type,
                                  @RequestParam(required = false, defaultValue = "") List<String> country,
                                  Model model,
                                  HttpSession session) {
        log.debug("RequestParam ageMin: {}", ageMin);
        log.debug("RequestParam ageMax: {}", ageMax);
        log.debug("RequestParam gender: {}", gender.toString());
        log.debug("RequestParam occupation: {}", occupation.toString());
        log.debug("RequestParam purpose: {}", purpose.toString());
        log.debug("RequestParam type: {}", type.toString());
        log.debug("RequestParam country: {}", country.toString());
        LocalDate minDate = LocalDate.MIN;
        LocalDate maxDate = LocalDate.MAX;
        try {
            int minInt = Integer.parseInt(ageMin);
            if (minInt < 0) {
                minInt = 0;
            }
            maxDate = LocalDate.now().minusYears(minInt);
            log.debug("maxDate : {}", maxDate);
        } catch (NumberFormatException ignored) {
            log.debug("AgeMin not a number: {}", ageMin);
        }
        try {
            int maxInt = Integer.parseInt(ageMax);
            if (maxInt < 0) {
                maxInt = 0;
            }
            minDate = LocalDate.now().minusYears(maxInt);
            log.debug("minDate : {}", minDate);
        } catch (NumberFormatException ignored) {
            log.debug("AgeMax not a number: {}", ageMax);
        }

        List<PhoneDTO> phoneDTOS = phonesNumberService.showByParams(minDate, maxDate, gender, occupation, purpose, type, country);
        log.debug("PhoneDTOS from query: {}", phoneDTOS.toString());
        model.addAttribute("phones", phoneDTOS);
        session.setAttribute("phonesSes", phoneDTOS);
//        return "generate-message-page";
        return "redirect:/generate/message";

    }

    @GetMapping
    public String filtrClients(Model model) {
        List<OccupationDTO> occupationDTOS = occupationService.showOccupations();
        model.addAttribute("allOccupations", occupationDTOS);
        log.debug("occupations list: {}", occupationDTOS.toString());

        List<TypeDTO> allTypes = typeService.findAllTypes();
        model.addAttribute("allTypes", allTypes);
        log.debug("types list: {}", allTypes.toString());

        List<PurposeDTO> allPurposes = purposeService.findAllPurposes();
        model.addAttribute("allPurposes", allPurposes);
        log.debug("purposes list: {}", allPurposes.toString());

        List<GenderDTO> allGenders = genderService.findAllGenders();
        model.addAttribute("allGenders", allGenders);
        log.debug("genders list: {}", allGenders.toString());

        List<CountryDTO> allCountries = countryService.findAllCountries();
        model.addAttribute("allCountries", allCountries);
        log.debug("occupations list: {}", allCountries);
        return "/generate/generate-clients";

    }


}
