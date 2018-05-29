
package model;

import controler.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class DrzavaDao {
    
    
    
   public static List<Drzava> sveDrzave(){
     Transaction tx = null;
     Session session = HibernateUtil.createSessionFactory().openSession();
     List<Drzava> drzave = new ArrayList();
     try{
        tx = session.beginTransaction();
        Query q = session.getNamedQuery("Drzava.findAll");
        drzave = (List<Drzava>)q.list();
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
     
   for(Drzava d : drzave){
       System.out.println(d.getNaziv());
   }  
   return drzave;     
   }      
 
  public static Drzava dohvatiDrzavuPoNazivu(String naziv){
     Transaction tx = null;
     Session session = HibernateUtil.createSessionFactory().openSession();
     Drzava drzava = new Drzava();
     List<Drzava> drzave;
     try{
         
         
        tx = session.beginTransaction();
        Criteria q =  session.createCriteria(Drzava.class).add(Restrictions.eq("naziv", naziv));
        
        drzave = q.list();
        drzava = drzave.get(0);
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
            }
        }        

      
  }
     return drzava;
        
}
  
}
