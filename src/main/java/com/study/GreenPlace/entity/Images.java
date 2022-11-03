/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package  com.study.GreenPlace.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
@Table(name = "images")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Images.findAll", query = "SELECT i FROM Images i"),
    @NamedQuery(name = "Images.findByImagesId", query = "SELECT i FROM Images i WHERE i.imagesId = :imagesId"),
    @NamedQuery(name = "Images.findByImagesName", query = "SELECT i FROM Images i WHERE i.imagesName = :imagesName")})
public class Images implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "images_id")
    private Short imagesId;
    @Basic(optional = false)
    @Column(name = "images_name")
    private String imagesName;
    @JoinColumn(name = "places_id", referencedColumnName = "places_id")
    @ManyToOne(optional = false)
    @JsonBackReference
    private Places placesId;

    public Images() {
    }

    public Images(Short imagesId) {
        this.imagesId = imagesId;
    }

    public Images(Short imagesId, String imagesName) {
        this.imagesId = imagesId;
        this.imagesName = imagesName;
    }

    public Short getImagesId() {
        return imagesId;
    }

    public void setImagesId(Short imagesId) {
        this.imagesId = imagesId;
    }

    public String getImagesName() {
        return imagesName;
    }

    public void setImagesName(String imagesName) {
        this.imagesName = imagesName;
    }

    public Places getPlacesId() {
        return placesId;
    }

    public void setPlacesId(Places placesId) {
        this.placesId = placesId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (imagesId != null ? imagesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Images)) {
            return false;
        }
        Images other = (Images) object;
        if ((this.imagesId == null && other.imagesId != null) || (this.imagesId != null && !this.imagesId.equals(other.imagesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return " com.study.GreenPlace.entity.Images[ imagesId=" + imagesId + " ]";
    }
    
}
