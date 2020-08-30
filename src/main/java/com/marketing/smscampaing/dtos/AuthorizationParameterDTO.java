package com.marketing.smscampaing.dtos;

import lombok.Data;

@Data
public class AuthorizationParameterDTO {
    private Long id;
    private String provider;
    private String apiKey;
    private String url;

}
