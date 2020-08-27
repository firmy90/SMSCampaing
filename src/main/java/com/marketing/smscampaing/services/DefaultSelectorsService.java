package com.marketing.smscampaing.services;

import com.marketing.smscampaing.dtos.SelectorsDTO;
import com.marketing.smscampaing.model.domain.entity.Gender;
import com.marketing.smscampaing.model.domain.entity.Occupation;
import com.marketing.smscampaing.model.domain.entity.Selector;
import com.marketing.smscampaing.model.repositories.GenderRepository;
import com.marketing.smscampaing.model.repositories.OccupationRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class DefaultSelectorsService implements SelectorsService {
    private final ModelMapper modelMapper;
    private final GenderRepository genderRepository;
    private final OccupationRepository occupationRepository;


    @Override
    public SelectorsDTO findAllSelectors() {
        List<SelectorsDTO> selectors = new ArrayList<>();
        List<Gender> genders = genderRepository.findGendersBy();
        log.info("genders list: {}", genders.toString());
        List<Occupation> occupations = occupationRepository.findAllOccupations();
        log.info("Occupation list: {}", occupations.toString());
        ModelMapper myModel = new ModelMapper();
        Selector selector = new Selector(genders, occupations);
        log.info("Selector before mapping: {}", selector.toString());
        myModel.typeMap(Selector.class, SelectorsDTO.class);
        myModel.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        SelectorsDTO map = myModel.map(selector, SelectorsDTO.class);
        log.info("Selector after mapping: {}", map.toString());

        return map;
    }
}
