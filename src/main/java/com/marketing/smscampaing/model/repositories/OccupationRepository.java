package com.marketing.smscampaing.model.repositories;

import com.marketing.smscampaing.model.domain.entity.Occupation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OccupationRepository extends JpaRepository<Occupation, Long> {
    Occupation findFirstByOccupation(String name);



}
