package com.virtualpairprogrammers.servlet;

import com.virtualpairprogrammers.data.DefaultDAO;
import com.virtualpairprogrammers.domain.Income;
import com.virtualpairprogrammers.domain.Outcome;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/")
public class MainServlet extends HttpServlet {

    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        DefaultDAO dao = new DefaultDAO();

        List<Income> incomes = dao.getIncomes();
        List<Outcome> outcomes = dao.getOutcomes();

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<html><body><h1>Incomes:</h1></body></html>");
        out.println("<form method=\"get\" action=\"\\incomes\">");
        out.println("<ul>");
        for (Income income : incomes) {
            out.println(String.format("<li>%s<input type=\"text\" name=\"%s\"/></li>", income.getName(), income.getId()));
        }
        out.println("</ul>");
        out.println("<button>Add</button>");
        out.println("</form");
        out.println("</body></html>");

        out.println("</br>");

        out.println("<html><body><h1>Outcomes:</h1></body></html>");
        out.println("<form method=\"get\" action=\"\\incomes\">");
        out.println("<ul>");
        for (Outcome outcome : outcomes) {
            out.println(String.format("<li>%s<input type=\"text\" name=\"%s\"/></li>", outcome.getName(), outcome.getId()));
        }
        out.println("</ul>");
        out.println("<button>Add</button>");
        out.println("</form");
        out.println("</body></html>");
        out.close();
    }
}
