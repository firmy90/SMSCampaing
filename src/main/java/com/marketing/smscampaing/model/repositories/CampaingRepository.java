package com.marketing.smscampaing.model.repositories;

import com.marketing.smscampaing.model.domain.entity.Campaing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CampaingRepository extends JpaRepository<Campaing, Long> {

    List<Campaing> findAllByVisibleIsTrueOrderByStartingDateDesc();
}
