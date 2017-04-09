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
@Table(name = "ressource")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ressource.findAll", query = "SELECT r FROM Ressource r"),
    @NamedQuery(name = "Ressource.findById", query = "SELECT r FROM Ressource r WHERE r.id = :id"),
    @NamedQuery(name = "Ressource.findByCreated", query = "SELECT r FROM Ressource r WHERE r.created = :created"),
    @NamedQuery(name = "Ressource.findByDescription", query = "SELECT r FROM Ressource r WHERE r.description = :description"),
    @NamedQuery(name = "Ressource.findByModified", query = "SELECT r FROM Ressource r WHERE r.modified = :modified"),
    @NamedQuery(name = "Ressource.findByName", query = "SELECT r FROM Ressource r WHERE r.name = :name"),
    @NamedQuery(name = "Ressource.findByState", query = "SELECT r FROM Ressource r WHERE r.state = :state")})
public class Ressource implements Serializable {
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
    @JoinColumn(name = "creator_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Admin creatorId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ressourceId")
    private List<Operation> operationList;

    public Ressource() {
    }

    public Ressource(Long id) {
        this.id = id;
    }

    public Ressource(Long id, String description, String name, int state) {
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

    public Admin getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Admin creatorId) {
        this.creatorId = creatorId;
    }

    @XmlTransient
    public List<Operation> getOperationList() {
        return operationList;
    }

    public void setOperationList(List<Operation> operationList) {
        this.operationList = operationList;
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
        if (!(object instanceof Ressource)) {
            return false;
        }
        Ressource other = (Ressource) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Ressource[ id=" + id + " ]";
    }
    
}
