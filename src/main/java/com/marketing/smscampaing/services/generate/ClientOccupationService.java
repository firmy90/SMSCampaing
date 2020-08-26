package com.marketing.smscampaing.services.generate;

import com.marketing.smscampaing.dtos.ClientDTO;

import java.util.List;

public interface ClientOccupationService {
    List<ClientDTO> getclientsWithOccupation();
}
