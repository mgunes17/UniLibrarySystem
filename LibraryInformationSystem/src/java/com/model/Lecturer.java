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
    
}
