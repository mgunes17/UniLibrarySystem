package com.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name="smart_card")
public class SmartCard implements Serializable {
    @Id
    @Column(name="card_no")
    private int cardNo;
    @Column(name="password", nullable=false)
    private String password;
    @Column(name="start_date", nullable=false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date startDate;
    @Column(name="balance", nullable=false)
    private int balance;

    public int getCardNo() {
        return cardNo;
    }

    public void setCardNo(int cardNo) {
        this.cardNo = cardNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
