/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
 * @author MFEYET Daniel Steven
 */
@Entity
@Table(name = "operation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Operation.findAll", query = "SELECT o FROM Operation o"),
    @NamedQuery(name = "Operation.findById", query = "SELECT o FROM Operation o WHERE o.id = :id"),
    @NamedQuery(name = "Operation.findByCreated", query = "SELECT o FROM Operation o WHERE o.created = :created"),
    @NamedQuery(name = "Operation.findByTargetId", query = "SELECT o FROM Operation o WHERE o.targetId = :targetId"),
    @NamedQuery(name = "Operation.findByValue", query = "SELECT o FROM Operation o WHERE o.value = :value")})
public class Operation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Lob
    @Column(name = "author")
    private byte[] author;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Basic(optional = false)
    @NotNull
    @Column(name = "target_id")
    private int targetId;
    @Size(max = 255)
    @Column(name = "value")
    private String value;
    @JoinColumn(name = "op_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private OperationType opId;
    @JoinColumn(name = "ressource_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Ressource ressourceId;

    public Operation() {
    }

    public Operation(Long id) {
        this.id = id;
    }

    public Operation(Long id, Date created, int targetId) {
        this.id = id;
        this.created = created;
        this.targetId = targetId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getAuthor() {
        return author;
    }

    public void setAuthor(byte[] author) {
        this.author = author;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public int getTargetId() {
        return targetId;
    }

    public void setTargetId(int targetId) {
        this.targetId = targetId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public OperationType getOpId() {
        return opId;
    }

    public void setOpId(OperationType opId) {
        this.opId = opId;
    }

    public Ressource getRessourceId() {
        return ressourceId;
    }

    public void setRessourceId(Ressource ressourceId) {
        this.ressourceId = ressourceId;
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
        if (!(object instanceof Operation)) {
            return false;
        }
        Operation other = (Operation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Operation[ id=" + id + " ]";
    }
    
}
