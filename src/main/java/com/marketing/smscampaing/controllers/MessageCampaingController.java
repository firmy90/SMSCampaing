package com.marketing.smscampaing.controllers;

import com.marketing.smscampaing.dtos.AuthorizationParameterDTO;
import com.marketing.smscampaing.dtos.CampaingDTO;
import com.marketing.smscampaing.dtos.CampaingMessageDTO;
import com.marketing.smscampaing.dtos.PhoneDTO;
import com.marketing.smscampaing.services.interfaces.AuthorizationService;
import com.marketing.smscampaing.services.interfaces.CampaingMessageService;
import com.marketing.smscampaing.services.interfaces.CampaingService;
import com.marketing.smscampaing.services.interfaces.SendMessageService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
public class MessageCampaingController {
    private final CampaingService campaingService;
    private final CampaingMessageService campaingMessageService;
    private final SendMessageService sendMessageService;
    private final AuthorizationService authorizationService;

    @GetMapping
    @RequestMapping("/message")
    public String showGeneratedPhoneNumbers(Model model, HttpSession session) {
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
        return "/generate-message-page";
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
        return "/generate-confirm-page";
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
        return "redirect:/generate/report/0/5";
    }

    @RequestMapping(value = {"/report/{pageNoOpt:\\d+}/{pageSizeOpt:\\d+}", "/report", "/report/{pageNoOpt:\\d+}"}, method = RequestMethod.GET)
    public String showLastMessageReports(@PathVariable("pageNoOpt") Optional<Integer> pageNoOpt, @PathVariable("pageSizeOpt") Optional<Integer> pageSizeOpt, Model model) {
        int pageNo = 0;
        int pageSize = 5;
        if (pageNoOpt.isPresent()) {
            if(pageNoOpt.get()>=0){
                pageNo = pageNoOpt.get();
            }
        }
        if (pageSizeOpt.isPresent()) {
            if (pageSizeOpt.get() > 0) {
                pageSize = pageSizeOpt.get();
            }
        }
        List<CampaingMessageDTO> campaingMessages = campaingMessageService.findPaginatedDTO(pageNo, pageSize);
        log.debug("CampaingMessageDTO List: {}",campaingMessages);
        model.addAttribute("campaingMessages", campaingMessages);
        int campaingsSize = campaingMessages.size();
        model.addAttribute("campaingsSize", campaingsSize);
        return"/generate-report-page";
    }
}
