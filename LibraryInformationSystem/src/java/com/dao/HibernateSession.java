/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author must
 */
public class HibernateSession {
    private static Configuration config;
    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;
    private Session session;
    
    public HibernateSession(){
       
    }
    
    public static synchronized SessionFactory getSessionFactory(){
        if(sessionFactory == null){
            config = new Configuration();
            config.configure("hibernate.cfg.xml");
            serviceRegistry = new StandardServiceRegistryBuilder()
                                .applySettings(config.getProperties()).build();
            sessionFactory = config
                                .addAnnotatedClass(com.model.User.class)
                                .addAnnotatedClass(com.model.Student.class)
                                .addAnnotatedClass(com.model.Lecturer.class)
                                .addAnnotatedClass(com.model.Officer.class)
                                .addAnnotatedClass(com.model.Item.class)
                                .addAnnotatedClass(com.model.UserType.class)
                                .addAnnotatedClass(com.model.SmartCard.class)
                                .buildSessionFactory(serviceRegistry);
        }
        
        return sessionFactory;
    }
       
}

