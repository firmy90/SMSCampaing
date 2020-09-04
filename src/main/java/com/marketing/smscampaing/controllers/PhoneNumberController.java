package com.marketing.smscampaing.controllers;

import com.marketing.smscampaing.dtos.PhoneDTO;
import com.marketing.smscampaing.services.interfaces.PhonesNumberService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@Slf4j
@AllArgsConstructor
@RequestMapping("/show")
public class PhoneNumberController {
    private final PhonesNumberService phonesNumberService;

    // TODO Tutaj również Optional w parametrach i zmienne ścieżki zamiast poprawnie parametrów żądania
    @RequestMapping(value = {"/phones/{pageNoOpt:\\d+}/{pageSizeOpt:\\d+}", "/phones", "/phones/{pageNoOpt:\\d+}"}, method = RequestMethod.GET)
    public String showAllPhoneNumbers(@PathVariable("pageNoOpt") Optional<Integer> pageNoOpt, @PathVariable("pageSizeOpt") Optional<Integer> pageSizeOpt, Model model) {
        int pageNo = pageNoOpt.orElse(1);
        int pageSize = pageSizeOpt.orElse(10);
        if (pageNo <= 0) {
            pageNo = 1;
        }
        if (pageSize <= 0) {
            pageSize = 10;
        }
        Page<PhoneDTO> phoneDTOPage = phonesNumberService.findPaginatedDTO(pageNo - 1, pageSize);
        List<PhoneDTO> phoneDTOList = phoneDTOPage.getContent();
        log.debug("phoneDTOPage List: {}", phoneDTOPage);
        log.debug("phoneDTOList List: {}", phoneDTOList);
        model.addAttribute("phones", phoneDTOList);
        model.addAttribute("phoneDTOPage", phoneDTOPage);
//        model.addAttribute("phoneDTOList", phoneDTOList);
        int clientSize = phoneDTOList.size();
        model.addAttribute("clientSize", clientSize);
        int totalPages = phoneDTOPage.getTotalPages();
        long totalElements = phoneDTOPage.getTotalElements();
        int number = phoneDTOPage.getNumber();
        log.debug("totalPages: {}", totalPages);
        log.debug("totalElements: {}", totalElements);
        log.debug("number: {}", number);
        int pageNumber = countCorrectNumberPage(phoneDTOPage.getNumber(), phoneDTOPage.getTotalPages());
        model.addAttribute("pageNumber", pageNumber + 1);
        return "/show/phones-page";
    }


    public int countCorrectNumberPage(int number, int totalPages) {
        if (number < 0) {
            return 1;
        }
        if (number > totalPages) {
            return totalPages + 1;
        }
        return number;
    }
}
