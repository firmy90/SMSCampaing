package com.marketing.smscampaing.model.repositories;

import com.marketing.smscampaing.model.domain.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TypeRepository extends JpaRepository<Type, Long> {

}
