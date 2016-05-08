package com.servlet;

import com.dao.UserDAO;
import com.model.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LoginControlServlet", urlPatterns = {"/logincontrolservlet"})
public class LoginControlServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       doPost(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int cardNo = Integer.parseInt(request.getParameter("card_no"));
        String password = request.getParameter("password");
        
        User user = new UserDAO().login(cardNo, password);
        String url = new UserDAO().findURL(user);
        
        
        response.sendRedirect(url);
                                         
    }


}
