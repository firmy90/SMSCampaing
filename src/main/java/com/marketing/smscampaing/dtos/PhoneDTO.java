package com.marketing.smscampaing.dtos;

import lombok.Data;

import javax.validation.constraints.Size;

@Data
public class PhoneDTO {
    private Long id;
    @Size(max = 15, message = "{javax.validation.constraints.Size.message.max15}")
    private String number;
    private String purposePurpose;
    private String typeType;
    private String countryName;
    private Long clientUid;
    private String clientName;
    private String clientSurname;
    private String clientBirthdate;
    private String clientGender;
    private String clientOccupation;




}
