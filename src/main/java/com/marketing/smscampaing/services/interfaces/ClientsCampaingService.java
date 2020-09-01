package com.marketing.smscampaing.services.interfaces;

import com.marketing.smscampaing.dtos.ClientsPhoneCountryDTO;
import com.marketing.smscampaing.model.domain.entity.Client;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ClientsCampaingService {
    List<ClientsPhoneCountryDTO> showLastClients();
}
