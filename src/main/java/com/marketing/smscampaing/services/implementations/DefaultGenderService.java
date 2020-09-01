package com.marketing.smscampaing.services.implementations;

import com.marketing.smscampaing.dtos.GenderDTO;
import com.marketing.smscampaing.model.domain.entity.Gender;
import com.marketing.smscampaing.model.repositories.GenderRepository;
import com.marketing.smscampaing.services.interfaces.GenderService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service @AllArgsConstructor @Slf4j
public class DefaultGenderService implements GenderService {
    private final GenderRepository genderRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<GenderDTO> findAllGenders() {
        List<Gender> genders = genderRepository.findAll() ;
        ModelMapper myModel = new ModelMapper();
        return genders
                .stream()
                .map(el -> myModel.map(el, GenderDTO.class)).collect(Collectors.toList());
    }
}
