package com.virtualpairprogrammers.dao;

import com.virtualpairprogrammers.model.Income;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class DefaultIncomeDAO implements IncomeDAO{

    private EntityManager entityManager;

    @Autowired
    public DefaultIncomeDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Income> findAll() {
        TypedQuery<Income> fromIncome = entityManager.createQuery("FROM Income", Income.class);
        return fromIncome.getResultList();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
