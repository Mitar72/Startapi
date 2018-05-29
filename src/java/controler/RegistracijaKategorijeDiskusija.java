
package controler;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.Kategorijadiskusija;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;



@ManagedBean
@ViewScoped
public class RegistracijaKategorijeDiskusija {
    Kategorijadiskusija kategorijaDiskusija = new Kategorijadiskusija();

    public Kategorijadiskusija getKategorijaDiskusija() {
        return kategorijaDiskusija;
    }

    public void setKategorijaDiskusija(Kategorijadiskusija kategorijaDiskusija) {
        this.kategorijaDiskusija = kategorijaDiskusija;
    }
    
   
    
    public void sacuvajKategoruijuDiskusija(){  
    Session session = HibernateUtil.createSessionFactory().openSession();
    Transaction tx = null;
  
    try{
        tx = session.beginTransaction();
        session.save(kategorijaDiskusija);
      
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
      
    }

    
}
