package com.marketing.smscampaing.services.implementations;

import com.marketing.smscampaing.dtos.CampaingDTO;
import com.marketing.smscampaing.model.domain.entity.Campaing;
import com.marketing.smscampaing.model.repositories.CampaingRepository;
import com.marketing.smscampaing.services.interfaces.CampaingService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service @AllArgsConstructor @Slf4j
public class DefaultCampaingService implements CampaingService {

    private final CampaingRepository campaingRepository;
    private final ModelMapper modelMapper;


    @Override
    public List<CampaingDTO> showLastCampaings() {
        List<Campaing> campaings = campaingRepository.findAllByVisibleIsTrueOrderByStartingDateDesc();
        log.debug("Campaings before mapping: {}", campaings.toString());
        ModelMapper myModel = new ModelMapper();
        List<CampaingDTO> campaingsDTO = campaings.stream().map(el -> myModel.map(el, CampaingDTO.class)).collect(Collectors.toList());
        log.debug("Campaings after mapping: {}", campaingsDTO.toString());
        return campaingsDTO;
    }

}
