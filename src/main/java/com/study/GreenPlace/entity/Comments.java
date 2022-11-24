/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.study.GreenPlace.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "comments")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comments.findAll", query = "SELECT c FROM Comments c"),
//    @NamedQuery(name = "Comments.findByCommentid", query = "SELECT c FROM Comments c WHERE c.commentid = :commentid"),
    @NamedQuery(name = "Comments.findByPostdate", query = "SELECT c FROM Comments c WHERE c.postdate = :postdate"),
    @NamedQuery(name = "Comments.findByContent", query = "SELECT c FROM Comments c WHERE c.content = :content")})
public class Comments implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "commentid")
    private Short commentid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "postdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date postdate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "content")
    private String content;
    @JoinColumn(name = "placeid", referencedColumnName = "placeid")
    @ManyToOne(optional = false)
    @JsonBackReference
    private Places placeid;
    @JoinColumn(name = "useridfr", referencedColumnName = "userid")
    @ManyToOne(optional = false)
    @JsonBackReference
    private Users useridfr;

    public Comments() {
    }

    public Comments(Short commentid) {
        this.commentid = commentid;
    }

    public Comments(Short commentid, Date postdate, String content) {
        this.commentid = commentid;
        this.postdate = postdate;
        this.content = content;
    }

    public Short getCommentid() {
        return commentid;
    }

    public void setCommentid(Short commentid) {
        this.commentid = commentid;
    }

    public Date getPostdate() {
        return postdate;
    }

    public void setPostdate(Date postdate) {
        this.postdate = postdate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
        hash += (commentid != null ? commentid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comments)) {
            return false;
        }
        Comments other = (Comments) object;
        if ((this.commentid == null && other.commentid != null) || (this.commentid != null && !this.commentid.equals(other.commentid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.study.GreenPlace.entity.Comments[ commentid=" + commentid + " ]";
    }
    
}
