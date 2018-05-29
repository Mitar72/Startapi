
package model;

import controler.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class UlicaDao {
 
    public static Ulica dohvatiUlicuPoIdu(int id){
     Transaction tx = null;
     Session session = HibernateUtil.createSessionFactory().openSession();
     Ulica ulica = new Ulica();
     try{
        tx = session.beginTransaction();
        ulica = (Ulica)session.get(Ulica.class,id);
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
     
   return ulica;     
        
    }
    
}
