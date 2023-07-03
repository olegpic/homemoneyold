package com.virtualpairprogrammers.servlet;

import com.virtualpairprogrammers.helper.ServletHelper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class MainServlet extends HttpServlet {

    private ServletHelper servletHelper;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        servletHelper = (ServletHelper) ctx.getBean("servletHelper");
        servletHelper.populateModel(request);
        RequestDispatcher rd = request.getRequestDispatcher("/main.jsp");
        rd.forward(request, response);
    }
}
