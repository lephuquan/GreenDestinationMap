/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.study.GreenPlace.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "ratings")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ratings.findAll", query = "SELECT r FROM Ratings r"),
    @NamedQuery(name = "Ratings.findByRatingid", query = "SELECT r FROM Ratings r WHERE r.ratingid = :ratingid"),
    @NamedQuery(name = "Ratings.findByCriteriavalue", query = "SELECT r FROM Ratings r WHERE r.criteriavalue = :criteriavalue")})
public class Ratings implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ratingid")
    private Short ratingid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "criteriavalue")
    private boolean criteriavalue;
    @JoinColumn(name = "criteriaid", referencedColumnName = "criteriaid")
    @ManyToOne(optional = false)
    @JsonBackReference
    private Criterias criteriaid;
    @JoinColumn(name = "placeid", referencedColumnName = "placeid")
    @ManyToOne(optional = false)
    @JsonBackReference
    private Places placeid;
    @JoinColumn(name = "useridfr", referencedColumnName = "userid")
    @ManyToOne(optional = false)
    @JsonBackReference
    private Users useridfr;

    public Ratings() {
    }

    public Ratings(Short ratingid) {
        this.ratingid = ratingid;
    }

    public Ratings(Short ratingid, boolean criteriavalue) {
        this.ratingid = ratingid;
        this.criteriavalue = criteriavalue;
    }

    public Short getRatingid() {
        return ratingid;
    }

    public void setRatingid(Short ratingid) {
        this.ratingid = ratingid;
    }

    public boolean getCriteriavalue() {
        return criteriavalue;
    }

    public void setCriteriavalue(boolean criteriavalue) {
        this.criteriavalue = criteriavalue;
    }

    public Criterias getCriteriaid() {
        return criteriaid;
    }

    public void setCriteriaid(Criterias criteriaid) {
        this.criteriaid = criteriaid;
    }

    public Places getPlaceid() {
        return placeid;
    }

    public void setPlaceid(Places placeid) {
        this.placeid = placeid;
    }

    public Users getUseridfr() {
        return useridfr;
    }

    public void setUseridfr(Users useridfr) {
        this.useridfr = useridfr;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ratingid != null ? ratingid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ratings)) {
            return false;
        }
        Ratings other = (Ratings) object;
        if ((this.ratingid == null && other.ratingid != null) || (this.ratingid != null && !this.ratingid.equals(other.ratingid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.study.GreenPlace.entity.Ratings[ ratingid=" + ratingid + " ]";
    }
    
}
