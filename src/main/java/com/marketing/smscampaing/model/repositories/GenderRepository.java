package com.marketing.smscampaing.model.repositories;

import com.marketing.smscampaing.model.domain.entity.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GenderRepository extends JpaRepository<Gender, Long> {

    Gender findFirstByGender(String name);
}
