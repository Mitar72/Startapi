
package controler;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.Investitor;
import model.InvestitorDao;
import model.Obavestenje;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


@ManagedBean
@ViewScoped
public class RegistracijaObavestenja {
    



    private Obavestenje Obavestenje = new Obavestenje();
    private Investitor i = InvestitorDao.dohvatiInvestitoraPoIdu(3);

    public Obavestenje getObavestenje() {
        return Obavestenje;
    }

    public void setObavestenje(Obavestenje Obavestenje) {
        this.Obavestenje = Obavestenje;
    }

    
    
    
    public void sacuvajObavestenje(){  
    Obavestenje.setInvestitorId(i);
    Session session = HibernateUtil.createSessionFactory().openSession();
    Transaction tx = null;
  
    try{
        tx = session.beginTransaction();
        session.save(Obavestenje);
      
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

    


