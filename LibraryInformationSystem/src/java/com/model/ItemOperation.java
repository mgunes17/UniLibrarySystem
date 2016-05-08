/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

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
@Table(name="item_operation")
public class ItemOperation {
    @Id
    @Column(name="operation_id")
    private int operationId;
    @Column(name="mail", nullable=false)
    private String mail;
    @Column(name="item_no", nullable=false)
    private int itemNo;
    @Column(name="borrowed_date", nullable=false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date borrowedDate;
    @Column(name="expire_date", nullable=false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date expireDate;
    @Column(name="returned_date")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date returnedDate;

    public int getOperationId() {
        return operationId;
    }

    public void setOperationId(int operationId) {
        this.operationId = operationId;
    }

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

    public Date getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(Date borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public Date getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(Date returnedDate) {
        this.returnedDate = returnedDate;
    }
    
    
}









