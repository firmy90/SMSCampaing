package com.marketing.smscampaing.controllers;

import com.marketing.smscampaing.dtos.AuthorizationParameterDTO;
import com.marketing.smscampaing.dtos.CampaingDTO;
import com.marketing.smscampaing.dtos.CampaingMessageDTO;
import com.marketing.smscampaing.dtos.PhoneDTO;
import com.marketing.smscampaing.model.domain.entity.CampaingMessage;
import com.marketing.smscampaing.services.interfaces.AuthorizationService;
import com.marketing.smscampaing.services.interfaces.CampaingMessageService;
import com.marketing.smscampaing.services.interfaces.CampaingService;
import com.marketing.smscampaing.services.interfaces.SendMessageService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
@Slf4j
@AllArgsConstructor
@RequestMapping("/generate")
// TODO Czemu tutaj jest używane HttpSession????
public class MessageCampaingController {
    private final CampaingService campaingService;
    private final CampaingMessageService campaingMessageService;
    private final SendMessageService sendMessageService;
    private final AuthorizationService authorizationService;

    @GetMapping
    @RequestMapping("/message")
    public String showGeneratedPhoneNumbers(Model model, HttpSession session) {
        // TODO Czemu próbujemy coś wyciągnać z modelu na start żądania?
        List<PhoneDTO> phonesList = (List<PhoneDTO>) model.getAttribute("phones");
        log.debug("MessageCampaingController: Model with atrribute \"phones\": {}", phonesList);
        List<PhoneDTO> phonesFromSession = (List<PhoneDTO>) session.getAttribute("phonesSes");
        log.debug("phonesFromSession: \"phonesSes\": {}", phonesFromSession);
        List<CampaingDTO> campaingDTOS = campaingService.showLastCampaings();
        model.addAttribute("campaings", campaingDTOS);
        log.debug("Model with atrribute: \"campaings\": {}", campaingDTOS);
        List<AuthorizationParameterDTO> allAuthorizations = authorizationService.findAllAuthorizations();
        log.debug("\"allAuthorizations\": {}", allAuthorizations);
        model.addAttribute("providers", allAuthorizations);
        return "/generate/generate-message-page";
    }

    @RequestMapping(value = "/message", method = RequestMethod.POST)
    public String confirmSendingMessages(@RequestParam(required = false, defaultValue = "") String campaing,
                                         @RequestParam(required = false, defaultValue = "") String content,
                                         @RequestParam(required = false, defaultValue = "") Long authId,
                                         Model model,
                                         HttpSession session) {
        log.debug("RequestedParam = campaing: {}, content: {}, auhtId: {}", campaing, content, authId);
        List<PhoneDTO> phonesFromSession = (List<PhoneDTO>) session.getAttribute("phonesSes");
        log.debug("phonesFromSession: \"phonesSes\": {}", phonesFromSession);

        CampaingMessageDTO campaingByName = campaingMessageService.getCampaingByName(campaing, authId);
        log.debug("campaingByName: {}", campaingByName.toString());
        campaingByName.setCampaingCname(campaing);
        campaingByName.setContent(content);
        log.debug("campaingByName with campaing name and content: {}", campaingByName.toString());
        model.addAttribute("campaingByName", campaingByName);
        session.setAttribute("campaingByName", campaingByName);
        return "redirect:/generate/confirm";

    }

    @RequestMapping(value = "/confirm", method = RequestMethod.GET)
    public String confirmSending(
            Model model,
            HttpSession session) {
        List<PhoneDTO> phonesFromSession = (List<PhoneDTO>) session.getAttribute("phonesSes");
        log.debug("phonesFromSession: \"phonesSes\": {}", phonesFromSession);
        CampaingMessageDTO campaingByName = (CampaingMessageDTO) session.getAttribute("campaingByName");
        log.debug("campaingByName from session: {}", campaingByName.toString());
        return "/generate/generate-confirm-page";
    }

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public String sendMessages(Model model, HttpSession session) {
        List<PhoneDTO> phonesFromSession = (List<PhoneDTO>) session.getAttribute("phonesSes");
        log.debug("phonesFromSession: \"phonesSes\": {}", phonesFromSession);
        CampaingMessageDTO campaingMessageDTO = (CampaingMessageDTO) session.getAttribute("campaingByName");
        log.debug("campaingMessageDTO fromSession: {}", campaingMessageDTO);
        phonesFromSession.stream().forEach(el ->
                {
                    try {
                        int i = sendMessageService.sendMessage(el, campaingMessageDTO);
                        sendMessageService.saveCampaignMessage(el, campaingMessageDTO, i);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        );
        return "redirect:/generate/report/1/10";
    }

    // TODO Lepiej użyć parametrów żądania zamiast zmiennych ścieżki i nie używać Optional w parametrach
    @RequestMapping(value = {"/report/{pageNoOpt:\\d+}/{pageSizeOpt:\\d+}", "/report", "/report/{pageNoOpt:\\d+}," +
            "/{pageNoOpt:\\d+}/{pageSizeOpt:\\d+}", "", "/{pageNoOpt:\\d+}"},
            method = RequestMethod.GET)
    public String showLastMessageReports(@PathVariable("pageNoOpt") Optional<Integer> pageNoOpt, @PathVariable("pageSizeOpt") Optional<Integer> pageSizeOpt, Model model) {
        int pageNo = pageNoOpt.orElse(1);
        int pageSize = pageSizeOpt.orElse(10);
        if (pageNo<=0){
            pageNo=1;
        }
        if (pageSize<=0){
            pageSize=10;
        }
        Page<CampaingMessageDTO> campaingMessagesDTOPage = campaingMessageService.findPaginatedDTO(pageNo-1, pageSize);
        List<CampaingMessageDTO> campaingMessagesDTOList = campaingMessagesDTOPage.getContent();
        log.debug("CampaingMessageDTO Page: {}",campaingMessagesDTOPage);
        log.debug("CampaingMessageDTO List: {}",campaingMessagesDTOList);
        model.addAttribute("campaingMessagesPage", campaingMessagesDTOPage);
        model.addAttribute("campaingMessagesList", campaingMessagesDTOList);
        int campaingsSize = campaingMessagesDTOList.size();
        log.debug("Campaing message hasNext: {}",campaingMessagesDTOPage.hasNext());
        log.debug("Campaing message hasPrevious: {}",campaingMessagesDTOPage.hasPrevious());
        model.addAttribute("campaingsSize", campaingsSize);
        int totalPages = campaingMessagesDTOPage.getTotalPages();
        long totalElements = campaingMessagesDTOPage.getTotalElements();
        int number = campaingMessagesDTOPage.getNumber();
        log.debug("totalPages: {}", totalPages);
        log.debug("totalElements: {}",totalElements);
        log.debug("number: {}",number);
        int pageNumber = countCorrectNumberPage(campaingMessagesDTOPage.getNumber(), campaingMessagesDTOPage.getTotalPages());
        model.addAttribute("pageNumber",pageNumber+1);

        return"/show/report-page";

    }

    public int countCorrectNumberPage(int number, int totalPages){
        if (number<0){
            return 1;
        }
        if (number>totalPages){
            return totalPages+1;
        }
        return number;
    }
}
