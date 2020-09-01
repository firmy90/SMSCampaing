package com.marketing.smscampaing.model.repositories;

import com.marketing.smscampaing.model.domain.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, Long> {


}
