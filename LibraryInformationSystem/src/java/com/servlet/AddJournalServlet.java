/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.dao.HibernateSession;
import com.model.Book;
import com.model.Journal;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "AddJournalServlet", urlPatterns = {"/addjournalservlet"})
public class AddJournalServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        String editor = request.getParameter("editor");
        String name = request.getParameter("name");
        int issue = Integer.parseInt(request.getParameter("issue"));
        String publication_date = request.getParameter("publicationdate");
        
        Session session = HibernateSession.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        HttpSession httpsession = request.getSession();
        
        Journal journal = new Journal();
        
        journal.setEditor(editor);
        journal.setPublicationDate(publication_date);
        journal.setIssue(issue);
        journal.setItemType(2);
        journal.setState(0);
        journal.setItemName(name);
        
        session.save(journal);
        tx.commit();
        httpsession.setAttribute("state", 2); 
        
        response.sendRedirect("addjournal.jsp");
    }

}
