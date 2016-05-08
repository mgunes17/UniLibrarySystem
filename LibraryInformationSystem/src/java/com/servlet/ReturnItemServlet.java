/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.dao.HibernateSession;
import com.model.Item;
import com.model.ItemOperation;
import com.model.SmartCard;
import com.model.User;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author ercan
 */
@WebServlet(name = "ReturnItemServlet", urlPatterns = {"/returnitemservlet"})
public class ReturnItemServlet extends HttpServlet {

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
        
        SmartCard smartCard = (SmartCard) session.get(SmartCard.class, cardNo);  // getting the wanted smartcard from database with the given card no
        Item item = (Item) session.get(Item.class, itemNo); // getting the wanted item from database with the given item no
        
        Query query = session.createSQLQuery(
        "select mail from users where card_no="+cardNo);
        List result = query.list();
        String mail = result.get(0).toString();
        User user = (User) session.get(User.class, mail);
        
        if(smartCard == null){ // checking if the smartcard exists
            request.setAttribute("state", 0); // state 0 means smartcard is not invalid
            request.getRequestDispatcher("/kiosk.jsp").forward(request, response);
        }
        else if(item == null){ // checking if the item exists
            request.setAttribute("state", 1); // state 1 means item is not invalid
            request.getRequestDispatcher("/kiosk.jsp").forward(request, response);
        }
        else if(item.getState() != 2){ // checking if the item is free
            request.setAttribute("state", 4); // state 4 means item is not borrowed
            request.getRequestDispatcher("/kiosk.jsp").forward(request, response);
        }
        else if(user.getBorrowedItemCount() == 0){ // make it parametric . checking if the user has the maxItemCount 
            request.setAttribute("state", 5); // state 5 means user has no item
            request.getRequestDispatcher("/kiosk.jsp").forward(request, response);
        }
        else{
            // item operation tablosuna ekle
            
            Query query2 = session.createQuery(
            "from ItemOperation where returnedDate is NULL and item_no="+itemNo);
            List<ItemOperation> result2 = query2.list();
            
            ItemOperation io = (ItemOperation) session.get(ItemOperation.class, result2.get(0).getOperationId());
            
            io.setReturnedDate(new Timestamp(new Date().getTime()));
            
            item.setCurrentUser(null);
            item.setState(0);
            
            user.setBorrowedItemCount(user.getBorrowedItemCount() - 1 );
            
            session.saveOrUpdate(user);
            session.saveOrUpdate(item);
            session.save(io);
            tx.commit();
            request.setAttribute("state", 6); // state 6 means item is returned succesfully.
            request.getRequestDispatcher("/kiosk.jsp").forward(request, response); 
        }
    }

}
