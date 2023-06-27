package com.virtualpairprogrammers.helper;

import com.virtualpairprogrammers.data.DefaultDAO;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

public class ServletHelper {

    private DefaultDAO dao;

    public void populateModel(HttpServletRequest request) {
        request.setAttribute("income", "TestIncomeValue");
        request.setAttribute("incomes", dao.findAllIncomes());
        request.setAttribute("outcomes", dao.findAllOutcomes());
        request.setAttribute("outcome", "TestOutcomeValue");
    }

    public DefaultDAO getDao() {
        return dao;
    }

    @Autowired
    public void setDao(DefaultDAO dao) {
        this.dao = dao;
    }
}
