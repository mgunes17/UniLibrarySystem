/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.dao.HibernateSession;
import com.model.Item;
import com.model.ItemOperation;
import com.model.ItemReservation;
import com.model.SmartCard;
import com.model.User;
import com.model.UserType;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ercan
 */
@WebServlet(name = "ReserveItemServlet", urlPatterns = {"/reserveitemservlet"})
public class ReserveItemServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int cardNo = Integer.parseInt(request.getParameter("cardNo"));
        int itemNo = Integer.parseInt(request.getParameter("itemNo"));
        
        Session session = HibernateSession.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        HttpSession httpsession = request.getSession();
        
        // getting the wanted smartcard from database with the given card no
        SmartCard smartCard = (SmartCard) session.get(SmartCard.class, cardNo);  
        // getting the wanted item from database with the given item no
        Item item = (Item) session.get(Item.class, itemNo); 
        
        
        Query query = session.createQuery(
        "from User where smartCard = "+cardNo);
        List<User> result = query.list();
        
        Query query2 = session.createQuery(
        "from ItemReservation where (state = 5 or state = 1 ) and itemNo = "+itemNo);
        List<ItemReservation> result2 = query2.list();
        
        User user = (User) session.get(User.class, result.get(0).getMail());
        UserType userType = (UserType) session.get(UserType.class, user.getUserType());
        
        if(smartCard == null){ // checking if the smartcard exists
            httpsession.setAttribute("state", 0); // state 0 means smartcard is not invalid
        }
        else if(item == null){ // checking if the item exists
            httpsession.setAttribute("state", 1); // state 1 means item is not invalid
        }
        else if(!result2.isEmpty()){ // checking if the item is free
            httpsession.setAttribute("state", 10); // state 10 means item is already reserved
        }
        else if(user.getBorrowedItemCount() == userType.getMaxLimit()){ // make it parametric . checking if the user has the maxItemCount 
            httpsession.setAttribute("state", 3); // state 3 means user has the maxItemCount
        }
        else if(smartCard.getBalance() <= 0){
            httpsession.setAttribute("state", 8); // state 5 means user has no money
        }
        else{
            ItemReservation ir = new ItemReservation();
            ir.setItemNo(itemNo);
            ir.setMail(user.getMail());
            ir.setState(5);
                        
            session.saveOrUpdate(user);
            session.save(ir);
            tx.commit();
            httpsession.setAttribute("state", 11); // state 4 means item is available and card is valid. borrow operation will be processed.
        }
        response.sendRedirect("kiosk.jsp");
    }

}
