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
    @Column(name = "type_no")
    private int typeNo;
    @Column(name = "title")
    private String title;
    @Column(name = "main_page")
    private String mainPage;
    @Column(name = "max_limit")
    private int maxLimit;
    @Column(name = "max_reserve_day")
    private int maxReserveDay;

    public int getMaxReserveDay() {
        return maxReserveDay;
    }

    public void setMaxReserveDay(int maxReserveDay) {
        this.maxReserveDay = maxReserveDay;
    }
    
    public int getTypeNo() {
        return typeNo;
    }

    public void setTypeNo(int typeNo) {
        this.typeNo = typeNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMainPage() {
        return mainPage;
    }

    public void setMainPage(String mainPage) {
        this.mainPage = mainPage;
    }

    public int getMaxLimit() {
        return maxLimit;
    }

    public void setMaxLimit(int maxLimit) {
        this.maxLimit = maxLimit;
    }
}
