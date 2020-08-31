package com.marketing.smscampaing.services.implementations;

import com.marketing.smscampaing.dtos.PurposeDTO;
import com.marketing.smscampaing.model.domain.entity.Purpose;
import com.marketing.smscampaing.model.repositories.PurposeRepository;
import com.marketing.smscampaing.services.PurposeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class DefaultPurposeService implements PurposeService {
    private final PurposeRepository purposeRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<PurposeDTO> findAllPurposes() {
        List<Purpose> purposes = purposeRepository.findAllBy();
        ModelMapper myModel = new ModelMapper();
        List<PurposeDTO> dtos = purposes
                .stream()
                .map(el -> myModel.map(el, PurposeDTO.class))
                .collect(Collectors.toList());
        return dtos;
    }
}
