
package com.dao;

import com.model.SmartCard;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class SmartCardDAO {
    private Session session;
    
    public boolean addBalance(int cardNo, int amount){
        session = HibernateSession.getSessionFactory().openSession();
        
        try{
            SmartCard card = (SmartCard) session.get(SmartCard.class, cardNo);
            
            if(card.getBalance() + amount <= 0)
                return false;
            else{
                card.setBalance(card.getBalance() + cardNo);
                return true;
            }
                
        }
        catch(Exception e){
            return false;
        }
        
    
    }
}
