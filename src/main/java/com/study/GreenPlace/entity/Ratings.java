/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package  com.study.GreenPlace.entity;

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
    @NamedQuery(name = "Ratings.findByRatingsId", query = "SELECT r FROM Ratings r WHERE r.ratingsId = :ratingsId"),
    @NamedQuery(name = "Ratings.findByValueCriteria", query = "SELECT r FROM Ratings r WHERE r.valueCriteria = :valueCriteria")})
public class Ratings implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ratings_id")
    private Short ratingsId;
    @Basic(optional = false)
    @Column(name = "value_Criteria")
    private boolean valueCriteria;
    @JoinColumn(name = "criterias_id", referencedColumnName = "criterias_id")
    @ManyToOne(optional = false)
    private Criterias criteriasId;
    @JoinColumn(name = "places_id", referencedColumnName = "places_id")
    @ManyToOne(optional = false)
    private Places placesId;
//    @JoinColumn(name = "userid", referencedColumnName = "users_id")
//    @ManyToOne(optional = false)
//    private Users userid;

    public Ratings() {
    }

    public Ratings(Short ratingsId) {
        this.ratingsId = ratingsId;
    }

    public Ratings(Short ratingsId, boolean valueCriteria) {
        this.ratingsId = ratingsId;
        this.valueCriteria = valueCriteria;
    }

    public Short getRatingsId() {
        return ratingsId;
    }

    public void setRatingsId(Short ratingsId) {
        this.ratingsId = ratingsId;
    }

    public boolean getValueCriteria() {
        return valueCriteria;
    }

    public void setValueCriteria(boolean valueCriteria) {
        this.valueCriteria = valueCriteria;
    }

    public Criterias getCriteriasId() {
        return criteriasId;
    }

    public void setCriteriasId(Criterias criteriasId) {
        this.criteriasId = criteriasId;
    }

    public Places getPlacesId() {
        return placesId;
    }

    public void setPlacesId(Places placesId) {
        this.placesId = placesId;
    }

//    public Users getUserid() {
//        return userid;
//    }
//
//    public void setUserid(Users userid) {
//        this.userid = userid;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ratingsId != null ? ratingsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ratings)) {
            return false;
        }
        Ratings other = (Ratings) object;
        if ((this.ratingsId == null && other.ratingsId != null) || (this.ratingsId != null && !this.ratingsId.equals(other.ratingsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return " com.study.GreenPlace.entity.Ratings[ ratingsId=" + ratingsId + " ]";
    }
    
}
