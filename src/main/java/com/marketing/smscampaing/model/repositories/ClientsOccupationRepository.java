package com.marketing.smscampaing.model.repositories;

import com.marketing.smscampaing.model.domain.entity.Client;
import com.marketing.smscampaing.model.domain.entity.enums.ClientGender;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientsOccupationRepository extends JpaRepository<Client, Long> {
    List<Client> findAllByGender(ClientGender gender);
}
