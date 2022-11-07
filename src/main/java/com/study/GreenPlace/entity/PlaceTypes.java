/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.study.GreenPlace.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
    @NamedQuery(name = "PlaceTypes.findByPlacetypeid", query = "SELECT p FROM PlaceTypes p WHERE p.placetypeid = :placetypeid"),
    @NamedQuery(name = "PlaceTypes.findByType", query = "SELECT p FROM PlaceTypes p WHERE p.type = :type")})
public class PlaceTypes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "placetypeid")
    private Short placetypeid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "type")
    private String type;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "placetypeid")
    @JsonBackReference// important
    private Collection<Places> placesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "placetypeid")
    @JsonBackReference// important
    private Collection<Criterias> criteriasCollection;

    public PlaceTypes() {
    }

    public PlaceTypes(Short placetypeid) {
        this.placetypeid = placetypeid;
    }

    public PlaceTypes(Short placetypeid, String type) {
        this.placetypeid = placetypeid;
        this.type = type;
    }

    public Short getPlacetypeid() {
        return placetypeid;
    }

    public void setPlacetypeid(Short placetypeid) {
        this.placetypeid = placetypeid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        hash += (placetypeid != null ? placetypeid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlaceTypes)) {
            return false;
        }
        PlaceTypes other = (PlaceTypes) object;
        if ((this.placetypeid == null && other.placetypeid != null) || (this.placetypeid != null && !this.placetypeid.equals(other.placetypeid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.study.GreenPlace.entity.PlaceTypes[ placetypeid=" + placetypeid + " ]";
    }
    
}
