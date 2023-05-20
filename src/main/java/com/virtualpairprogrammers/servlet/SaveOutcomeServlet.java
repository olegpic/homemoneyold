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
import java.util.List;

@WebServlet("/outcomes")
public class SaveOutcomeServlet extends HttpServlet {

    private DefaultDAO dao = new DefaultDAO();
    private ServletHelper helper = new ServletHelper();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Outcome> outcomes = dao.findAllOutcomes();
        Outcome outcome = outcomes.get(outcomes.size() - 1);

        String name = request.getParameter("name");
        String description = request.getParameter("description");
        Currency currency = Currency.valueOf(request.getParameter("currency"));
        Importance importance = Importance.valueOf(request.getParameter("importance"));
        double amount = Double.parseDouble(request.getParameter("amount"));
        Outcome newOutcome = new Outcome(outcome.getId() + 1, name, description, currency, importance, amount);
        dao.saveOutcome(newOutcome);

        helper.populateModel(request);

        RequestDispatcher rd = request.getRequestDispatcher("/main.jsp");
        rd.forward(request, response);
    }
}
