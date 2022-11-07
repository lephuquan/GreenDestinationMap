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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "wish_list_items")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WishListItems.findAll", query = "SELECT w FROM WishListItems w"),
    @NamedQuery(name = "WishListItems.findByWishlistitemid", query = "SELECT w FROM WishListItems w WHERE w.wishlistitemid = :wishlistitemid")})
public class WishListItems implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "wishlistitemid")
    private Short wishlistitemid;
    @JoinColumn(name = "placeid", referencedColumnName = "placeid")
    @ManyToOne(optional = false)
    @JsonBackReference
    private Places placeid;
    @JoinColumn(name = "wishlistid", referencedColumnName = "wishlistid")
    @ManyToOne(optional = false)
    @JsonBackReference
    private WishLists wishlistid;

    public WishListItems() {
    }

    public WishListItems(Short wishlistitemid) {
        this.wishlistitemid = wishlistitemid;
    }

    public Short getWishlistitemid() {
        return wishlistitemid;
    }

    public void setWishlistitemid(Short wishlistitemid) {
        this.wishlistitemid = wishlistitemid;
    }

    public Places getPlaceid() {
        return placeid;
    }

    public void setPlaceid(Places placeid) {
        this.placeid = placeid;
    }

    public WishLists getWishlistid() {
        return wishlistid;
    }

    public void setWishlistid(WishLists wishlistid) {
        this.wishlistid = wishlistid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (wishlistitemid != null ? wishlistitemid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WishListItems)) {
            return false;
        }
        WishListItems other = (WishListItems) object;
        if ((this.wishlistitemid == null && other.wishlistitemid != null) || (this.wishlistitemid != null && !this.wishlistitemid.equals(other.wishlistitemid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.study.GreenPlace.entity.WishListItems[ wishlistitemid=" + wishlistitemid + " ]";
    }
    
}
