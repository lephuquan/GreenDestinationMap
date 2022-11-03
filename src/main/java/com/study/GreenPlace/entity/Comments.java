/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package  com.study.GreenPlace.entity;

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
    @NamedQuery(name = "Comments.findByCommentsId", query = "SELECT c FROM Comments c WHERE c.commentsId = :commentsId"),
    @NamedQuery(name = "Comments.findByContent", query = "SELECT c FROM Comments c WHERE c.content = :content"),
    @NamedQuery(name = "Comments.findByPostDate", query = "SELECT c FROM Comments c WHERE c.postDate = :postDate")})
public class Comments implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "comments_id")
    private Short commentsId;
    @Basic(optional = false)
    @Column(name = "content")
    private String content;
    @Basic(optional = false)
    @Column(name = "post_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date postDate;
    @JoinColumn(name = "places_id", referencedColumnName = "places_id")
    @ManyToOne(optional = false)
    private Places placesId;
//    @JoinColumn(name = "userid", referencedColumnName = "users_id")
//    @ManyToOne(optional = false)
//    private Users userid;

    public Comments() {
    }

    public Comments(Short commentsId) {
        this.commentsId = commentsId;
    }

    public Comments(Short commentsId, String content, Date postDate) {
        this.commentsId = commentsId;
        this.content = content;
        this.postDate = postDate;
    }

    public Short getCommentsId() {
        return commentsId;
    }

    public void setCommentsId(Short commentsId) {
        this.commentsId = commentsId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
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
        hash += (commentsId != null ? commentsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comments)) {
            return false;
        }
        Comments other = (Comments) object;
        if ((this.commentsId == null && other.commentsId != null) || (this.commentsId != null && !this.commentsId.equals(other.commentsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return " com.study.GreenPlace.entity.Comments[ commentsId=" + commentsId + " ]";
    }
    
}
