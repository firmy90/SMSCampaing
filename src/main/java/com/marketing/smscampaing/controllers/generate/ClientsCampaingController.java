package com.marketing.smscampaing.controllers.generate;

import com.marketing.smscampaing.dtos.*;
import com.marketing.smscampaing.services.*;
import com.marketing.smscampaing.services.generate.ClientsCampaingService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@Slf4j
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
    public String showLastClients(@RequestParam(required = false, defaultValue = "0") String ageMin,
                                  @RequestParam(required = false, defaultValue = "") String ageMax,
                                  @RequestParam(required = false, defaultValue = "") @Param("gender") List<String> gender,
                                  @RequestParam(required = false, defaultValue = "") @Param("occupation") List<String> occupation,
                                  @RequestParam(required = false, defaultValue = "") @Param("purpose") List<String> purpose,
                                  @RequestParam(required = false, defaultValue = "") @Param("type") List<String> type,
                                  @RequestParam(required = false, defaultValue = "") @Param("country") List<String> country,
                                  Model model) {
        log.info("RequestParam ageMin: {}", ageMin);
        log.info("RequestParam ageMax: {}", ageMax);
        log.info("RequestParam gender: {}", gender.toString());
        log.info("RequestParam occupation: {}", occupation.toString());
        log.info("RequestParam purpose: {}", purpose.toString());
        log.info("RequestParam type: {}", type.toString());
        log.info("RequestParam country: {}", country.toString());
        LocalDate minDate = LocalDate.MIN;
        LocalDate maxDate = LocalDate.MAX;
        try {
            int minInt = Integer.parseInt(ageMin);
            if (minInt < 0) {
                minInt = 0;
            }
            maxDate = LocalDate.now().minusYears(minInt);
            log.info("maxDate : {}", maxDate);
        } catch (NumberFormatException ignored) {
            log.info("AgeMin not a number: {}", ageMin);
        }
        try {
            int maxInt = Integer.parseInt(ageMax);
            if (maxInt < 0) {
                 maxInt=0;
            }
            minDate = LocalDate.now().minusYears(maxInt);
            log.info("minDate : {}", minDate);
        } catch (NumberFormatException ignored) {
            log.info("AgeMax not a number: {}", ageMax);
        }

        List<PhoneDTO> phoneDTOS = phonesNumberService.showByParams(minDate, maxDate, gender, occupation, purpose, type, country);
        log.info("phoneDTOS from query before mapping: {}", phoneDTOS.toString());
        model.addAttribute("phones", phoneDTOS);
        log.info("phoneDTOS from query after mapping: {}", phoneDTOS.toString());
        return "phones-page";

    }

    @GetMapping
    public String filtrClients(Model model) {
        List<OccupationDTO> occupationDTOS = occupationService.showOccupations();
        model.addAttribute("allOccupations", occupationDTOS);
        log.info("occupations list: {}", occupationDTOS.toString());
        List<TypeDTO> allTypes = typeService.findAllTypes();
        model.addAttribute("allTypes", allTypes);
        List<PurposeDTO> allPurposes = purposeService.findAllPurposes();
        model.addAttribute("allPurposes", allPurposes);
        List<GenderDTO> allGenders = genderService.findAllGenders();
        model.addAttribute("allGenders", allGenders);
        log.info("genders list: {}", allGenders.toString());
        List<CountryDTO> allCountries = countryService.findAllCountries();
        model.addAttribute("allCountries", allCountries);
        log.info("occupations list: {}", allCountries);
        return "generate-clients";

    }


}
