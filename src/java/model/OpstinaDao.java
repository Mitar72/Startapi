
package model;

import controler.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;


public class OpstinaDao {
   
    
     public static Opstina dohvatiOpstinuPoNazivu(String naziv){
     Transaction tx = null;
     Session session = HibernateUtil.createSessionFactory().openSession();
     Opstina opstina = new Opstina();
     List<Opstina> opstine;
     try{
        tx = session.beginTransaction();
        Criteria q =  session.createCriteria(Opstina.class).add(Restrictions.eq("naziv", naziv));        
        opstine = q.list();
        opstina = opstine.get(0);
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
     return opstina;
        
}
  
}
