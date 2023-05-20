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

@WebServlet("/incomesUpdate")
public class UpdateIncomeServlet extends HttpServlet {

    private DefaultDAO dao = new DefaultDAO();
    private ServletHelper helper = new ServletHelper();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Income oldIncome = dao.findAllIncomes().stream()
                .filter(income -> income.getId() == id)
                .findFirst().orElse(null);

        if (oldIncome != null) {
            oldIncome.setName(request.getParameter("name"));
            oldIncome.setDescription(request.getParameter("description"));
            oldIncome.setCurrency(Currency.valueOf(request.getParameter("currency")));
            oldIncome.setAmount(Double.parseDouble(request.getParameter("amount")));
        }

        dao.updateIncome(oldIncome);
        helper.populateModel(request);

        RequestDispatcher rd = request.getRequestDispatcher("/main.jsp");
        rd.forward(request, response);
    }
}
