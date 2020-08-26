package com.marketing.smscampaing.dtos;

import com.marketing.smscampaing.model.domain.entity.enums.PhonePurpose;
import com.marketing.smscampaing.model.domain.entity.enums.PhoneType;
import lombok.Data;

@Data
public class PhoneDTO {

    private Long clientId;
    private String number;
    private PhonePurpose purpose;
    private PhoneType type;



}
