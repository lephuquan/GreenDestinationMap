/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.study.GreenPlace.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
import javax.persistence.Lob;
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
@Table(name = "users")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
//    @NamedQuery(name = "Users.findByUsersId", query = "SELECT u FROM Users u WHERE u.usersId = :usersId"),
//    @NamedQuery(name = "Users.findByFirstname", query = "SELECT u FROM Users u WHERE u.firstname = :firstname"),
//    @NamedQuery(name = "Users.findByLastname", query = "SELECT u FROM Users u WHERE u.lastname = :lastname"),
//    @NamedQuery(name = "Users.findByGender", query = "SELECT u FROM Users u WHERE u.gender = :gender"),
//    @NamedQuery(name = "Users.findByEmail", query = "SELECT u FROM Users u WHERE u.email = :email"),
//    @NamedQuery(name = "Users.findByPhonenumber", query = "SELECT u FROM Users u WHERE u.phonenumber = :phonenumber"),
//    @NamedQuery(name = "Users.findByAddress", query = "SELECT u FROM Users u WHERE u.address = :address"),
//    @NamedQuery(name = "Users.findByAvatarGXI", query = "SELECT u FROM Users u WHERE u.avatarGXI = :avatarGXI"),
//    @NamedQuery(name = "Users.findByStartdate", query = "SELECT u FROM Users u WHERE u.startdate = :startdate"),
//    @NamedQuery(name = "Users.findByUsername", query = "SELECT u FROM Users u WHERE u.username = :username"),
//    @NamedQuery(name = "Users.findByPassword", query = "SELECT u FROM Users u WHERE u.password = :password")})
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "users_id")
    private Short usersId;
    @Basic(optional = false)
    @Column(name = "firstname")
    private String firstname;
    @Basic(optional = false)
    @Column(name = "lastname")
    private String lastname;
    @Basic(optional = false)
    @Column(name = "gender")
    private boolean gender;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "phonenumber")
    private String phonenumber;
    @Basic(optional = false)
    @Column(name = "address")
    private String address;
    @Basic(optional = false)
    @Lob
    @Column(name = "avatar")
    private byte[] avatar;
    @Column(name = "avatar_GXI")
    private String avatarGXI;
    @Basic(optional = false)
    @Column(name = "startdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startdate;
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usersId")
//    private Collection<Places> placesCollection;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userid")
//    private Collection<Comments> commentsCollection;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userid")
//    private Collection<Ratings> ratingsCollection;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userid")
//    private Collection<WishLists> wishListsCollection;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "adminid")
//    private Collection<Notifications> notificationsCollection;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userid")
//    private Collection<Notifications> notificationsCollection1;
    @JoinColumn(name = "roles_id", referencedColumnName = "roles_id")
    @ManyToOne(optional = false)
    @JsonBackReference
    private Roles rolesId;

    public Users() {
    }

    public Users(Short usersId) {
        this.usersId = usersId;
    }

    public Users(Short usersId, String firstname, String lastname, boolean gender, String email, String phonenumber, String address, byte[] avatar, Date startdate, String username, String password) {
        this.usersId = usersId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.email = email;
        this.phonenumber = phonenumber;
        this.address = address;
        this.avatar = avatar;
        this.startdate = startdate;
        this.username = username;
        this.password = password;
    }

    public Short getUsersId() {
        return usersId;
    }

    public void setUsersId(Short usersId) {
        this.usersId = usersId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }

    public String getAvatarGXI() {
        return avatarGXI;
    }

    public void setAvatarGXI(String avatarGXI) {
        this.avatarGXI = avatarGXI;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
//
//    @XmlTransient
//    public Collection<Places> getPlacesCollection() {
//        return placesCollection;
//    }
//
//    public void setPlacesCollection(Collection<Places> placesCollection) {
//        this.placesCollection = placesCollection;
//    }
//
//    @XmlTransient
//    public Collection<Comments> getCommentsCollection() {
//        return commentsCollection;
//    }
//
//    public void setCommentsCollection(Collection<Comments> commentsCollection) {
//        this.commentsCollection = commentsCollection;
//    }
//
//    @XmlTransient
//    public Collection<Ratings> getRatingsCollection() {
//        return ratingsCollection;
//    }
//
//    public void setRatingsCollection(Collection<Ratings> ratingsCollection) {
//        this.ratingsCollection = ratingsCollection;
//    }
//
//    @XmlTransient
//    public Collection<WishLists> getWishListsCollection() {
//        return wishListsCollection;
//    }
//
//    public void setWishListsCollection(Collection<WishLists> wishListsCollection) {
//        this.wishListsCollection = wishListsCollection;
//    }
//
//    @XmlTransient
//    public Collection<Notifications> getNotificationsCollection() {
//        return notificationsCollection;
//    }
//
//    public void setNotificationsCollection(Collection<Notifications> notificationsCollection) {
//        this.notificationsCollection = notificationsCollection;
//    }
//
//    @XmlTransient
//    public Collection<Notifications> getNotificationsCollection1() {
//        return notificationsCollection1;
//    }
//
//    public void setNotificationsCollection1(Collection<Notifications> notificationsCollection1) {
//        this.notificationsCollection1 = notificationsCollection1;
//    }
//
    public Roles getRolesId() {
        return rolesId;
    }

    public void setRolesId(Roles rolesId) {
        this.rolesId = rolesId;
    }

//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (usersId != null ? usersId.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof Users)) {
//            return false;
//        }
//        Users other = (Users) object;
//        if ((this.usersId == null && other.usersId != null) || (this.usersId != null && !this.usersId.equals(other.usersId))) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public String toString() {
//        return " com.study.GreenPlace.entity.Users[ usersId=" + usersId + " ]";
//    }
//
}
