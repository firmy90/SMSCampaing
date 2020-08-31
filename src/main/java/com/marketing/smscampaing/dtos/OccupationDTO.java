package com.marketing.smscampaing.dtos;

import lombok.Data;

import javax.validation.constraints.Size;

@Data
public class OccupationDTO {
    @Size(max=255, message = "{javax.validation.constraints.Size.message.max255}")
    private String occupation;
}
