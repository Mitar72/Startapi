/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import model.Startap;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

@ManagedBean
@RequestScoped
public class kont {
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
     public void uradi(){
     
     Startap s = new Startap();
     Transaction tx = null;
     Session session = HibernateUtil.createSessionFactory().openSession();
     s.setDatumOsnivanja(new Date());
     s.setPrezime("nikolic");
     s.setIme("Nikola");
     s.setPib(1235);
     s.setRegistarskiBroj(12357);
     s.setPunNaziv("Gvozden");
     s.setKorisnickoIme("Jovan");
     s.setLozinka("asdghgassd");
     s.setNagrade("asd nagradeee");
     s.setReference("asdsad reference");
        try{
        tx = session.beginTransaction();
//      s = (Startap)session.load(Startap.class,1);
      
      session.save(s);
      
        tx.commit();
        System.out.println(s.getIme()+" "+s.getTrenutnaFazaFirme());
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
