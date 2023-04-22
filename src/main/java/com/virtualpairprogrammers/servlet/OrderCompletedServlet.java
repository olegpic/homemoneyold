package com.virtualpairprogrammers.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class OrderCompletedServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<html><body><h1>Menu:</h1></body></html>");
        out.println(String.format("<h3>Order completed. Total amount is %s$.</h3>", request.getParameter("total")));
        out.println("</body></html>");
        out.close();
    }
}
