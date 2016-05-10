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
        HttpSession httpsession = request.getSession();
        
        SmartCard smartCard = (SmartCard) session.get(SmartCard.class, cardNo);  // getting the wanted smartcard from database with the given card no
        Item item = (Item) session.get(Item.class, itemNo); // getting the wanted item from database with the given item no
        
        Query query = session.createQuery(
        "from User where smartCard = "+cardNo);
        List<User> result = query.list();
        
        User user = (User) session.get(User.class, result.get(0).getMail());
        UserType userType = (UserType) session.get(UserType.class, user.getUserType());
        if(smartCard == null){ // checking if the smartcard exists
            httpsession.setAttribute("state", 0); // state 0 means smartcard is not invalid
        }
        else if(item == null){ // checking if the item exists
            httpsession.setAttribute("state", 1); // state 1 means item is not invalid
        }
        else if(item.getCurrentUser() == null || !item.getCurrentUser().equals(user.getMail())){ // checking if user owns the item 
            httpsession.setAttribute("state", 5); // state 5 means item is not taken by the user
        }
        else{            
            Query query2 = session.createQuery(
            "from ItemOperation where returnedDate is NULL and item_no="+itemNo);
            List<ItemOperation> result2 = query2.list();
            
            Query query3 = session.createQuery(
            "from ItemReservation where state = 5 and itemNo = "+itemNo);
            List<ItemReservation> result3 = query3.list();
            
            ItemOperation io = (ItemOperation) session.get(ItemOperation.class, result2.get(0).getOperationId());
            io.setReturnedDate(new Timestamp(new Date().getTime()));
            
            item.setCurrentUser(null);
            if(result3.isEmpty())
                item.setState(0);
            else
                item.setState(1);
            
            Calendar c=new GregorianCalendar();
            c.add(Calendar.DATE, userType.getMaxReserveDay());
            Date date = c.getTime();
            
            if(!result3.isEmpty()){
                result3.get(0).setState(1);
                result3.get(0).setReservationStart(new Timestamp(new Date().getTime()));
                result3.get(0).setReservationEnd(new Timestamp(date.getTime()));
            }
            
            user.setBorrowedItemCount(user.getBorrowedItemCount() - 1 );
            
            if(io.getExpireDate().before(io.getReturnedDate())){
                long start = io.getReturnedDate().getTime();
                long end = io.getExpireDate().getTime();
                long diffTime = start - end;
                long diffDays = diffTime / (1000 * 60 * 60 * 24);
                Integer difference = (int) (long) diffDays;
                
                int newBalance = smartCard.getBalance() - difference;
                
                smartCard.setBalance(newBalance);
                httpsession.setAttribute("state", 9); // state 8 means penalty was enforced
                httpsession.setAttribute("amount", difference); // amount of penalty
                httpsession.setAttribute("newbalance", newBalance);
            }
            else{
                httpsession.setAttribute("state", 7); // state 7 means item is returned without penalty.
            }
            
            session.saveOrUpdate(user);
            session.saveOrUpdate(item);
            session.save(io);
            tx.commit();
        }
        response.sendRedirect("kiosk.jsp");
    }

}
