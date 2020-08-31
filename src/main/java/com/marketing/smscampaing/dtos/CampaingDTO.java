package com.marketing.smscampaing.dtos;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
public class CampaingDTO {
    @Size(min=4, max=255)
    private String cname;
    @DateTimeFormat
    private LocalDate startingDate;
    @DateTimeFormat
    private LocalDate finishDate;
}
