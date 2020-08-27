package com.marketing.smscampaing.services;

import com.marketing.smscampaing.dtos.CountryDTO;

import java.util.List;

public interface CountryService {
    List<CountryDTO> findAllCountries();
}
