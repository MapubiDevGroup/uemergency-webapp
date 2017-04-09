/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MFEYET Daniel Steven
 */
@Entity
@Table(name = "sos_location")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SosLocation.findAll", query = "SELECT s FROM SosLocation s"),
    @NamedQuery(name = "SosLocation.findById", query = "SELECT s FROM SosLocation s WHERE s.id = :id")})
public class SosLocation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "sosLocation")
    private DynamicLocation dynamicLocation;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "sosLocation")
    private StaticDescription staticDescription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "locationId")
    private List<SosEvent> sosEventList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "locationId")
    private List<Account> accountList;

    public SosLocation() {
    }

    public SosLocation(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DynamicLocation getDynamicLocation() {
        return dynamicLocation;
    }

    public void setDynamicLocation(DynamicLocation dynamicLocation) {
        this.dynamicLocation = dynamicLocation;
    }

    public StaticDescription getStaticDescription() {
        return staticDescription;
    }

    public void setStaticDescription(StaticDescription staticDescription) {
        this.staticDescription = staticDescription;
    }

    @XmlTransient
    public List<SosEvent> getSosEventList() {
        return sosEventList;
    }

    public void setSosEventList(List<SosEvent> sosEventList) {
        this.sosEventList = sosEventList;
    }

    @XmlTransient
    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
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
        if (!(object instanceof SosLocation)) {
            return false;
        }
        SosLocation other = (SosLocation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.SosLocation[ id=" + id + " ]";
    }
    
}
