package com.marketing.smscampaing.model.repositories;

import com.marketing.smscampaing.model.domain.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClientsCampaingRepository extends JpaRepository<Client,Long> {
    @Query("select c from Client c join Phone p on c.id = p.id join Country country on p.countryId = country.id where c.visible=1 and p.visible=1 order by p.updated desc ")
    List<Client> findClientsPhonesCountryOrderByUpdateDesc();
}

