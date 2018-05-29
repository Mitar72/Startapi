/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.Investitor;
import model.InvestitorDao;
import model.KategorijaVestiDao;
import model.Kategorijavesti;
import model.Oglas;
import model.Vest;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;



@ManagedBean
@ViewScoped
public class RegistracijaVesti {   

    private Vest vest = new Vest();
    private Investitor i = InvestitorDao.dohvatiInvestitoraPoIdu(3);
    private List<String> sveKategorijeVesti = KategorijaVestiDao.dohvatiNasloveSvihVesti();
    private String NazivKategorijeVesti;
   

    public List<String> getSveKategorijeVesti() {
        return sveKategorijeVesti;
    }

    public void setSveKategorijeVesti(List<String> sveKategorijeVesti) {
        this.sveKategorijeVesti = sveKategorijeVesti;
    }

   

    public String getNazivKategorijeVesti() {
        return NazivKategorijeVesti;
    }

    public void setNazivKategorijeVesti(String NazivKategorijeVesti) {
        this.NazivKategorijeVesti = NazivKategorijeVesti;
    }
    
    

        public Vest getVest() {
            return vest;
        }

        public void setVest(Vest vest) {
            this.vest = vest;
        }

     
        public List<String> completeText(String query) {
        List<String> results = new ArrayList<String>();
        for(String s : sveKategorijeVesti) {
            if (s.startsWith(query))
           results.add(s);
        }
         
        return results;
    }
        

       
    
    public void sacuvajVest(){  
    vest.setKorisnikId(i);
    
    List<Kategorijavesti> kv = KategorijaVestiDao.sveKategorijeVesti();
    for(Kategorijavesti k : kv){
        if(k.getNaslov().equals(NazivKategorijeVesti)){
            vest.setKategorijaVestiId(k);
            break;
        }
    }
       
        
         
       
    
      
    
    Session session = HibernateUtil.createSessionFactory().openSession();
    Transaction tx = null;
  
    try{
        tx = session.beginTransaction();
        
        session.save(vest);
      
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
