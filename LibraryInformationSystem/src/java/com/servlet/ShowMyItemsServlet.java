/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.dao.HibernateSession;
import com.model.Book;
import com.model.Item;
import com.model.User;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "ShowMyItemsServlet", urlPatterns = {"/showmyitemsservlet"})
public class ShowMyItemsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Session session = HibernateSession.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        HttpSession httpsession = request.getSession();

        User user = (User) httpsession.getAttribute("user");
        
        Query query = session.createQuery(
        "from Item where currentUser = '" + user.getMail() + "'");
        List<Item> myItems = query.list();
        
        tx.commit();
        httpsession.setAttribute("state", 1); 
        httpsession.setAttribute("items", myItems);
        
        response.sendRedirect("myitems.jsp");
    }

}
