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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MFEYET Daniel Steven
 */
@Entity
@Table(name = "service_description_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ServiceDescriptionType.findAll", query = "SELECT s FROM ServiceDescriptionType s"),
    @NamedQuery(name = "ServiceDescriptionType.findById", query = "SELECT s FROM ServiceDescriptionType s WHERE s.id = :id"),
    @NamedQuery(name = "ServiceDescriptionType.findByCreated", query = "SELECT s FROM ServiceDescriptionType s WHERE s.created = :created"),
    @NamedQuery(name = "ServiceDescriptionType.findByDescription", query = "SELECT s FROM ServiceDescriptionType s WHERE s.description = :description"),
    @NamedQuery(name = "ServiceDescriptionType.findByModified", query = "SELECT s FROM ServiceDescriptionType s WHERE s.modified = :modified"),
    @NamedQuery(name = "ServiceDescriptionType.findByName", query = "SELECT s FROM ServiceDescriptionType s WHERE s.name = :name"),
    @NamedQuery(name = "ServiceDescriptionType.findByState", query = "SELECT s FROM ServiceDescriptionType s WHERE s.state = :state")})
public class ServiceDescriptionType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "description")
    private String description;
    @Column(name = "modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modified;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "state")
    private int state;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "typeId")
    private List<ServiceDescription> serviceDescriptionList;
    @JoinColumn(name = "creator_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Sosuser creatorId;

    public ServiceDescriptionType() {
    }

    public ServiceDescriptionType(Long id) {
        this.id = id;
    }

    public ServiceDescriptionType(Long id, String description, String name, int state) {
        this.id = id;
        this.description = description;
        this.name = name;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @XmlTransient
    public List<ServiceDescription> getServiceDescriptionList() {
        return serviceDescriptionList;
    }

    public void setServiceDescriptionList(List<ServiceDescription> serviceDescriptionList) {
        this.serviceDescriptionList = serviceDescriptionList;
    }

    public Sosuser getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Sosuser creatorId) {
        this.creatorId = creatorId;
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
        if (!(object instanceof ServiceDescriptionType)) {
            return false;
        }
        ServiceDescriptionType other = (ServiceDescriptionType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ServiceDescriptionType[ id=" + id + " ]";
    }
    
}
