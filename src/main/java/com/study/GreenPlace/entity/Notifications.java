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
@Table(name = "notifications")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Notifications.findAll", query = "SELECT n FROM Notifications n"),
    @NamedQuery(name = "Notifications.findByNotificationsId", query = "SELECT n FROM Notifications n WHERE n.notificationsId = :notificationsId"),
    @NamedQuery(name = "Notifications.findByTopic", query = "SELECT n FROM Notifications n WHERE n.topic = :topic"),
    @NamedQuery(name = "Notifications.findByNotificationsContent", query = "SELECT n FROM Notifications n WHERE n.notificationsContent = :notificationsContent"),
    @NamedQuery(name = "Notifications.findBySentDate", query = "SELECT n FROM Notifications n WHERE n.sentDate = :sentDate")})
public class Notifications implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "notifications_id")
    private Short notificationsId;
    @Basic(optional = false)
    @Column(name = "topic")
    private String topic;
    @Basic(optional = false)
    @Column(name = "notifications_content")
    private String notificationsContent;
    @Basic(optional = false)
    @Column(name = "sent_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sentDate;
//    @JoinColumn(name = "adminid", referencedColumnName = "users_id")
//    @ManyToOne(optional = false)
//    private Users adminid;
//    @JoinColumn(name = "userid", referencedColumnName = "users_id")
//    @ManyToOne(optional = false)
//    private Users userid;

    public Notifications() {
    }

    public Notifications(Short notificationsId) {
        this.notificationsId = notificationsId;
    }

    public Notifications(Short notificationsId, String topic, String notificationsContent, Date sentDate) {
        this.notificationsId = notificationsId;
        this.topic = topic;
        this.notificationsContent = notificationsContent;
        this.sentDate = sentDate;
    }

    public Short getNotificationsId() {
        return notificationsId;
    }

    public void setNotificationsId(Short notificationsId) {
        this.notificationsId = notificationsId;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getNotificationsContent() {
        return notificationsContent;
    }

    public void setNotificationsContent(String notificationsContent) {
        this.notificationsContent = notificationsContent;
    }

    public Date getSentDate() {
        return sentDate;
    }

    public void setSentDate(Date sentDate) {
        this.sentDate = sentDate;
    }

//    public Users getAdminid() {
//        return adminid;
//    }
//
//    public void setAdminid(Users adminid) {
//        this.adminid = adminid;
//    }
//
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
        hash += (notificationsId != null ? notificationsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Notifications)) {
            return false;
        }
        Notifications other = (Notifications) object;
        if ((this.notificationsId == null && other.notificationsId != null) || (this.notificationsId != null && !this.notificationsId.equals(other.notificationsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return " com.study.GreenPlace.entity.Notifications[ notificationsId=" + notificationsId + " ]";
    }
    
}
