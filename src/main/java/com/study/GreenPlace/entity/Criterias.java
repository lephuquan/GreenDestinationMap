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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "criterias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Criterias.findAll", query = "SELECT c FROM Criterias c"),
    @NamedQuery(name = "Criterias.findByCriteriasId", query = "SELECT c FROM Criterias c WHERE c.criteriasId = :criteriasId"),
    @NamedQuery(name = "Criterias.findByCriteriasName", query = "SELECT c FROM Criterias c WHERE c.criteriasName = :criteriasName"),
    @NamedQuery(name = "Criterias.findByImageGXI", query = "SELECT c FROM Criterias c WHERE c.imageGXI = :imageGXI")})
public class Criterias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "criterias_id")
    private Short criteriasId;
    @Basic(optional = false)
    @Column(name = "criterias_name")
    private short criteriasName;
    @Basic(optional = false)
    @Lob
    @Column(name = "image")
    private byte[] image;
    @Column(name = "image_GXI")
    private String imageGXI;
    @JoinColumn(name = "place_types_id", referencedColumnName = "place_types_id")
    @ManyToOne(optional = false)
    private PlaceTypes placeTypesId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "criteriasId")
    private Collection<Ratings> ratingsCollection;

    public Criterias() {
    }

    public Criterias(Short criteriasId) {
        this.criteriasId = criteriasId;
    }

    public Criterias(Short criteriasId, short criteriasName, byte[] image) {
        this.criteriasId = criteriasId;
        this.criteriasName = criteriasName;
        this.image = image;
    }

    public Short getCriteriasId() {
        return criteriasId;
    }

    public void setCriteriasId(Short criteriasId) {
        this.criteriasId = criteriasId;
    }

    public short getCriteriasName() {
        return criteriasName;
    }

    public void setCriteriasName(short criteriasName) {
        this.criteriasName = criteriasName;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getImageGXI() {
        return imageGXI;
    }

    public void setImageGXI(String imageGXI) {
        this.imageGXI = imageGXI;
    }

    public PlaceTypes getPlaceTypesId() {
        return placeTypesId;
    }

    public void setPlaceTypesId(PlaceTypes placeTypesId) {
        this.placeTypesId = placeTypesId;
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
        hash += (criteriasId != null ? criteriasId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Criterias)) {
            return false;
        }
        Criterias other = (Criterias) object;
        if ((this.criteriasId == null && other.criteriasId != null) || (this.criteriasId != null && !this.criteriasId.equals(other.criteriasId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return " com.study.GreenPlace.entity.Criterias[ criteriasId=" + criteriasId + " ]";
    }
    
}
