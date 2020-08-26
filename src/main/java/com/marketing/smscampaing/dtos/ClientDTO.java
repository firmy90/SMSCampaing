package com.marketing.smscampaing.dtos;

import com.marketing.smscampaing.model.domain.entity.Occupation;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ClientDTO {
    private Long id;
    private LocalDate birthdate;
    private String genderGender;
    private String name;
    private String surname;
    private LocalDateTime updated;
    private Occupation occupation;
}
