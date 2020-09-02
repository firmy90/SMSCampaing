package com.marketing.smscampaing.controllers;

import com.marketing.smscampaing.dtos.ClientDTO;
import com.marketing.smscampaing.dtos.ClientsPhoneCountryDTO;
import com.marketing.smscampaing.services.interfaces.ClientService;
import com.marketing.smscampaing.services.interfaces.ClientsCampaingService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
        int pageNo = 0;
        int pageSize = 5;
        if (pageNoOpt.isPresent()) {
            if (pageNoOpt.get() >= 0) {
                pageNo = pageNoOpt.get();
            }
        }
        if (pageSizeOpt.isPresent()) {
            if (pageSizeOpt.get() > 0) {
                pageSize = pageSizeOpt.get();
            }
        }
        List<ClientDTO> clientsPage = clientService.findPaginatedDTO(pageNo, pageSize);
        log.debug("clientsPage List: {}", clientsPage);
        model.addAttribute("clientsPage", clientsPage);
        int clientSize = clientsPage.size();
        model.addAttribute("clientSize", clientSize);
        return "/show/clients-page";
    }
}

