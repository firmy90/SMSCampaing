package com.marketing.smscampaing.controllers;

import com.marketing.smscampaing.dtos.ClientDTO;
import com.marketing.smscampaing.dtos.ClientsPhoneCountryDTO;
import com.marketing.smscampaing.services.interfaces.ClientService;
import com.marketing.smscampaing.services.interfaces.ClientsCampaingService;
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
public class ClientController {
    private final ClientService clientService;


    @RequestMapping(value = {"/clients/{pageNoOpt:\\d+}/{pageSizeOpt:\\d+}", "/clients", "/clients/{pageNoOpt:\\d+}"}, method = RequestMethod.GET)
    public String showClients(@PathVariable("pageNoOpt") Optional<Integer> pageNoOpt, @PathVariable("pageSizeOpt") Optional<Integer> pageSizeOpt, Model model) {
        int pageNo = pageNoOpt.orElse(1);
        int pageSize = pageSizeOpt.orElse(10);
        if (pageNo <= 0) {
            pageNo = 1;
        }
        if (pageSize <= 0) {
            pageSize = 10;
        }

        Page<ClientDTO> clientsDTOPage = clientService.findPaginatedDTO(pageNo - 1, pageSize);
        List<ClientDTO> clientsDTOList = clientsDTOPage.getContent();
        log.debug("clientsDTOPage List: {}", clientsDTOPage);
        log.debug("clientsDTOList List: {}", clientsDTOList);
        model.addAttribute("clientsDTOPage", clientsDTOPage);
        model.addAttribute("clientsDTOList", clientsDTOList);
        int clientSize = clientsDTOList.size();
        model.addAttribute("clientSize", clientSize);
        int totalPages = clientsDTOPage.getTotalPages();
        long totalElements = clientsDTOPage.getTotalElements();
        int number = clientsDTOPage.getNumber();
        log.debug("totalPages: {}", totalPages);
        log.debug("totalElements: {}", totalElements);
        log.debug("number: {}", number);
        int pageNumber = countCorrectNumberPage(clientsDTOPage.getNumber(), clientsDTOPage.getTotalPages());
        model.addAttribute("pageNumber", pageNumber + 1);

        return "/show/clients-page";
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

