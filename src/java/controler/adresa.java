
package controler;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIOutput;
import javax.faces.event.AjaxBehaviorEvent;
import model.Drzava;
import model.DrzavaDao;
import model.Grad;
import model.GradDao;
import model.Opstina;
import model.OpstinaDao;
import model.Ulica;

@ManagedBean
@ViewScoped
public class adresa {
 
List<Drzava> drzave = DrzavaDao.sveDrzave();    
String drzava;
List<Grad> gradovi = new ArrayList<Grad>();
String grad;
List<Opstina> opstine=  new ArrayList<Opstina>();
String opstina;
List<Ulica> ulice=  new ArrayList<Ulica>();
String ulica;





    public List<Grad> getGradovi() {
        return gradovi;
    }

    public void setGradovi(List<Grad> gradovi) {
        this.gradovi = gradovi;
    }
    
  public void promeniGradove() {   
       
      Drzava d = DrzavaDao.dohvatiDrzavuPoNazivu(drzava);
      gradovi=(List<Grad>) d.getGradCollection();
      
    }
  public void promeniOpstine() {   
      Grad g = GradDao.dohvatiGradPoNazivu(grad);
      opstine=(List<Opstina>) g.getOpstinaCollection();
      
    }
  public void promeniUlice() {   
      Opstina o = OpstinaDao.dohvatiOpstinuPoNazivu(opstina);
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
    

   
    

   
}
