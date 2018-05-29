/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Korisnik
 */
@Entity
@Table(name = "vest")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vest.findAll", query = "SELECT v FROM Vest v")
    , @NamedQuery(name = "Vest.findById", query = "SELECT v FROM Vest v WHERE v.id = :id")
    , @NamedQuery(name = "Vest.findByNaziv", query = "SELECT v FROM Vest v WHERE v.naziv = :naziv")
    , @NamedQuery(name = "Vest.findByTekst", query = "SELECT v FROM Vest v WHERE v.tekst = :tekst")
    , @NamedQuery(name = "Vest.findByVremeKreiranja", query = "SELECT v FROM Vest v WHERE v.vremeKreiranja = :vremeKreiranja")})
public class Vest implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "naziv")
    private String naziv;
    @Size(max = 5000)
    @Column(name = "tekst")
    private String tekst;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vremeKreiranja")
    @Temporal(TemporalType.TIMESTAMP)
    private Date vremeKreiranja;
    @ManyToMany(mappedBy = "vestCollection")
    private Collection<Korisnik> korisnikCollection;
    @JoinColumn(name = "kategorijaVestiId", referencedColumnName = "id")
    @ManyToOne
    private Kategorijavesti kategorijaVestiId;
    @JoinColumn(name = "korisnikId", referencedColumnName = "id")
    @ManyToOne
    private Korisnik korisnikId;

    public Vest() {
    }

    public Vest(Integer id) {
        this.id = id;
    }

    public Vest(Integer id, String naziv, Date vremeKreiranja) {
        this.id = id;
        this.naziv = naziv;
        this.vremeKreiranja = vremeKreiranja;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public Date getVremeKreiranja() {
        return vremeKreiranja;
    }

    public void setVremeKreiranja(Date vremeKreiranja) {
        this.vremeKreiranja = vremeKreiranja;
    }

    @XmlTransient
    public Collection<Korisnik> getKorisnikCollection() {
        return korisnikCollection;
    }

    public void setKorisnikCollection(Collection<Korisnik> korisnikCollection) {
        this.korisnikCollection = korisnikCollection;
    }

    public Kategorijavesti getKategorijaVestiId() {
        return kategorijaVestiId;
    }

    public void setKategorijaVestiId(Kategorijavesti kategorijaVestiId) {
        this.kategorijaVestiId = kategorijaVestiId;
    }

    public Korisnik getKorisnikId() {
        return korisnikId;
    }

    public void setKorisnikId(Korisnik korisnikId) {
        this.korisnikId = korisnikId;
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
        if (!(object instanceof Vest)) {
            return false;
        }
        Vest other = (Vest) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Vest[ id=" + id + " ]";
    }
    
}
