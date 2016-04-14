/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Item;
import model.SmartCard;
import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author ercan
 */
@WebServlet(name = "BorrowServlet", urlPatterns = {"/borrowservlet"})
public class BorrowServlet extends HttpServlet {

@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int cardNo = Integer.parseInt(request.getParameter("cardNo"));
        int itemNo = Integer.parseInt(request.getParameter("itemNo"));
        
        AnnotationConfiguration config = new AnnotationConfiguration();
        config.addAnnotatedClass(User.class);
        config.addAnnotatedClass(Item.class);
        config.addAnnotatedClass(SmartCard.class);
        
        config.configure("hibernate.cfg.xml");

        SessionFactory factory = config.buildSessionFactory();
        Session session = factory.getCurrentSession();

        Transaction tx = session.beginTransaction();
        
        SmartCard smartCard = (SmartCard) session.get(SmartCard.class, cardNo);  // getting the wanted smartcard from database with the given card no
        Item item = (Item) session.get(Item.class, itemNo); // getting the wanted item from database with the given item no
                
        System.err.println(smartCard.getPassword());
        System.err.println(item.getState());

        
    }
}
