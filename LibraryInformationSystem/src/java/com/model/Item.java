package com.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;


@Entity
@Table(name="item")
@Inheritance(strategy=InheritanceType.JOINED)
public class Item implements Serializable{
    @Id
    @Column(name="item_no")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int itemNo;
    @Column(name="item_state", nullable=false)
    private int state;
    @Column(name="current__user")
    private String currentUser;
    @Column(name="item_name")
    private String itemName;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    @Column(name="item_type", nullable=false)
    private int itemType;

    public int getItemNo() {
        return itemNo;
    }

    public void setItemNo(int itemNo) {
        this.itemNo = itemNo;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(String currentUser) {
        this.currentUser = currentUser;
    }

    public int getItemType() {
        return itemType;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }
    
    
}
