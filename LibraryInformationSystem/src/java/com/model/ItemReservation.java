/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author ercan
 */
@Entity
@Table(name="item_reservation")
public class ItemReservation implements Serializable {
    @Id
    @Column(name="mail", nullable=false)
    private String mail;
    @Id
    @Column(name="item_no", nullable=false)
    private int itemNo;
    
    @Column(name="reservation_start")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date reservationStart;
    
    @Column(name="reservation_end")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date reservationEnd;

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getItemNo() {
        return itemNo;
    }

    public void setItemNo(int itemNo) {
        this.itemNo = itemNo;
    }

    public Date getReservationStart() {
        return reservationStart;
    }

    public void setReservationStart(Date reservationStart) {
        this.reservationStart = reservationStart;
    }

    public Date getReservationEnd() {
        return reservationEnd;
    }

    public void setReservationEnd(Date reservationEnd) {
        this.reservationEnd = reservationEnd;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
    
    @Column(name="state")
    private int state;   
}
