package com.marketing.smscampaing.model.repositories;

import com.marketing.smscampaing.model.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findUserByUsername(String login);
    boolean existsByUsername(String username);
}
