/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
//import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIOutput;
//import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import model.Drzava;
import model.DrzavaDao;
import model.Grad;
import model.GradDao;
import model.Investitor;
import model.InvestitorDao;
import model.Opstina;
import model.OpstinaDao;
//import model.Projekat;
//import model.Startap;
//import model.StartapDao;
//import model.Temadiskusija;
import model.Ulica;
import model.UlicaDao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
//import org.primefaces.event.FileUploadEvent;
//import org.primefaces.model.UploadedFile;


@ManagedBean
@ViewScoped
public class RegistracijaInvestitora {  
    
List<Drzava> drzave = DrzavaDao.sveDrzave();    
String drzava;
List<Grad> gradovi = new ArrayList<Grad>();
String grad;
List<Opstina> opstine=  new ArrayList<Opstina>();
String opstina;
List<Ulica> ulice=  new ArrayList<Ulica>();
String ulica;
Opstina o;

    public String getNazivUlice() {
        return nazivUlice;
    }

    public void setNazivUlice(String nazivUlice) {
        this.nazivUlice = nazivUlice;
    }
String nazivUlice;






    public List<Grad> getGradovi() {
        return gradovi;
    }

    public void setGradovi(List<Grad> gradovi) {
        this.gradovi = gradovi;
    }
    
  public void promeniGradove() {   
       
      Drzava d = DrzavaDao.dohvatiDrzavuPoNazivu(drzava);
      gradovi=(List<Grad>) d.getGradCollection();
      grad = null;
      opstine = new ArrayList();
      opstina = null;
      ulice = new ArrayList();
      ulica = null;
      
    }
  public void promeniOpstine() {   
      Grad g = GradDao.dohvatiGradPoNazivu(grad);
      opstine=(List<Opstina>) g.getOpstinaCollection();
      opstina = null;
      ulice = new ArrayList();
      ulica = null;
      
    }
  public void promeniUlice() {   
      o = OpstinaDao.dohvatiOpstinuPoNazivu(opstina);
      ulice=(List<Ulica>) o.getUlicaCollection();
      
    }

    public List<Drzava> getDrzave() {
        return drzave;
    }

   
    public void setDrzave(List<Drzava> drzave) {
        this.drzave = drzave;
    }

    public String getDrzava() {
        return drzava;
    }

    public void setDrzava(String drzava) {
        this.drzava = drzava;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public List<Opstina> getOpstine() {
        return opstine;
    }

    public void setOpstine(List<Opstina> opstine) {
        this.opstine = opstine;
    }

    public String getOpstina() {
        return opstina;
    }

    public void setOpstina(String opstina) {
        this.opstina = opstina;
    }

    public List<Ulica> getUlice() {
        return ulice;
    }

    public void setUlice(List<Ulica> ulice) {
        this.ulice = ulice;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }
    

   
    

   
    
    
    
    
    
    //deo za ulice do ovde

//private Startap s = StartapDao.dohvatiStartapaPoIdu(6);

//private Projekat projekat = new Projekat();    
private Investitor investitor = new Investitor(); 
//private Startap startap = new Startap();
private String poruka = "";
//private Temadiskusija temadiskusije = new Temadiskusija();
private int ulicaId = 0;
//private UploadedFile file;
//private String destination="C:\\Users\\Korisnik\\Desktop\\slikeloga\\";
private boolean disejblovano = true;

    public boolean isDisejblovano() {
        return disejblovano;
    }

    public void setDisejblovano(boolean disejblovano) {
        this.disejblovano = disejblovano;
    }

//public UploadedFile getFile() {
//        return file;
//    }
// 
//    public void setFile(UploadedFile file) {
//        this.file = file;
//    }
//
//public void dodaj(FileUploadEvent event){
//         if(file != null) {
//            FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
//            FacesContext.getCurrentInstance().addMessage(null, message);
//        }
//        try {
//             
//            copyFile(event.getFile().getFileName(), event.getFile().getInputstream());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        
//    }  
// 
 
      
       public void disejbluj(){
          
           if(opstina!=null){  
                System.out.println("asdasdasdas dasdasda s "+ opstina);
               disejblovano = false;         
           }
           else{
               System.out.println("asdsadasdasdasdasdasdasddasdasd  null");
               disejblovano = true;
           }
               
                
     }
// 
//    public void copyFile(String fileName, InputStream in) {
//           try {
//              
//              
//                // write the inputStream to a FileOutputStream
//                OutputStream out = new FileOutputStream(new File(destination + fileName));
//              
//                int read = 0;
//                byte[] bytes = new byte[1024];
//              
//                while ((read = in.read(bytes)) != -1) {
//                    out.write(bytes, 0, read);
//                }
//              
//                in.close();
//                out.flush();
//                out.close();
//              
//                System.out.println("New file created!");
//                } catch (IOException e) {
//                System.out.println(e.getMessage());
//                }
//    }


//    public Temadiskusija getTemadiskusije() {
//        return temadiskusije;
//    }
//
//    public void setTemadiskusije(Temadiskusija temadiskusije) {
//        this.temadiskusije = temadiskusije;
//    }
//




//    public Projekat getProjekat() {
//        return projekat;
//    }
//
//    public void setProjekat(Projekat projekat) {
//        this.projekat = projekat;
//    }    
    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }

    public String getPoruka() {
        return poruka;
    }

//    public Startap getStartap() {
//        return startap;
//    }
//
//    public void setStartap(Startap startap) {
//        this.startap = startap;
//    }
//
//
//    public Startap getS() {
//        return s;
//    }
//
//    public void setS(Startap s) {
//        this.s = s;
//    }
    
    
    


public void proveriKorisnickoIme(AjaxBehaviorEvent e){    
    String korisnickoIme = (String)((UIOutput)e.getSource()).getValue();
    
    List<Investitor>korisnici = InvestitorDao.prtraziPoKorisnickomImenu(korisnickoIme);
    try {
     korisnici.get(0);
     poruka = "ime je zauzeto";        
    } catch (Exception exc) {
        poruka = "";
    }
        
    }



    public int getUlicaId() {
        return ulicaId;
    }

    public void setUlicaId(int ulicaId) {
        this.ulicaId = ulicaId;
    }


    public Investitor getInvestitor() {
        return investitor;
    }

    public void setInvestitor(Investitor investitor) {
        this.investitor = investitor;
    }
 
    
   
    public void sacuvajInvestitora(){ 
        System.out.println("uso u sacuvaj investitora");
            
    Session session = HibernateUtil.createSessionFactory().openSession();
    Transaction tx = null;
//         File file;
//    try {
//        file = File.createTempFile(investitor.getId().toString() ,".jpg", new File("investitorLogo"));
//        logoInvestitora.write(file.getAbsolutePath());
//    } catch (Exception ex) {
//        Logger.getLogger(Registracije.class.getName()).log(Level.SEVERE, null, ex);
//   } 
    
        
        
        
        Ulica ulica = new Ulica();
        System.out.println("ulicas je nova ulica()");
        if("".equals(nazivUlice.trim()) && ulicaId!=0){
            ulica = UlicaDao.dohvatiUlicuPoIdu(ulicaId);
            try {
                investitor.setUlicaId(ulica);
            } catch (Exception e){
            }
    
        }
        else if(!"".equals(nazivUlice.trim())) {
            System.out.println("uso sam u elzeeee");
            try { 
                System.out.println("uso sam u try");
                ulica = new Ulica();
                ulica.setOpstinaIdopstina(o);
                ulica.setNaziv(nazivUlice);
               
                
        tx = session.beginTransaction();
        session.save(ulica);
       
        tx.commit();
            }
    catch(Exception e){
        System.out.println("uso sam u catch");
    if(tx!=null){
        tx.rollback();
    }
        System.out.println(e);    
    }
           
        }
       
        
    investitor.setUlicaId(ulica);
        System.out.println("investitor ulica id:"+ulica.getId()+"investitor naziv ulice :"+ulica.getNaziv());
        
   
    try{
        tx = session.beginTransaction();
        session.save(investitor);
       
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
//     public void sacuvajStartapa(){  

        
//         File file;
//    try {
//        file = File.createTempFile(investitor.getId().toString() ,".jpg", new File("investitorLogo"));
//        logoInvestitora.write(file.getAbsolutePath());
//    } catch (Exception ex) {
//        Logger.getLogger(Registracije.class.getName()).log(Level.SEVERE, null, ex);
//   } 
    
        
        
        
        
//        if(ulicaId!=0){
//       Ulica ulica = UlicaDao.dohvatiUlicuPoIdu(ulicaId);
//            try {
//                startap.setUlicaId(ulica);
//            } catch (Exception e){
//            }
//    
//        }
//       
//        
//    
//    Session session = HibernateUtil.createSessionFactory().openSession();
//    Transaction tx = null;
//    try{
//        tx = session.beginTransaction();
//        session.save(startap);
//       
//        tx.commit();
//    }
//    catch(HibernateException e){
//    if(tx!=null){
//        tx.rollback();
//    }
//        System.out.println(e);    
//    }
//    finally{
//       if (session != null) {
//            try {
//                session.close();
//            } catch (HibernateException ignored) {
//                System.out.println("Couldn't close Session "+ ignored);
//            }
//        }  
//    }
//        
//    }
//
//    public void sacuvajProjekat(){  
//    Session session = HibernateUtil.createSessionFactory().openSession();
//    Transaction tx = null;
//    projekat.setStartapId(s);
//    try{
//        tx = session.beginTransaction();
//        session.save(projekat);
//      
//        tx.commit();
//    }
//    catch(HibernateException e){
//    if(tx!=null){
//        tx.rollback();
//    }
//        System.out.println(e);    
//    }
//    finally{
//       if (session != null) {
//            try {
//                session.close();
//            } catch (HibernateException ignored) {
//                System.out.println("Couldn't close Session "+ ignored);
//            }
//        }  
//    }
//      
//    }
//
//    public Registracije() {
//      
//        
//    }
   
    
}

    
