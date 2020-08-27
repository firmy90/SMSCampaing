package com.marketing.smscampaing.services;

import com.marketing.smscampaing.dtos.PhoneDTO;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PhonesNumberService {

    List<PhoneDTO> showAllPhones();
    List<PhoneDTO> showByParams(
                                @Param("min") LocalDate min,
                                @Param("max") LocalDate max,
                                @Param("gender") List<String> gender,
                                @Param("occupation") List<String> occupation,
                                @Param("purpose") List<String> purpose,
                                @Param("type") List<String> types,
                                @Param("country") List<String> country);

}
