package com.marketing.smscampaing.services;

import com.marketing.smscampaing.dtos.TypeDTO;
import com.marketing.smscampaing.model.domain.entity.Type;
import com.marketing.smscampaing.model.repositories.TypeRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service @AllArgsConstructor @Slf4j
public class DefaultTypeService implements TypeService {
    private final TypeRepository typeRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<TypeDTO> findAllTypes() {
        List<Type> types = typeRepository.findAllBy();
        ModelMapper myModel = new ModelMapper();
        List<TypeDTO> typesdto = types
                .stream()
                .map(el -> myModel.map(el, TypeDTO.class)).collect(Collectors.toList());
        return typesdto;
    }
}
