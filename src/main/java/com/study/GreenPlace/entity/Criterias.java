/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.study.GreenPlace.entity;

import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "criterias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Criterias.findAll", query = "SELECT c FROM Criterias c"),
    @NamedQuery(name = "Criterias.findByCriteriaid", query = "SELECT c FROM Criterias c WHERE c.criteriaid = :criteriaid"),
    @NamedQuery(name = "Criterias.findByImage", query = "SELECT c FROM Criterias c WHERE c.image = :image"),
    @NamedQuery(name = "Criterias.findByCriterianame", query = "SELECT c FROM Criterias c WHERE c.criterianame = :criterianame")})
public class Criterias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "criteriaid")
    private Short criteriaid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "image")
    private String image;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "criterianame")
    private String criterianame;

    @Column(name = "actor")
    private Integer actor;

    @JoinColumn(name = "placetypeid", referencedColumnName = "placetypeid")
    @ManyToOne(optional = false)
    private PlaceTypes placetypeid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "criteriaid")
    private Collection<Ratings> ratingsCollection;

    public Criterias() {
    }

    public Criterias(Short criteriaid) {
        this.criteriaid = criteriaid;
    }

    public Criterias(Short criteriaid, String image, String criterianame) {
        this.criteriaid = criteriaid;
        this.image = image;
        this.criterianame = criterianame;
    }

    public Short getCriteriaid() {
        return criteriaid;
    }

    public void setCriteriaid(Short criteriaid) {
        this.criteriaid = criteriaid;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCriterianame() {
        return criterianame;
    }

    public void setCriterianame(String criterianame) {
        this.criterianame = criterianame;
    }

   //---- manual add
   public Integer getActor() {
       return actor;
   }

    public void setActor(Integer actor) {
        this.actor = actor;
    }
    //---- manual add


    public PlaceTypes getPlacetypeid() {
        return placetypeid;
    }

    public void setPlacetypeid(PlaceTypes placetypeid) {
        this.placetypeid = placetypeid;
    }

    @XmlTransient
    public Collection<Ratings> getRatingsCollection() {
        return ratingsCollection;
    }

    public void setRatingsCollection(Collection<Ratings> ratingsCollection) {
        this.ratingsCollection = ratingsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (criteriaid != null ? criteriaid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Criterias)) {
            return false;
        }
        Criterias other = (Criterias) object;
        if ((this.criteriaid == null && other.criteriaid != null) || (this.criteriaid != null && !this.criteriaid.equals(other.criteriaid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.study.GreenPlace.entity.Criterias[ criteriaid=" + criteriaid + " ]";
    }
    
}
