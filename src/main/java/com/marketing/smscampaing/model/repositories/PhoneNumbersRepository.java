package com.marketing.smscampaing.model.repositories;

import com.marketing.smscampaing.model.domain.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PhoneNumbersRepository extends JpaRepository<Phone,Long> {

    @Query("select p from Phone p where p.visible=true order by p.updated desc")
    List<Phone> findAllVisible();
                                //and p.client.birthdate between :min and :max
    @Query("select p from Phone p where p.visible=true and p.client.birthdate between :min and :max  and p.client.gender.gender in (:gender) and p.client.occupation.occupation in (:occupation)" +
            " and p.purpose.purpose in (:purpose) and p.type.type in (:type) and p.country.name in (:country) order by p.updated desc ")
    List<Phone> findAllByParamRequests(
                                       @Param("min") LocalDate min,
                                       @Param("max") LocalDate max,
                                       @Param("gender") List<String> gender,
                                       @Param("occupation") List<String> occupation,
                                       @Param("purpose") List<String> purpose,
                                       @Param("type") List<String> type,
                                       @Param("country") List<String> country);
    Phone findFirstById(Long id);

}
