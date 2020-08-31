package com.marketing.smscampaing.model.repositories;

import com.marketing.smscampaing.model.domain.entity.CampaingMessage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampaingMessageRepository extends JpaRepository<CampaingMessage, Long> {
    CampaingMessage findFirstByCampaingId(Long campaingId);


    Page<CampaingMessage> findAll(Pageable pageable);
}
