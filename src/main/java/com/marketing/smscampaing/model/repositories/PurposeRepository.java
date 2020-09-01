package com.marketing.smscampaing.model.repositories;

import com.marketing.smscampaing.model.domain.entity.Purpose;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PurposeRepository extends JpaRepository<Purpose, Long> {

}
