package com.virtualpairprogrammers.helper;

import com.virtualpairprogrammers.data.DefaultDAO;
import com.virtualpairprogrammers.domain.Income;
import com.virtualpairprogrammers.domain.Outcome;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ServletHelper {

    private DefaultDAO dao = new DefaultDAO();

    public void populateModel(HttpServletRequest request) {
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
    }
}
