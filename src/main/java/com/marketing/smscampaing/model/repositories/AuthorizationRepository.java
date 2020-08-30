package com.marketing.smscampaing.model.repositories;

import com.marketing.smscampaing.model.domain.entity.AuthorizationParameter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorizationRepository extends JpaRepository<AuthorizationParameter, Long> {

    AuthorizationParameter findFirstById(Long id);
    List<AuthorizationParameter> findAllByActiveIsTrue();

}
