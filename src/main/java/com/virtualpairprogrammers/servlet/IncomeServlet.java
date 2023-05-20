package com.virtualpairprogrammers.servlet;

import com.virtualpairprogrammers.data.DefaultDAO;
import com.virtualpairprogrammers.domain.Currency;
import com.virtualpairprogrammers.domain.Income;
import com.virtualpairprogrammers.helper.ServletHelper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/incomes")
public class IncomeServlet extends HttpServlet {

    private DefaultDAO dao = new DefaultDAO();
    private ServletHelper helper = new ServletHelper();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Income> incomes = dao.findAllIncomes();
        Income income = incomes.get(incomes.size() - 1);

        String name = request.getParameter("name");
        String description = request.getParameter("description");
        Currency currency = Currency.valueOf(request.getParameter("currency"));
        double amount = Double.parseDouble(request.getParameter("amount"));
        Income newIncome = new Income(income.getId() + 1, name, description, currency, amount);
        dao.saveIncome(newIncome);

        helper.populateModel(request);

        RequestDispatcher rd = request.getRequestDispatcher("/main.jsp");
        rd.forward(request, response);
    }
}
