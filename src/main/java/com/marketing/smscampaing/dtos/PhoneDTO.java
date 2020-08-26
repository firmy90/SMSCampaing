package com.marketing.smscampaing.dtos;

import com.marketing.smscampaing.model.domain.entity.Client;
import com.marketing.smscampaing.model.domain.entity.Country;
import lombok.Data;

@Data
public class PhoneDTO {

    private Client client;
    private Country country;
    private String number;
    private String purpose;
    private String type;



}
