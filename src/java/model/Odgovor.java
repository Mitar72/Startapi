/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Korisnik
 */
@Entity
@Table(name = "odgovor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Odgovor.findAll", query = "SELECT o FROM Odgovor o")
    , @NamedQuery(name = "Odgovor.findById", query = "SELECT o FROM Odgovor o WHERE o.id = :id")
    , @NamedQuery(name = "Odgovor.findByKonacanODdovor", query = "SELECT o FROM Odgovor o WHERE o.konacanODdovor = :konacanODdovor")})
public class Odgovor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "konacanODdovor")
    private String konacanODdovor;
    @JoinColumn(name = "pitanja_idpitanja", referencedColumnName = "idpitanja")
    @ManyToOne(optional = false)
    private Pitanja pitanjaIdpitanja;
    @JoinColumn(name = "startapId", referencedColumnName = "id")
    @ManyToOne
    private Startap startapId;

    public Odgovor() {
    }

    public Odgovor(Integer id) {
        this.id = id;
    }

    public Odgovor(Integer id, String konacanODdovor) {
        this.id = id;
        this.konacanODdovor = konacanODdovor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKonacanODdovor() {
        return konacanODdovor;
    }

    public void setKonacanODdovor(String konacanODdovor) {
        this.konacanODdovor = konacanODdovor;
    }

    public Pitanja getPitanjaIdpitanja() {
        return pitanjaIdpitanja;
    }

    public void setPitanjaIdpitanja(Pitanja pitanjaIdpitanja) {
        this.pitanjaIdpitanja = pitanjaIdpitanja;
    }

    public Startap getStartapId() {
        return startapId;
    }

    public void setStartapId(Startap startapId) {
        this.startapId = startapId;
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
        if (!(object instanceof Odgovor)) {
            return false;
        }
        Odgovor other = (Odgovor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Odgovor[ id=" + id + " ]";
    }
    
}
