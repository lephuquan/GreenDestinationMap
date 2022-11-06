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
@Table(name = "wish_lists")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WishLists.findAll", query = "SELECT w FROM WishLists w"),
    @NamedQuery(name = "WishLists.findByWishlistid", query = "SELECT w FROM WishLists w WHERE w.wishlistid = :wishlistid"),
    @NamedQuery(name = "WishLists.findByWishlistname", query = "SELECT w FROM WishLists w WHERE w.wishlistname = :wishlistname")})
public class WishLists implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "wishlistid")
    private Short wishlistid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "wishlistname")
    private String wishlistname;
    @JoinColumn(name = "userid", referencedColumnName = "userid")
    @ManyToOne(optional = false)
    private Users userid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "wishlistid")
    private Collection<WishListItems> wishListItemsCollection;


    public WishLists() {
    }

    public WishLists(Short wishlistid) {
        this.wishlistid = wishlistid;
    }

    public WishLists(Short wishlistid, String wishlistname) {
        this.wishlistid = wishlistid;
        this.wishlistname = wishlistname;
    }

    public Short getWishlistid() {
        return wishlistid;
    }

    public void setWishlistid(Short wishlistid) {
        this.wishlistid = wishlistid;
    }

    public String getWishlistname() {
        return wishlistname;
    }

    public void setWishlistname(String wishlistname) {
        this.wishlistname = wishlistname;
    }

    public Users getUserid() {
        return userid;
    }

    public void setUserid(Users userid) {
        this.userid = userid;
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
        hash += (wishlistid != null ? wishlistid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WishLists)) {
            return false;
        }
        WishLists other = (WishLists) object;
        if ((this.wishlistid == null && other.wishlistid != null) || (this.wishlistid != null && !this.wishlistid.equals(other.wishlistid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.study.GreenPlace.entity.WishLists[ wishlistid=" + wishlistid + " ]";
    }
    
}
