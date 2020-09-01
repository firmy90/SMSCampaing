package com.marketing.smscampaing.services.interfaces;

import com.marketing.smscampaing.dtos.ClientDTO;

public interface CreateClientService {
    boolean createClient(ClientDTO clientDTO);
}
