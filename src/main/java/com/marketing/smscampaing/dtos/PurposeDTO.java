package com.marketing.smscampaing.dtos;

import lombok.Data;

import javax.validation.constraints.Size;

@Data
public class PurposeDTO {
    @Size(max = 100, message = "{javax.validation.constraints.Size.message.max100}")
    private String purpose;
}
