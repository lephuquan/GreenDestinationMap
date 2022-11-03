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
@Table(name = "wish_lists")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WishLists.findAll", query = "SELECT w FROM WishLists w"),
    @NamedQuery(name = "WishLists.findByWishListsId", query = "SELECT w FROM WishLists w WHERE w.wishListsId = :wishListsId"),
    @NamedQuery(name = "WishLists.findByWishListsName", query = "SELECT w FROM WishLists w WHERE w.wishListsName = :wishListsName")})
public class WishLists implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "wish_lists_id")
    private Short wishListsId;
    @Basic(optional = false)
    @Column(name = "wish_lists_name")
    private String wishListsName;
    @JoinColumn(name = "places_id", referencedColumnName = "places_id")
    @ManyToOne(optional = false)
    private Places placesId;
//    @JoinColumn(name = "userid", referencedColumnName = "users_id")
//    @ManyToOne(optional = false)
//    private Users userid;

    public WishLists() {
    }

    public WishLists(Short wishListsId) {
        this.wishListsId = wishListsId;
    }

    public WishLists(Short wishListsId, String wishListsName) {
        this.wishListsId = wishListsId;
        this.wishListsName = wishListsName;
    }

    public Short getWishListsId() {
        return wishListsId;
    }

    public void setWishListsId(Short wishListsId) {
        this.wishListsId = wishListsId;
    }

    public String getWishListsName() {
        return wishListsName;
    }

    public void setWishListsName(String wishListsName) {
        this.wishListsName = wishListsName;
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
        hash += (wishListsId != null ? wishListsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WishLists)) {
            return false;
        }
        WishLists other = (WishLists) object;
        if ((this.wishListsId == null && other.wishListsId != null) || (this.wishListsId != null && !this.wishListsId.equals(other.wishListsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return " com.study.GreenPlace.entity.WishLists[ wishListsId=" + wishListsId + " ]";
    }
    
}
