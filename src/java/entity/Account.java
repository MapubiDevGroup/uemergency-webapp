/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MFEYET Daniel Steven
 */
@Entity
@Table(name = "account")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a"),
    @NamedQuery(name = "Account.findById", query = "SELECT a FROM Account a WHERE a.id = :id"),
    @NamedQuery(name = "Account.findByCreated", query = "SELECT a FROM Account a WHERE a.created = :created"),
    @NamedQuery(name = "Account.findByModified", query = "SELECT a FROM Account a WHERE a.modified = :modified"),
    @NamedQuery(name = "Account.findByState", query = "SELECT a FROM Account a WHERE a.state = :state")})
public class Account implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Basic(optional = false)
    @NotNull
    @Column(name = "modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modified;
    @Basic(optional = false)
    @NotNull
    @Column(name = "state")
    private int state;
    @JoinTable(name = "account_event_types", joinColumns = {
        @JoinColumn(name = "account_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "event_types_id", referencedColumnName = "id")})
    @ManyToMany
    private List<SosEventType> sosEventTypeList;
    @JoinColumn(name = "service_id", referencedColumnName = "id")
    @ManyToOne
    private ServiceDescription serviceId;
    @JoinColumn(name = "sos_user_id", referencedColumnName = "id")
    @ManyToOne
    private Client sosUserId;
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private AccountType typeId;
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SosLocation locationId;

    public Account() {
    }

    public Account(Long id) {
        this.id = id;
    }

    public Account(Long id, Date created, Date modified, int state) {
        this.id = id;
        this.created = created;
        this.modified = modified;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @XmlTransient
    public List<SosEventType> getSosEventTypeList() {
        return sosEventTypeList;
    }

    public void setSosEventTypeList(List<SosEventType> sosEventTypeList) {
        this.sosEventTypeList = sosEventTypeList;
    }

    public ServiceDescription getServiceId() {
        return serviceId;
    }

    public void setServiceId(ServiceDescription serviceId) {
        this.serviceId = serviceId;
    }

    public Client getSosUserId() {
        return sosUserId;
    }

    public void setSosUserId(Client sosUserId) {
        this.sosUserId = sosUserId;
    }

    public AccountType getTypeId() {
        return typeId;
    }

    public void setTypeId(AccountType typeId) {
        this.typeId = typeId;
    }

    public SosLocation getLocationId() {
        return locationId;
    }

    public void setLocationId(SosLocation locationId) {
        this.locationId = locationId;
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
        if (!(object instanceof Account)) {
            return false;
        }
        Account other = (Account) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Account[ id=" + id + " ]";
    }
    
}
