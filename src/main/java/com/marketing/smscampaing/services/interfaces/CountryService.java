package com.marketing.smscampaing.services.interfaces;

import com.marketing.smscampaing.dtos.CountryDTO;

import java.util.List;

public interface CountryService {
    List<CountryDTO> findAllCountries();
}
