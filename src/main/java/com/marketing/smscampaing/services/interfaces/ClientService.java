package com.marketing.smscampaing.services.interfaces;

import com.marketing.smscampaing.dtos.ClientDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ClientService {
    Page<ClientDTO> findPaginatedDTO(int pageNo, int pageSize);
}
