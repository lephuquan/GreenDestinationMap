/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package  com.study.GreenPlace.entity;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "place_types")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlaceTypes.findAll", query = "SELECT p FROM PlaceTypes p"),
    @NamedQuery(name = "PlaceTypes.findByPlaceTypesId", query = "SELECT p FROM PlaceTypes p WHERE p.placeTypesId = :placeTypesId"),
    @NamedQuery(name = "PlaceTypes.findByPlaceTypesName", query = "SELECT p FROM PlaceTypes p WHERE p.placeTypesName = :placeTypesName")})
public class PlaceTypes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "place_types_id")
    private Short placeTypesId;
    @Basic(optional = false)
    @Column(name = "place_types_name")
    private String placeTypesName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "placeTypesId")
    private Collection<Places> placesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "placeTypesId")
    private Collection<Criterias> criteriasCollection;

    public PlaceTypes() {
    }

    public PlaceTypes(Short placeTypesId) {
        this.placeTypesId = placeTypesId;
    }

    public PlaceTypes(Short placeTypesId, String placeTypesName) {
        this.placeTypesId = placeTypesId;
        this.placeTypesName = placeTypesName;
    }

    public Short getPlaceTypesId() {
        return placeTypesId;
    }

    public void setPlaceTypesId(Short placeTypesId) {
        this.placeTypesId = placeTypesId;
    }

    public String getPlaceTypesName() {
        return placeTypesName;
    }

    public void setPlaceTypesName(String placeTypesName) {
        this.placeTypesName = placeTypesName;
    }

    @XmlTransient
    public Collection<Places> getPlacesCollection() {
        return placesCollection;
    }

    public void setPlacesCollection(Collection<Places> placesCollection) {
        this.placesCollection = placesCollection;
    }

    @XmlTransient
    public Collection<Criterias> getCriteriasCollection() {
        return criteriasCollection;
    }

    public void setCriteriasCollection(Collection<Criterias> criteriasCollection) {
        this.criteriasCollection = criteriasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (placeTypesId != null ? placeTypesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlaceTypes)) {
            return false;
        }
        PlaceTypes other = (PlaceTypes) object;
        if ((this.placeTypesId == null && other.placeTypesId != null) || (this.placeTypesId != null && !this.placeTypesId.equals(other.placeTypesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return " com.study.GreenPlace.entity.PlaceTypes[ placeTypesId=" + placeTypesId + " ]";
    }
    
}
