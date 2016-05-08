package com.servlet;

import com.dao.SmartCardDAO;
import com.model.SmartCard;
import com.model.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "AddBalanceServlet", urlPatterns = {"/addbalanceservlet"})
public class AddBalanceServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int amount = Integer.parseInt(request.getParameter("amount"));
        
        HttpSession httpsession = request.getSession();
        User user = (User) httpsession.getAttribute("user");
        
        boolean result = new SmartCardDAO().addBalance(user.getSmartCard(), amount);
        SmartCard smartCard = new SmartCardDAO().getSmartCard(user.getSmartCard());
        if(result == false){
            httpsession.setAttribute("result", 0);
            //jsp de yazdır
            //işlem gerçekleşmedi
            //paranız +0 olacak şekilde yükleme yapabilirsiniz
        }
        else{
            //para yüklendi
            //toplam paranız xxx 
            httpsession.setAttribute("balance", smartCard.getBalance());
            httpsession.setAttribute("result", 1);
        }
        
        response.sendRedirect("addbalance.jsp");
    }

}
