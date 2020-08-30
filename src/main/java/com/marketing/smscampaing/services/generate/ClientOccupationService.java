package com.marketing.smscampaing.services.generate;

import com.marketing.smscampaing.dtos.ClientDTO_delete;

import java.util.List;

public interface ClientOccupationService {
    List<ClientDTO_delete> getclientsWithOccupation();
}
