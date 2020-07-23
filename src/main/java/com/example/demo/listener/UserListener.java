package com.example.demo.listener;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class UserListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent servletContextEvent){
        System.out.println("servletContext初始化");
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent){
        System.out.println("servletContext销毁");
    }

}
