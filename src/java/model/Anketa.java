/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Korisnik
 */
@Entity
@Table(name = "anketa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Anketa.findAll", query = "SELECT a FROM Anketa a")
    , @NamedQuery(name = "Anketa.findById", query = "SELECT a FROM Anketa a WHERE a.id = :id")
    , @NamedQuery(name = "Anketa.findByNaziv", query = "SELECT a FROM Anketa a WHERE a.naziv = :naziv")
    , @NamedQuery(name = "Anketa.findByOpis", query = "SELECT a FROM Anketa a WHERE a.opis = :opis")
    , @NamedQuery(name = "Anketa.findByJavna", query = "SELECT a FROM Anketa a WHERE a.javna = :javna")})
public class Anketa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "naziv")
    private String naziv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "opis")
    private String opis;
    @Basic(optional = false)
    @NotNull
    @Column(name = "javna")
    private short javna;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "anketaId")
    private Collection<Pitanja> pitanjaCollection;
    @JoinColumn(name = "investitorIdId", referencedColumnName = "Id")
    @ManyToOne
    private Investitor investitorIdId;

    public Anketa() {
    }

    public Anketa(Integer id) {
        this.id = id;
    }

    public Anketa(Integer id, String naziv, String opis, short javna) {
        this.id = id;
        this.naziv = naziv;
        this.opis = opis;
        this.javna = javna;
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

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public short getJavna() {
        return javna;
    }

    public void setJavna(short javna) {
        this.javna = javna;
    }

    @XmlTransient
    public Collection<Pitanja> getPitanjaCollection() {
        return pitanjaCollection;
    }

    public void setPitanjaCollection(Collection<Pitanja> pitanjaCollection) {
        this.pitanjaCollection = pitanjaCollection;
    }

    public Investitor getInvestitorIdId() {
        return investitorIdId;
    }

    public void setInvestitorIdId(Investitor investitorIdId) {
        this.investitorIdId = investitorIdId;
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
        if (!(object instanceof Anketa)) {
            return false;
        }
        Anketa other = (Anketa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Anketa[ id=" + id + " ]";
    }
    
}
