package com.marketing.smscampaing.model.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter @Setter @AllArgsConstructor @ToString
public class Selector {
    private List<Gender> genders;
    private List<Occupation> occupations;
}
