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


}
