package com.virtualpairprogrammers.helper;

import com.virtualpairprogrammers.data.DefaultDAO;

import javax.servlet.http.HttpServletRequest;

public class ServletHelper {

    private DefaultDAO dao = new DefaultDAO();

    public void populateModel(HttpServletRequest request) {
        request.setAttribute("income", "TestIncomeValue");
        request.setAttribute("incomes", dao.findAllIncomes());
        request.setAttribute("outcomes", dao.findAllOutcomes());
        request.setAttribute("outcome", "TestOutcomeValue");
    }
}
