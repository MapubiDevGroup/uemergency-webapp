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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MFEYET Daniel Steven
 */
@Entity
@Table(name = "service_description")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ServiceDescription.findAll", query = "SELECT s FROM ServiceDescription s"),
    @NamedQuery(name = "ServiceDescription.findById", query = "SELECT s FROM ServiceDescription s WHERE s.id = :id")})
public class ServiceDescription implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ServiceDescriptionType typeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "serviceDescriptionId")
    private List<DescriptionElement> descriptionElementList;
    @OneToMany(mappedBy = "serviceId")
    private List<Account> accountList;

    public ServiceDescription() {
    }

    public ServiceDescription(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ServiceDescriptionType getTypeId() {
        return typeId;
    }

    public void setTypeId(ServiceDescriptionType typeId) {
        this.typeId = typeId;
    }

    @XmlTransient
    public List<DescriptionElement> getDescriptionElementList() {
        return descriptionElementList;
    }

    public void setDescriptionElementList(List<DescriptionElement> descriptionElementList) {
        this.descriptionElementList = descriptionElementList;
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
        if (!(object instanceof ServiceDescription)) {
            return false;
        }
        ServiceDescription other = (ServiceDescription) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ServiceDescription[ id=" + id + " ]";
    }
    
}
