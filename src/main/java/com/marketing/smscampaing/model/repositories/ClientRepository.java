package com.marketing.smscampaing.model.repositories;

import com.marketing.smscampaing.model.domain.entity.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {
//    @Override
//    Page<Client> findAll(Pageable pageable);
}
