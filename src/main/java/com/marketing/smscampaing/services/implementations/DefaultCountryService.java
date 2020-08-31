package com.marketing.smscampaing.services.implementations;

import com.marketing.smscampaing.dtos.CountryDTO;
import com.marketing.smscampaing.dtos.GenderDTO;
import com.marketing.smscampaing.model.domain.entity.Country;
import com.marketing.smscampaing.model.domain.entity.Gender;
import com.marketing.smscampaing.model.repositories.CountryRepository;
import com.marketing.smscampaing.services.CountryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service @AllArgsConstructor @Slf4j
public class DefaultCountryService implements CountryService {
    private final CountryRepository countryRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<CountryDTO> findAllCountries() {
        List<Country> countries = countryRepository.findAllBy() ;
        ModelMapper myModel = new ModelMapper();
        return countries
                .stream()
                .map(el -> myModel.map(el, CountryDTO.class)).collect(Collectors.toList());
    }
}
