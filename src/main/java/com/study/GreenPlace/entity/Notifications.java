/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.study.GreenPlace.entity;

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
@Table(name = "notifications")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Notifications.findAll", query = "SELECT n FROM Notifications n"),
    @NamedQuery(name = "Notifications.findByNotificationid", query = "SELECT n FROM Notifications n WHERE n.notificationid = :notificationid"),
    @NamedQuery(name = "Notifications.findBySentdate", query = "SELECT n FROM Notifications n WHERE n.sentdate = :sentdate"),
    @NamedQuery(name = "Notifications.findByState", query = "SELECT n FROM Notifications n WHERE n.state = :state"),
    @NamedQuery(name = "Notifications.findByTopic", query = "SELECT n FROM Notifications n WHERE n.topic = :topic"),
    @NamedQuery(name = "Notifications.findByNotificationcontent", query = "SELECT n FROM Notifications n WHERE n.notificationcontent = :notificationcontent")})
public class Notifications implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "notificationid")
    private Short notificationid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sentdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sentdate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "state")
    private boolean state;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "topic")
    private String topic;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "notificationcontent")
    private String notificationcontent;
    @JoinColumn(name = "useridfr", referencedColumnName = "userid")
    @ManyToOne(optional = false)
    private Users useridfr;
    @JoinColumn(name = "adminid", referencedColumnName = "userid")
    @ManyToOne(optional = false)
    private Users adminid;

    public Notifications() {
    }

    public Notifications(Short notificationid) {
        this.notificationid = notificationid;
    }

    public Notifications(Short notificationid, Date sentdate, boolean state, String topic, String notificationcontent) {
        this.notificationid = notificationid;
        this.sentdate = sentdate;
        this.state = state;
        this.topic = topic;
        this.notificationcontent = notificationcontent;
    }

    public Short getNotificationid() {
        return notificationid;
    }

    public void setNotificationid(Short notificationid) {
        this.notificationid = notificationid;
    }

    public Date getSentdate() {
        return sentdate;
    }

    public void setSentdate(Date sentdate) {
        this.sentdate = sentdate;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getNotificationcontent() {
        return notificationcontent;
    }

    public void setNotificationcontent(String notificationcontent) {
        this.notificationcontent = notificationcontent;
    }

    public Users getUseridfr() {
        return useridfr;
    }

    public void setUseridfr(Users useridfr) {
        this.useridfr = useridfr;
    }

    public Users getAdminid() {
        return adminid;
    }

    public void setAdminid(Users adminid) {
        this.adminid = adminid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (notificationid != null ? notificationid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Notifications)) {
            return false;
        }
        Notifications other = (Notifications) object;
        if ((this.notificationid == null && other.notificationid != null) || (this.notificationid != null && !this.notificationid.equals(other.notificationid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.study.GreenPlace.entity.Notifications[ notificationid=" + notificationid + " ]";
    }
    
}
