package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "lecturer")
@PrimaryKeyJoinColumn(name = "mail")
public class Lecturer extends User{
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "department", nullable = false)
    private String department;
    @Column(name = "room_no", nullable = false)
    private String roomNo;
    
    //private static int MAX_LIMIT;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }
    
}
