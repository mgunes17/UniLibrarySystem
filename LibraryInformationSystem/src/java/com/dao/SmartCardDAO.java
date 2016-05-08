
package com.dao;

import com.model.SmartCard;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class SmartCardDAO {
    private Session session;
    
    public boolean addBalance(int cardNo, int amount){
        session = HibernateSession.getSessionFactory().openSession();
        
        try{
            Transaction tx = session.beginTransaction();
            SmartCard card = (SmartCard) session.get(SmartCard.class, cardNo);
            if(card.getBalance() + amount <= 0)
                return false;
            else{
                card.setBalance(card.getBalance() + amount);
                session.update(card);
                tx.commit();
                return true;
            }
                
        }
        catch(Exception e){
            return false;
        }
        finally{
            session.close();
        }
    }
    
    public SmartCard getSmartCard(int cardNo){
        session = HibernateSession.getSessionFactory().openSession();
        return (SmartCard) session.get(SmartCard.class, cardNo);
    }
    
}

