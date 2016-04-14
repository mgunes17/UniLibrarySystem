/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author must
 */
@Entity
@Table(name = "user_type")
public class UserType {
    @Id
    private int typeNo;
    @Column(name = "title")
    private String title;
    @Column(name = "main_page")
    private String mainPage;
    @Column(name = "max_limit")
    private int maxLimit;
}
