package com.virtualpairprogrammers.helper;

import com.virtualpairprogrammers.repository.IncomeDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ui.Model;

import java.util.ArrayList;

public class ServletHelper {

    private IncomeDAO incomeDAO;

    public void populateModel(Model model) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        incomeDAO = (IncomeDAO) ctx.getBean("incomeDAO");
        model.addAttribute("income", "TestIncomeValue");
        model.addAttribute("incomes", incomeDAO.findAll());
        model.addAttribute("outcomes", new ArrayList<>());
        model.addAttribute("outcome", "TestOutcomeValue");
    }
}
