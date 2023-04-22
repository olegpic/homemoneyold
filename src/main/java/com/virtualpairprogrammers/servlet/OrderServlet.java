package com.virtualpairprogrammers.servlet;

import com.virtualpairprogrammers.data.DatabaseBootstrap;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class OrderServlet extends HttpServlet {

    private double orderTotal = 0.0;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        DatabaseBootstrap dataService = new DatabaseBootstrap();
//        List<Income> fullMenu = dataService.getFullMenu();

        Map<String, String[]> parameterMap = request.getParameterMap();
        parameterMap.keySet().forEach(key -> {
            String value = parameterMap.get(key)[0];
            if (value != null && !value.equals("")) {
                int amount = Integer.parseInt(value);
//                Income income = fullMenu.get(Integer.parseInt(key));
//                orderTotal += income.getAmount() * amount;
            }
        });

        response.sendRedirect("/orderCompleted?total=" + orderTotal);
    }
}
