package com.marketing.smscampaing.model.repositories;

import com.marketing.smscampaing.model.domain.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PhoneNumbersRepository extends JpaRepository<Phone,Long> {

    @Query("select p from Phone p where p.visible=1 order by p.updated desc")
    List<Phone> findAllVisible();

}
