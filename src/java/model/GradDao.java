
package model;

import controler.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;


public class GradDao {
    
    public static Grad dohvatiGradPoNazivu(String naziv){
     Transaction tx = null;
     Session session = HibernateUtil.createSessionFactory().openSession();
     Grad grad = new Grad();
     List<Grad> gradovi;
     try{
        tx = session.beginTransaction();
        Criteria q =  session.createCriteria(Grad.class).add(Restrictions.eq("naziv", naziv));        
        gradovi = q.list();
        grad = gradovi.get(0);
        tx.commit();
      
    }
    catch(HibernateException e){
    if(tx!=null){
        tx.rollback();
    }
        System.out.println(e);    
    }
    finally{
       if (session != null) {
            try {
                session.close();
            } catch (HibernateException ignored) {
                System.out.println("Couldn't close Session "+ ignored);
            }
        }        

      
  }
     return grad;
        
}
  
    
}
