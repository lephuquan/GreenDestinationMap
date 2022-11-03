/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package  com.study.GreenPlace.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "places")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Places.findAll", query = "SELECT p FROM Places p"),
    @NamedQuery(name = "Places.findByPlacesId", query = "SELECT p FROM Places p WHERE p.placesId = :placesId"),
    @NamedQuery(name = "Places.findByPlacesName", query = "SELECT p FROM Places p WHERE p.placesName = :placesName"),
    @NamedQuery(name = "Places.findByLat", query = "SELECT p FROM Places p WHERE p.lat = :lat"),
    @NamedQuery(name = "Places.findByLon", query = "SELECT p FROM Places p WHERE p.lon = :lon"),
    @NamedQuery(name = "Places.findByCountry", query = "SELECT p FROM Places p WHERE p.country = :country"),
    @NamedQuery(name = "Places.findByDistrict", query = "SELECT p FROM Places p WHERE p.district = :district"),
    @NamedQuery(name = "Places.findByWard", query = "SELECT p FROM Places p WHERE p.ward = :ward"),
    @NamedQuery(name = "Places.findByStreet", query = "SELECT p FROM Places p WHERE p.street = :street"),
    @NamedQuery(name = "Places.findByDescription", query = "SELECT p FROM Places p WHERE p.description = :description"),
    @NamedQuery(name = "Places.findByStartday", query = "SELECT p FROM Places p WHERE p.startday = :startday"),
    @NamedQuery(name = "Places.findByMapid", query = "SELECT p FROM Places p WHERE p.mapid = :mapid"),
    @NamedQuery(name = "Places.findByStatus", query = "SELECT p FROM Places p WHERE p.status = :status"),
    @NamedQuery(name = "Places.findByCity", query = "SELECT p FROM Places p WHERE p.city = :city")})
public class Places implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "places_id")
    private Short placesId;
    @Basic(optional = false)
    @Column(name = "places_name")
    private String placesName;
    @Basic(optional = false)
    @Column(name = "lat")
    private String lat;
    @Basic(optional = false)
    @Column(name = "lon")
    private String lon;
    @Basic(optional = false)
    @Column(name = "country")
    private String country;
    @Basic(optional = false)
    @Column(name = "district")
    private String district;
    @Basic(optional = false)
    @Column(name = "ward")
    private String ward;
    @Basic(optional = false)
    @Column(name = "street")
    private String street;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "startday")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startday;
    @Basic(optional = false)
    @Column(name = "mapid")
    private long mapid;
    @Basic(optional = false)
    @Column(name = "status")
    private boolean status;
    @Basic(optional = false)
    @Column(name = "city")
    private String city;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "placesId")
    private Collection<Images> imagesCollection;
    @JoinColumn(name = "place_types_id", referencedColumnName = "place_types_id")
    @ManyToOne(optional = false)
    private PlaceTypes placeTypesId;
//    @JoinColumn(name = "users_id", referencedColumnName = "users_id")
//    @ManyToOne(optional = false)
//    private Users usersId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "placesId")
    private Collection<Comments> commentsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "placesId")
    private Collection<Ratings> ratingsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "placesId")
    private Collection<WishLists> wishListsCollection;

    public Places() {
    }

    public Places(Short placesId) {
        this.placesId = placesId;
    }

    public Places(Short placesId, String placesName, String lat, String lon, String country, String district, String ward, String street, String description, Date startday, long mapid, boolean status, String city) {
        this.placesId = placesId;
        this.placesName = placesName;
        this.lat = lat;
        this.lon = lon;
        this.country = country;
        this.district = district;
        this.ward = ward;
        this.street = street;
        this.description = description;
        this.startday = startday;
        this.mapid = mapid;
        this.status = status;
        this.city = city;
    }

    public Short getPlacesId() {
        return placesId;
    }

    public void setPlacesId(Short placesId) {
        this.placesId = placesId;
    }

    public String getPlacesName() {
        return placesName;
    }

    public void setPlacesName(String placesName) {
        this.placesName = placesName;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartday() {
        return startday;
    }

    public void setStartday(Date startday) {
        this.startday = startday;
    }

    public long getMapid() {
        return mapid;
    }

    public void setMapid(long mapid) {
        this.mapid = mapid;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @XmlTransient
    public Collection<Images> getImagesCollection() {
        return imagesCollection;
    }

    public void setImagesCollection(Collection<Images> imagesCollection) {
        this.imagesCollection = imagesCollection;
    }

    public PlaceTypes getPlaceTypesId() {
        return placeTypesId;
    }

    public void setPlaceTypesId(PlaceTypes placeTypesId) {
        this.placeTypesId = placeTypesId;
    }

//    public Users getUsersId() {
//        return usersId;
//    }
//
//    public void setUsersId(Users usersId) {
//        this.usersId = usersId;
//    }

    @XmlTransient
    public Collection<Comments> getCommentsCollection() {
        return commentsCollection;
    }

    public void setCommentsCollection(Collection<Comments> commentsCollection) {
        this.commentsCollection = commentsCollection;
    }

    @XmlTransient
    public Collection<Ratings> getRatingsCollection() {
        return ratingsCollection;
    }

    public void setRatingsCollection(Collection<Ratings> ratingsCollection) {
        this.ratingsCollection = ratingsCollection;
    }

    @XmlTransient
    public Collection<WishLists> getWishListsCollection() {
        return wishListsCollection;
    }

    public void setWishListsCollection(Collection<WishLists> wishListsCollection) {
        this.wishListsCollection = wishListsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (placesId != null ? placesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Places)) {
            return false;
        }
        Places other = (Places) object;
        if ((this.placesId == null && other.placesId != null) || (this.placesId != null && !this.placesId.equals(other.placesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return " com.study.GreenPlace.entity.Places[ placesId=" + placesId + " ]";
    }
    
}
