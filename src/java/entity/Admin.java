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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MFEYET Daniel Steven
 */
@Entity
@Table(name = "admin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Admin.findAll", query = "SELECT a FROM Admin a"),
    @NamedQuery(name = "Admin.findByCniNumber", query = "SELECT a FROM Admin a WHERE a.cniNumber = :cniNumber"),
    @NamedQuery(name = "Admin.findById", query = "SELECT a FROM Admin a WHERE a.id = :id")})
public class Admin implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "cni_number")
    private String cniNumber;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "creatorId")
    private List<AccountType> accountTypeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "creatorId")
    private List<OperationType> operationTypeList;
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Sosuser sosuser;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "creatorId")
    private List<LocationType> locationTypeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "creatorId")
    private List<SosEventType> sosEventTypeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "creatorId")
    private List<Ressource> ressourceList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "creatorId")
    private List<Client> clientList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "creatorId")
    private List<StaticDescription> staticDescriptionList;

    public Admin() {
    }

    public Admin(Long id) {
        this.id = id;
    }

    public Admin(Long id, String cniNumber) {
        this.id = id;
        this.cniNumber = cniNumber;
    }

    public String getCniNumber() {
        return cniNumber;
    }

    public void setCniNumber(String cniNumber) {
        this.cniNumber = cniNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @XmlTransient
    public List<AccountType> getAccountTypeList() {
        return accountTypeList;
    }

    public void setAccountTypeList(List<AccountType> accountTypeList) {
        this.accountTypeList = accountTypeList;
    }

    @XmlTransient
    public List<OperationType> getOperationTypeList() {
        return operationTypeList;
    }

    public void setOperationTypeList(List<OperationType> operationTypeList) {
        this.operationTypeList = operationTypeList;
    }

    public Sosuser getSosuser() {
        return sosuser;
    }

    public void setSosuser(Sosuser sosuser) {
        this.sosuser = sosuser;
    }

    @XmlTransient
    public List<LocationType> getLocationTypeList() {
        return locationTypeList;
    }

    public void setLocationTypeList(List<LocationType> locationTypeList) {
        this.locationTypeList = locationTypeList;
    }

    @XmlTransient
    public List<SosEventType> getSosEventTypeList() {
        return sosEventTypeList;
    }

    public void setSosEventTypeList(List<SosEventType> sosEventTypeList) {
        this.sosEventTypeList = sosEventTypeList;
    }

    @XmlTransient
    public List<Ressource> getRessourceList() {
        return ressourceList;
    }

    public void setRessourceList(List<Ressource> ressourceList) {
        this.ressourceList = ressourceList;
    }

    @XmlTransient
    public List<Client> getClientList() {
        return clientList;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }

    @XmlTransient
    public List<StaticDescription> getStaticDescriptionList() {
        return staticDescriptionList;
    }

    public void setStaticDescriptionList(List<StaticDescription> staticDescriptionList) {
        this.staticDescriptionList = staticDescriptionList;
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
        if (!(object instanceof Admin)) {
            return false;
        }
        Admin other = (Admin) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Admin[ id=" + id + " ]";
    }
    
}
