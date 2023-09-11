package com.virtualpairprogrammers.controller;

import com.virtualpairprogrammers.helper.ServletHelper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/home")
    public String doGet(Model model) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        ServletHelper servletHelper = (ServletHelper) ctx.getBean("servletHelper");
        servletHelper.populateModel(model);
        return "main.jsp";
    }
}
