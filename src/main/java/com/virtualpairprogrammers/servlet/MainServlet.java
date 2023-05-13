package com.virtualpairprogrammers.servlet;

import com.virtualpairprogrammers.helper.ServletHelper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class MainServlet extends HttpServlet {

    private ServletHelper helper = new ServletHelper();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        helper.populateModel(request);
        RequestDispatcher rd = request.getRequestDispatcher("/main.jsp");
        rd.forward(request, response);
    }
}
