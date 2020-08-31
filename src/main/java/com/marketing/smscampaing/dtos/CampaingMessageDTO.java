package com.marketing.smscampaing.dtos;

import lombok.Data;

@Data
public class CampaingMessageDTO {
    private Long id;
    private String campaingCname;
    private String content;
    private AuthorizationParameterDTO authorizationParameter;
    private String sendingDate;
    private boolean sendingStatus;
    private String deliveredStatusMessage;
    private String clientName;
    private String clientSurname;
    private String clientBirthdate;
    private String clientGender;
    private String clientOccupation;
    private String phoneNumber;
    private String phoneCountryName;
    private String phoneTypeType;
    private String phonePurposePurpose;


}
