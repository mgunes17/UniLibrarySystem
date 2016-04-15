/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.model.Item;
import com.model.SmartCard;
import com.model.User;
import org.hibernate.Query;
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
        
        
        
        Query query = session.createSQLQuery(
        "select mail from users where card_no="+cardNo);
        List result = query.list();
        
        User user = (User) session.get(User.class, result.get(0).toString());
        

        if(smartCard == null){ // checking if the smartcard exists
            request.setAttribute("state", 0); // state 0 means smartcard is not invalid
            request.getRequestDispatcher("/kiosk.jsp").forward(request, response);
        }
        else if(item == null){ // checking if the item exists
            request.setAttribute("state", 1); // state 1 means item is not invalid
            request.getRequestDispatcher("/kiosk.jsp").forward(request, response);
        }
        else if(item.getState() != 0){ // checking if the item is free
            request.setAttribute("state", 2); // state 2 means item is not free
            request.getRequestDispatcher("/kiosk.jsp").forward(request, response);
        }
        else if(user.getBorrowedItemCount() == 6){ // make it parametric . checking if the user has the maxItemCount 
            request.setAttribute("state", 3); // state 3 means user has the maxItemCount
            request.getRequestDispatcher("/kiosk.jsp").forward(request, response);
        }
        else{
            // item operation tablosuna ekle
            request.setAttribute("state", 4); // state 4 means item is available and card is valid. borrow operation will be processed.
            request.getRequestDispatcher("/kiosk.jsp").forward(request, response);
            
        }
    }
}
