package com.marketing.smscampaing.dtos;

import lombok.Data;

import java.util.List;

@Data
public class SelectorsDTO {
    private List<String> genders;
    private List<String> occupations;
}
