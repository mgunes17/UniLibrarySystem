/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author must
 */
@Entity
@Table(name = "item_operation")
public class ItemOperation {
    @Id
    private String mail;
    @Column(name = "item_no", nullable = false)
    private int itemNo;
    @Column(name = "borrewed_date", nullable = false)
    private Date borrowedDate;
    @Column(name = "expire_date", nullable = false)
    private Date expireDate;
    @Column(name = "returned_date")
    private Date returnedDate;
}
