/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ercan
 */
@WebServlet(name = "AddBalanceServletPrep", urlPatterns = {"/addbalanceservletprep"})
public class AddBalanceServletPrep extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{request.getSession().removeAttribute("result");} catch(Exception e){}
        try{request.getSession().removeAttribute("state");} catch(Exception e){}
        response.sendRedirect("addbalance.jsp");
    }


}
