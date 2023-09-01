package com.virtualpairprogrammers.controller;

import com.virtualpairprogrammers.helper.ServletHelper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    private ServletHelper servletHelper;

    @RequestMapping("/home")
    public String doGet(Model model) {
        String classpath = System.getProperty("java.class.path");
        System.out.println("Default Classpath:");
        System.out.println(classpath);
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        servletHelper = (ServletHelper) ctx.getBean("servletHelper");
        servletHelper.populateModel(model);
        return "main.jsp";
    }
}
