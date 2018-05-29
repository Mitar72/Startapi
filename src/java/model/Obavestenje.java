/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Korisnik
 */
@Entity
@Table(name = "obavestenje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Obavestenje.findAll", query = "SELECT o FROM Obavestenje o")
    , @NamedQuery(name = "Obavestenje.findById", query = "SELECT o FROM Obavestenje o WHERE o.id = :id")
    , @NamedQuery(name = "Obavestenje.findByDatumIVremeKreiranja", query = "SELECT o FROM Obavestenje o WHERE o.datumIVremeKreiranja = :datumIVremeKreiranja")
    , @NamedQuery(name = "Obavestenje.findByTipObavestenjaValjda", query = "SELECT o FROM Obavestenje o WHERE o.tipObavestenjaValjda = :tipObavestenjaValjda")
    , @NamedQuery(name = "Obavestenje.findByNaslov", query = "SELECT o FROM Obavestenje o WHERE o.naslov = :naslov")
    , @NamedQuery(name = "Obavestenje.findByTekst", query = "SELECT o FROM Obavestenje o WHERE o.tekst = :tekst")})
public class Obavestenje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datumIVremeKreiranja")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datumIVremeKreiranja = new Date();
    @Size(max = 45)
    @Column(name = "tipObavestenjaValjda")
    private String tipObavestenjaValjda ="na platformi";
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "naslov")
    private String naslov;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5000)
    @Column(name = "tekst")
    private String tekst;
    @JoinColumn(name = "investitorId", referencedColumnName = "Id")
    @ManyToOne
    private Investitor investitorId;

    public Obavestenje() {
    }

    public Obavestenje(Integer id) {
        this.id = id;
    }

    public Obavestenje(Integer id, Date datumIVremeKreiranja, String naslov, String tekst) {
        this.id = id;
        this.datumIVremeKreiranja = datumIVremeKreiranja;
        this.naslov = naslov;
        this.tekst = tekst;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDatumIVremeKreiranja() {
        return datumIVremeKreiranja;
    }

    public void setDatumIVremeKreiranja(Date datumIVremeKreiranja) {
        this.datumIVremeKreiranja = datumIVremeKreiranja;
    }

    public String getTipObavestenjaValjda() {
        return tipObavestenjaValjda;
    }

    public void setTipObavestenjaValjda(String tipObavestenjaValjda) {
        this.tipObavestenjaValjda = tipObavestenjaValjda;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public Investitor getInvestitorId() {
        return investitorId;
    }

    public void setInvestitorId(Investitor investitorId) {
        this.investitorId = investitorId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Obavestenje)) {
            return false;
        }
        Obavestenje other = (Obavestenje) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Obavestenje[ id=" + id + " ]";
    }
    
}
