/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.SmartCard;
import com.model.User;
import com.model.UserType;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author must
 */
public class UserDAO {
    private User user;
    private SmartCard card;
    private Session session;
    
    public User login(int cardNo, String password){
        session = HibernateSession.getSessionFactory().openSession();
        Transaction tx = null;
        
        try{
            tx = session.beginTransaction();
            card = (SmartCard) session.get(SmartCard.class, cardNo);
            
            //kart sahibini döndür
            if(card.getPassword().equals(password)){
                Query query = session.createSQLQuery("select mail from users where "
                        + "card_no ="+ card.getCardNo());
                
                List result = query.list();
                user = (User) session.get(User.class, result.get(0).toString());
               return  user;
            }
        }
        catch(Exception e){
            session.close();
        }
        
        return null; //null değişecek
    }
    
    public String findURL(User u1){
        session = HibernateSession.getSessionFactory().openSession();
        Transaction tx = null;
        String url = "error.jsp";
        
        try{
            tx = session.beginTransaction();
 
            UserType userType = (UserType) session.get(UserType.class, u1.getUserType());
            System.out.println("USER TYPE"+ userType.getMainPage());
            //tx.commit();
            return userType.getMainPage();
        }
        catch(Exception e){
            session.close();
            url = "aaaa.jsp";
        }  
        return url; //null değişecek
    }
    
    public int getMaxLimitCount(int type){
        int limit = 0 ;
        try{
            Query query = session.createQuery(
            "from UserType where typeNo="+type);
            List<UserType> result = query.list();
            
            limit = result.get(0).getMaxLimit();
        }
        catch(Exception e){
            System.err.println("hata");
        }
        return limit;
    }
}
