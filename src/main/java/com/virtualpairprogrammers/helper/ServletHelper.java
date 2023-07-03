package com.virtualpairprogrammers.helper;

import com.virtualpairprogrammers.data.DefaultDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.http.HttpServletRequest;

public class ServletHelper {

    private DefaultDAO dao;

    public void populateModel(HttpServletRequest request) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        dao = (DefaultDAO) ctx.getBean("defaultDAO");
        request.setAttribute("income", "TestIncomeValue");
        request.setAttribute("incomes", dao.findAllIncomes());
        request.setAttribute("outcomes", dao.findAllOutcomes());
        request.setAttribute("outcome", "TestOutcomeValue");
    }
}
