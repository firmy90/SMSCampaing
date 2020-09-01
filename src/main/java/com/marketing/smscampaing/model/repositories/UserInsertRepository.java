package com.marketing.smscampaing.model.repositories;

import com.marketing.smscampaing.model.domain.entity.Client;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class UserInsertRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public boolean createClient(Client client){
        this.entityManager.persist(client);
        return true;


    }
}
