package com.virtualpairprogrammers.servlet;

import com.virtualpairprogrammers.data.DefaultDAO;
import com.virtualpairprogrammers.domain.Income;
import com.virtualpairprogrammers.domain.Outcome;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/")
public class MainServlet extends HttpServlet {

    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        DefaultDAO dao = new DefaultDAO();

        List<Income> incomes = dao.getIncomes();
        List<Outcome> outcomes = dao.getOutcomes();

        StringBuilder incomesString = new StringBuilder();
        for (Income income : incomes) {
            incomesString.append(String.format("<li>%s: %s (%s) - %s %s</li>\n", income.getId(), income.getName(), income.getDescription(), income.getAmount(), income.getCurrency()));
        }
        request.setAttribute("incomes", incomesString.toString());

        StringBuilder outcomesString = new StringBuilder();
        for (Outcome outcome : outcomes) {
            outcomesString.append(String.format("<li>%s (%s): %s (%s) - %s %s</li>\n", outcome.getId(), outcome.getImportance(), outcome.getName(), outcome.getDescription(), outcome.getAmount(), outcome.getCurrency()));
        }
        request.setAttribute("outcomes", outcomesString.toString());

        RequestDispatcher rd = request.getRequestDispatcher("/main.jsp");
        rd.forward(request, response);
    }
}
