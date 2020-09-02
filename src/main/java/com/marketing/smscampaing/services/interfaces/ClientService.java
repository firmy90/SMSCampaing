package com.marketing.smscampaing.services.interfaces;

import com.marketing.smscampaing.dtos.ClientDTO;

import java.util.List;

public interface ClientService {
    List<ClientDTO> findPaginatedDTO(int pageNo, int pageSize);
}
