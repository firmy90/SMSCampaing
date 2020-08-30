package com.marketing.smscampaing.model.repositories;

import com.marketing.smscampaing.model.domain.entity.Campaing;
import com.marketing.smscampaing.model.domain.entity.CampaingMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CampaingMessageRepository extends JpaRepository<CampaingMessage, Long> {
    CampaingMessage findFirstByCampaingId(Long campaingId);

}
