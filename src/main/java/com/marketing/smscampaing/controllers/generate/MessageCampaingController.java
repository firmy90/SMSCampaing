package com.marketing.smscampaing.controllers.generate;

import com.marketing.smscampaing.dtos.AuthorizationParameterDTO;
import com.marketing.smscampaing.dtos.CampaingDTO;
import com.marketing.smscampaing.dtos.CampaingMessageDTO;
import com.marketing.smscampaing.dtos.PhoneDTO;
import com.marketing.smscampaing.integration.MainAPI;
import com.marketing.smscampaing.model.domain.entity.CampaingMessage;
import com.marketing.smscampaing.model.domain.entity.Phone;
import com.marketing.smscampaing.services.AuthorizationService;
import com.marketing.smscampaing.services.CampaingMessageService;
import com.marketing.smscampaing.services.CampaingService;
import com.marketing.smscampaing.services.SendMessageService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@Slf4j
@AllArgsConstructor
@RequestMapping("/generate")
public class MessageCampaingController {
    private final CampaingService campaingService;
    private final CampaingMessageService campaingMessageService;
    private final AuthorizationService authorizationService;
    private final SendMessageService sendMessageService;

    @GetMapping
    @RequestMapping("/message")
    public String showGeneratedPhoneNumbers(Model model , HttpSession session) {
        List<PhoneDTO> phonesList = (List<PhoneDTO>) model.getAttribute("phones");
        log.debug("Model with atrribute \"phones\": {}", phonesList);
        List<PhoneDTO> phonesFromSession = (List<PhoneDTO>)session.getAttribute("phonesSes");
        log.debug("phonesFromSession: \"phonesSes\": {}",phonesFromSession);
        List<CampaingDTO> campaingDTOS = campaingService.showLastCampaings();
        model.addAttribute("campaings", campaingDTOS);
        log.debug("Model with atrribute: \"campaings\": {}",campaingDTOS);
        List<AuthorizationParameterDTO> allAuthorizations = authorizationService.findAllAuthorizations();
        log.debug("\"allAuthorizations\": {}",allAuthorizations);
        model.addAttribute("providers",allAuthorizations);
        return "/generate-message-page";
    }

    @RequestMapping(value = "/message", method = RequestMethod.POST)
    public String confirmSendingMessages(@RequestParam(required = false, defaultValue = "") String campaing,
                                         @RequestParam(required = false, defaultValue = "") String content,
                                         @RequestParam(required = false, defaultValue = "") Long authId,
                                 Model model,
                                 HttpSession session ){
        log.debug("RequestedParam = campaing: {}, content: {}, auhtId: {}",campaing,content,authId);
        List<PhoneDTO> phonesFromSession = (List<PhoneDTO>)session.getAttribute("phonesSes");
        log.debug("phonesFromSession: \"phonesSes\": {}",phonesFromSession);
        CampaingMessageDTO campaingByName = campaingMessageService.getCampaingByName(campaing,authId);
        log.debug("campaingByName: {}",campaingByName.toString());
        campaingByName.setCampaingCname(campaing);
        campaingByName.setContent(content);
        log.debug("campaingByName with campaing name and content: {}",campaingByName.toString());
        model.addAttribute("campaingByName",campaingByName);
        session.setAttribute("campaingByName", campaingByName );
        return "redirect:/generate/confirm";

    }

    @RequestMapping(value = "/confirm", method = RequestMethod.GET)
    public String confirmSending(@RequestParam(required = false, defaultValue = "") String campaing,
                                 @RequestParam(required = false, defaultValue = "") Long authId,
                                 Model model,
                                 HttpSession session ){
        List<PhoneDTO> phonesFromSession = (List<PhoneDTO>)session.getAttribute("phonesSes");
        log.debug("phonesFromSession: \"phonesSes\": {}",phonesFromSession);
        CampaingMessageDTO campaingByName = campaingMessageService.getCampaingByName(campaing,authId);
        log.debug("campaingByName: {}",campaingByName.toString());
        session.setAttribute("campaing", campaingByName );
        return "/generate-confirm-page";
    }

    @RequestMapping(value = "/send", method = RequestMethod.GET)
    public String sendMessages(Model model , HttpSession session) {
        List<PhoneDTO> phonesFromSession = (List<PhoneDTO>)session.getAttribute("phonesSes");
        log.debug("phonesFromSession: \"phonesSes\": {}",phonesFromSession);
        CampaingMessageDTO campaingMessageDTO = (CampaingMessageDTO) session.getAttribute("campaingByName");
        log.debug("campaingMessageDTO fromSession: {}",campaingMessageDTO);
        phonesFromSession.stream().forEach(el->
                {
                    try {
                        sendMessageService.sendMessage(el,campaingMessageDTO);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        );

        return "/generate-message-page";
    }
}
