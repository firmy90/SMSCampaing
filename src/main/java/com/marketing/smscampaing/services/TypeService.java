package com.marketing.smscampaing.services;

import com.marketing.smscampaing.dtos.TypeDTO;

import java.util.List;

public interface TypeService {

    List<TypeDTO> findAllTypes();
}
