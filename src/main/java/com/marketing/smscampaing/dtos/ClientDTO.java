package com.marketing.smscampaing.dtos;

import com.marketing.smscampaing.model.domain.entity.Occupation;
import com.marketing.smscampaing.model.domain.entity.enums.ClientGender;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ClientDTO {
    private Long id;
    private LocalDate birthdate;
    private ClientGender gender;
    private String name;
    private String surname;
    private LocalDateTime updated;
    private Occupation occupation;
}
