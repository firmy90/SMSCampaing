package com.marketing.smscampaing.dtos;

import com.marketing.smscampaing.model.domain.entity.Client;
import com.marketing.smscampaing.model.domain.entity.Country;
import com.marketing.smscampaing.model.domain.entity.Occupation;
import lombok.Data;

@Data
public class ClientsPhoneCountryDTO {
    private Client client;
    private String occupationOccupation;
    private String CountryName;
    private String phoneNumber;
    private String purposePurpose;
    private String typeType;
}
