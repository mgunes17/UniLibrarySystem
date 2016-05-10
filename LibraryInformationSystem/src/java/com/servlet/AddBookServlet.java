/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.dao.HibernateSession;
import com.model.Book;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ercan
 */
@WebServlet(name = "AddBookServlet", urlPatterns = {"/addbookservlet"})
public class AddBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        String author = request.getParameter("author");
        String name = request.getParameter("name");
        int publication_year = Integer.parseInt(request.getParameter("publicationyear"));
        String publisher = request.getParameter("publisher");
        
        Session session = HibernateSession.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        HttpSession httpsession = request.getSession();
        
        Book book = new Book();
        
        book.setAuthor(author);
        book.setPublicatioYear(publication_year);
        book.setPublisher(publisher);
        book.setItemType(1);
        book.setState(0);
        book.setItemName(name);
        
        session.save(book);
        tx.commit();
        httpsession.setAttribute("state", 1); 
        
        response.sendRedirect("addbook.jsp");
    }

}
