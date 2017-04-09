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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MFEYET Daniel Steven
 */
@Entity
@Table(name = "dynamic_location")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DynamicLocation.findAll", query = "SELECT d FROM DynamicLocation d"),
    @NamedQuery(name = "DynamicLocation.findByCreated", query = "SELECT d FROM DynamicLocation d WHERE d.created = :created"),
    @NamedQuery(name = "DynamicLocation.findByLatitude", query = "SELECT d FROM DynamicLocation d WHERE d.latitude = :latitude"),
    @NamedQuery(name = "DynamicLocation.findByLongitude", query = "SELECT d FROM DynamicLocation d WHERE d.longitude = :longitude"),
    @NamedQuery(name = "DynamicLocation.findByModified", query = "SELECT d FROM DynamicLocation d WHERE d.modified = :modified"),
    @NamedQuery(name = "DynamicLocation.findByRay", query = "SELECT d FROM DynamicLocation d WHERE d.ray = :ray"),
    @NamedQuery(name = "DynamicLocation.findByState", query = "SELECT d FROM DynamicLocation d WHERE d.state = :state"),
    @NamedQuery(name = "DynamicLocation.findById", query = "SELECT d FROM DynamicLocation d WHERE d.id = :id")})
public class DynamicLocation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Basic(optional = false)
    @NotNull
    @Column(name = "latitude")
    private double latitude;
    @Basic(optional = false)
    @NotNull
    @Column(name = "longitude")
    private double longitude;
    @Basic(optional = false)
    @NotNull
    @Column(name = "modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modified;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ray")
    private double ray;
    @Basic(optional = false)
    @NotNull
    @Column(name = "state")
    private int state;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Long id;
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private SosLocation sosLocation;

    public DynamicLocation() {
    }

    public DynamicLocation(Long id) {
        this.id = id;
    }

    public DynamicLocation(Long id, Date created, double latitude, double longitude, Date modified, double ray, int state) {
        this.id = id;
        this.created = created;
        this.latitude = latitude;
        this.longitude = longitude;
        this.modified = modified;
        this.ray = ray;
        this.state = state;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public double getRay() {
        return ray;
    }

    public void setRay(double ray) {
        this.ray = ray;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SosLocation getSosLocation() {
        return sosLocation;
    }

    public void setSosLocation(SosLocation sosLocation) {
        this.sosLocation = sosLocation;
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
        if (!(object instanceof DynamicLocation)) {
            return false;
        }
        DynamicLocation other = (DynamicLocation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.DynamicLocation[ id=" + id + " ]";
    }
    
}
