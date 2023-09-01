package com.virtualpairprogrammers.helper;

import com.virtualpairprogrammers.dao.IncomeDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ui.Model;

public class ServletHelper {

    private IncomeDAO incomeDAO;

    public void populateModel(Model model) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        incomeDAO = (IncomeDAO) ctx.getBean("incomeDAO");
        model.addAttribute("income", "TestIncomeValue");
        model.addAttribute("incomes", incomeDAO.findAll());
        model.addAttribute("outcomes", incomeDAO.findAll());
        model.addAttribute("outcome", "TestOutcomeValue");
    }
}
