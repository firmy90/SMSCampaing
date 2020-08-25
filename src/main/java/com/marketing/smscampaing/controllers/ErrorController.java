package com.marketing.smscampaing.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping(name = "/error")
public class ErrorController {

    @GetMapping @PostMapping
    public String reidrectToMainPage(){
        return "rediretc:/";
    }
}
