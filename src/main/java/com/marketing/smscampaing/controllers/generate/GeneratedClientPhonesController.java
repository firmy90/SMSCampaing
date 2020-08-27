package com.marketing.smscampaing.controllers.generate;

import com.marketing.smscampaing.services.PhonesNumberService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller @Slf4j
@AllArgsConstructor
@RequestMapping("/generated-clients")
public class GeneratedClientPhonesController {
    private final PhonesNumberService phonesNumberService;

}
