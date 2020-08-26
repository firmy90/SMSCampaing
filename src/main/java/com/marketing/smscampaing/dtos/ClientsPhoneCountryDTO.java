package com.marketing.smscampaing.dtos;

import com.marketing.smscampaing.model.domain.entity.Country;
import com.marketing.smscampaing.model.domain.entity.enums.ClientGender;
import com.marketing.smscampaing.model.domain.entity.enums.PhonePurpose;
import com.marketing.smscampaing.model.domain.entity.enums.PhoneType;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ClientsPhoneCountryDTO {
    private String name;
    private String surname;
//    private String phoneNumber;
//    private LocalDate birthday;
//    private ClientGender clientGender;
//    private PhonePurpose phonePurpose;
//    private PhoneType phoneType;
//    private Country country;
}
