package com.virtualpairprogrammers.dao;

import com.virtualpairprogrammers.model.Income;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class DefaultIncomeDAO implements IncomeDAO{

    private SessionFactory sessionFactory;

    @Override
    public List<Income> findAll() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        sessionFactory = (SessionFactory) ctx.getBean("sessionFactory");
        Session currentSession = sessionFactory.getCurrentSession();

//        TypedQuery<Income> fromIncome = entityManager.createQuery("FROM Income", Income.class);
//        return fromIncome.getResultList();
        return null;
    }

    //////////////////////////////
    //
    // Getters and Setters
    //
    //////////////////////////////

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
