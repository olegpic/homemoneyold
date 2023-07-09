//package com.virtualpairprogrammers.servlet;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.virtualpairprogrammers.data.DefaultDAO;
//import com.virtualpairprogrammers.model.Income;
//
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.BufferedReader;
//import java.io.IOException;
//
//@WebServlet("/incomesUpdate")
//public class UpdateIncomeServlet extends HttpServlet {
//
//    private DefaultDAO dao = new DefaultDAO();
//    private ObjectMapper objectMapper = new ObjectMapper();
//
//    public void doPut(HttpServletRequest request, HttpServletResponse response) {
//        Income income;
//        try (BufferedReader reader = request.getReader()) {
//            StringBuilder requestBody = new StringBuilder();
//            String line;
//            while ((line = reader.readLine()) != null) {
//                requestBody.append(line);
//            }
//            income = objectMapper.readValue(requestBody.toString(), Income.class);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        Income oldIncome = dao.findAllIncomes().stream()
//                .filter(i -> i.getId() == income.getId())
//                .findFirst().orElse(null);
//
//        if (oldIncome != null) {
//            oldIncome.setName(income.getName());
//            oldIncome.setDescription(income.getDescription());
//            oldIncome.setCurrency(income.getCurrency());
//            oldIncome.setAmount(income.getAmount());
//        }
//
//        dao.updateIncome(oldIncome);
//    }
//}
