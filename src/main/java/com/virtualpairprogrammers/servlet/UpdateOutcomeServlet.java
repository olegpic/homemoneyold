package com.virtualpairprogrammers.servlet;

import com.virtualpairprogrammers.data.DefaultDAO;
import com.virtualpairprogrammers.domain.Currency;
import com.virtualpairprogrammers.domain.Importance;
import com.virtualpairprogrammers.domain.Outcome;
import com.virtualpairprogrammers.helper.ServletHelper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/outcomesUpdate")
public class UpdateOutcomeServlet extends HttpServlet {

    private DefaultDAO dao = new DefaultDAO();
    private ServletHelper helper = new ServletHelper();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Outcome oldOutcome = dao.findAllOutcomes().stream()
                .filter(outcome -> outcome.getId() == id)
                .findFirst().orElse(null);

        if (oldOutcome != null) {
            oldOutcome.setName(request.getParameter("name"));
            oldOutcome.setDescription(request.getParameter("description"));
            oldOutcome.setCurrency(Currency.valueOf(request.getParameter("currency")));
            oldOutcome.setImportance(Importance.valueOf(request.getParameter("importance")));
            oldOutcome.setAmount(Double.parseDouble(request.getParameter("amount")));
        }

        dao.updateOutcome(oldOutcome);
        helper.populateModel(request);

        RequestDispatcher rd = request.getRequestDispatcher("/main.jsp");
        rd.forward(request, response);
    }
}
