package com.marketing.smscampaing.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CampaingDTO {
    private String cname;
    private LocalDate startingDate;
    private LocalDate finishDate;
}
