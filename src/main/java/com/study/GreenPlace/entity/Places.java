/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.study.GreenPlace.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
    @NamedQuery(name = "Places.findByPlaceid", query = "SELECT p FROM Places p WHERE p.placeid = :placeid"),
    @NamedQuery(name = "Places.findByStartday", query = "SELECT p FROM Places p WHERE p.startday = :startday"),
    @NamedQuery(name = "Places.findByMapid", query = "SELECT p FROM Places p WHERE p.mapid = :mapid"),
    @NamedQuery(name = "Places.findByStatus", query = "SELECT p FROM Places p WHERE p.status = :status"),
    @NamedQuery(name = "Places.findByPlacename", query = "SELECT p FROM Places p WHERE p.placename = :placename"),
    @NamedQuery(name = "Places.findByLat", query = "SELECT p FROM Places p WHERE p.lat = :lat"),
    @NamedQuery(name = "Places.findByLon", query = "SELECT p FROM Places p WHERE p.lon = :lon"),
    @NamedQuery(name = "Places.findByCountry", query = "SELECT p FROM Places p WHERE p.country = :country"),
    @NamedQuery(name = "Places.findByCity", query = "SELECT p FROM Places p WHERE p.city = :city"),
    @NamedQuery(name = "Places.findByDistrict", query = "SELECT p FROM Places p WHERE p.district = :district"),
    @NamedQuery(name = "Places.findByWard", query = "SELECT p FROM Places p WHERE p.ward = :ward"),
    @NamedQuery(name = "Places.findByDescription", query = "SELECT p FROM Places p WHERE p.description = :description"),
    @NamedQuery(name = "Places.findByStar", query = "SELECT p FROM Places p WHERE p.star = :star"),
    @NamedQuery(name = "Places.findByRoad", query = "SELECT p FROM Places p WHERE p.road = :road"),
    @NamedQuery(name = "Places.findByPhone", query = "SELECT p FROM Places p WHERE p.phone = :phone"),
    @NamedQuery(name = "Places.findByBrowserday", query = "SELECT p FROM Places p WHERE p.browserday = :browserday")})
public class Places implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "placeid")
    private Short placeid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "startday")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startday;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mapid")
    private long mapid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private boolean status;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "placename")
    private String placename;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "lat")
    private String lat;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "lon")
    private String lon;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "country")
    private String country;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "city")
    private String city;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "district")
    private String district;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ward")
    private String ward;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "star")
    private BigDecimal star;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "road")
    private String road;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "phone")
    private String phone;
    @Basic(optional = false)
    @NotNull
    @Column(name = "browserday")
    @Temporal(TemporalType.TIMESTAMP)
    private Date browserday;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "placeid")
    @JsonManagedReference
    private Collection<Images> imagesCollection;//<----- Trường nào bên này có quan hệ thì bên bảng kia quan hệ phải có  @JsonBackReference để chặn phá sinh collection
    @JoinColumn(name = "placetypeid", referencedColumnName = "placetypeid")
    @ManyToOne(optional = false)
    @JsonManagedReference
    private PlaceTypes placetypeid;//<----
    @JoinColumn(name = "userid", referencedColumnName = "userid")
    @ManyToOne(optional = false)
    private Users userid;//<---
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "placeid")
    private Collection<Comments> commentsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "placeid")
    private Collection<Ratings> ratingsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "placeid")
    private Collection<WishListItems> wishListItemsCollection;

    public Places() {
    }

    public Places(Short placeid) {
        this.placeid = placeid;
    }

    public Places(Short placeid, Date startday, long mapid, boolean status, String placename, String lat, String lon, String country, String city, String district, String ward, BigDecimal star, String road, String phone, Date browserday) {
        this.placeid = placeid;
        this.startday = startday;
        this.mapid = mapid;
        this.status = status;
        this.placename = placename;
        this.lat = lat;
        this.lon = lon;
        this.country = country;
        this.city = city;
        this.district = district;
        this.ward = ward;
        this.star = star;
        this.road = road;
        this.phone = phone;
        this.browserday = browserday;
    }

    public Short getPlaceid() {
        return placeid;
    }

    public void setPlaceid(Short placeid) {
        this.placeid = placeid;
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

    public String getPlacename() {
        return placename;
    }

    public void setPlacename(String placename) {
        this.placename = placename;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getStar() {
        return star;
    }

    public void setStar(BigDecimal star) {
        this.star = star;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBrowserday() {
        return browserday;
    }

    public void setBrowserday(Date browserday) {
        this.browserday = browserday;
    }

    @XmlTransient
    public Collection<Images> getImagesCollection() {
        return imagesCollection;
    }

    public void setImagesCollection(Collection<Images> imagesCollection) {
        this.imagesCollection = imagesCollection;
    }

    public PlaceTypes getPlacetypeid() {
        return placetypeid;
    }

    public void setPlacetypeid(PlaceTypes placetypeid) {
        this.placetypeid = placetypeid;
    }

    public Users getUserid() {
        return userid;
    }

    public void setUserid(Users userid) {
        this.userid = userid;
    }

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
    public Collection<WishListItems> getWishListItemsCollection() {
        return wishListItemsCollection;
    }

    public void setWishListItemsCollection(Collection<WishListItems> wishListItemsCollection) {
        this.wishListItemsCollection = wishListItemsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (placeid != null ? placeid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Places)) {
            return false;
        }
        Places other = (Places) object;
        if ((this.placeid == null && other.placeid != null) || (this.placeid != null && !this.placeid.equals(other.placeid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.study.GreenPlace.entity.Places[ placeid=" + placeid + " ]";
    }
    
}
