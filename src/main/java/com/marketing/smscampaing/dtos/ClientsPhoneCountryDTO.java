package com.marketing.smscampaing.dtos;

import lombok.Data;

import javax.validation.constraints.Size;

@Data
public class ClientsPhoneCountryDTO {
    private String clientUid;
    @Size(max = 100, message = "{javax.validation.constraints.Size.message.max100}")
    private String clientName;
    @Size(max = 100, message = "{javax.validation.constraints.Size.message.max100}")
    private String clientSurname;
    @Size(max = 100, message = "{javax.validation.constraints.Size.message.max100}")
    private String clientGender;
    @Size(max=255, message = "{javax.validation.constraints.Size.message.max255}")
    private String occupationOccupation;
    @Size(max = 100, message = "{javax.validation.constraints.Size.message.max100}")
    private String countryName;
    private String phoneId;
    private String phoneNumber;
    @Size(max = 100, message = "{javax.validation.constraints.Size.message.max100}")
    private String purposePurpose;
    @Size(max = 100, message = "{javax.validation.constraints.Size.message.max100}")
    private String typeType;
}
