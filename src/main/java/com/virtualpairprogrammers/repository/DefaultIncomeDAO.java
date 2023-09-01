package com.virtualpairprogrammers.repository;

import com.virtualpairprogrammers.model.Income;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Repository
public class DefaultIncomeDAO implements IncomeDAO{

//    private SessionFactory sessionFactory;

    @Override
    public List<Income> findAll() {
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//        sessionFactory = (SessionFactory) ctx.getBean("sessionFactory");
        Configuration configuration = new Configuration();
        configuration.configure();

        List<Income> incomes = new ArrayList<>();
        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            Session session = sessionFactory.openSession();
            TypedQuery<Income> incomesQuery = session.createQuery("FROM Income", Income.class);
            incomes = incomesQuery.getResultList();
        } catch (Exception ex) {
            System.out.println("A problem with opening a session: " + ex);
        }

        return incomes;
    }

    //////////////////////////////
    //
    // Getters and Setters
    //
    //////////////////////////////

//    public SessionFactory getSessionFactory() {
//        return sessionFactory;
//    }
//
//    public void setSessionFactory(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
}
