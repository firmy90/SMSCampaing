package com.marketing.smscampaing.model.repositories;

import com.marketing.smscampaing.model.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUsername(String login);

    boolean existsByUsername(String username);

    @Modifying
    @Query("update User u set u.password = :password where u.username = :name")
    int updateUserPassword(String password, String name);

//    @Query("select u from User u where u.role='ROLE_USER' and u.visible=true order by u.id")
    @Query(value="select * from users where role = 'ROLE_USER' order by id desc limit 1",nativeQuery = true)
    User findFirstdOrderByIdDesc();

}
