package com.marketing.smscampaing.dtos;

import com.marketing.smscampaing.model.domain.entity.Country;
import com.marketing.smscampaing.model.domain.entity.enums.PhonePurpose;
import com.marketing.smscampaing.model.domain.entity.enums.PhoneType;
import lombok.Data;

@Data
public class PhoneDTO {

    private Long clientId;
    private Long countryId;
    private String number;
    private String purpose;
    private String type;



}
