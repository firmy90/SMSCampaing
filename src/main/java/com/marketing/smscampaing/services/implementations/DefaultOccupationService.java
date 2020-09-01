package com.marketing.smscampaing.services.implementations;

import com.marketing.smscampaing.dtos.OccupationDTO;
import com.marketing.smscampaing.model.domain.entity.Occupation;
import com.marketing.smscampaing.model.repositories.OccupationRepository;
import com.marketing.smscampaing.services.interfaces.OccupationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service @Slf4j @AllArgsConstructor
public class DefaultOccupationService implements OccupationService {
    private final ModelMapper modelMapper;
    private final OccupationRepository occupationRepository;

    @Override
    public List<OccupationDTO> showOccupations() {
        List<Occupation> occupations = occupationRepository.findAll();
        log.debug("Occupation list: {}", occupations.toString());
        ModelMapper modelMapperDefaultStrategy = new ModelMapper();
        return occupations.stream().map(occupation -> modelMapperDefaultStrategy.map(occupation,OccupationDTO.class)).collect(Collectors.toList());

    }
}
