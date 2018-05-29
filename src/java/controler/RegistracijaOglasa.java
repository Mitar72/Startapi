
package controler;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.Investitor;
import model.InvestitorDao;
import model.Oglas;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


@ManagedBean
@ViewScoped
public class RegistracijaOglasa {


    private Oglas oglas = new Oglas();
    private Investitor i = InvestitorDao.dohvatiInvestitoraPoIdu(3);

    public Oglas getOglas() {
        return oglas;
    }

    public void setOglas(Oglas oglas) {
        this.oglas = oglas;
    }

    
    
    public void sacuvajOglas(){  
    oglas.setInvestitorId(i);
    Session session = HibernateUtil.createSessionFactory().openSession();
    Transaction tx = null;
  
    try{
        tx = session.beginTransaction();
        session.save(oglas);
      
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

    


    
