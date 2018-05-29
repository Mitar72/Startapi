
package model;

import controler.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class KategorijaVestiDao {
    
    
   public static List<Kategorijavesti> sveKategorijeVesti(){ 
     Transaction tx = null;
     Session session = HibernateUtil.createSessionFactory().openSession();
     List<Kategorijavesti> kategorijeVesti = new ArrayList();
     
     try{
        tx = session.beginTransaction();
        Query q = session.getNamedQuery("Kategorijavesti.findAll");
        kategorijeVesti = (List<Kategorijavesti>)q.list();
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
     
  
   return kategorijeVesti;     
    
}
   public static List<String> dohvatiNasloveSvihVesti(){
    List<String> naslovi = new ArrayList();
    List<Kategorijavesti> l = sveKategorijeVesti();
    for(Kategorijavesti k :l){
    naslovi.add(k.getNaslov());
    }
    return naslovi;
}
  
}
