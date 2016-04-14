package model;

import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "mail")
    private String mail;
    @Column(name = "card_no", unique=true, nullable = false)
    private int smartCard;
    @Column(name = "id", unique=true, nullable = false)
    private int id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "surname", nullable = false)
    private String surname;
    @Column(name = "phone", unique = true)
    private String phone;
    @Column(name = "user_type", nullable = false)
    private int userType;
    @Column(name = "current_item_count", nullable = false)
    private int borrowedItemCount;
   
   // private ArrayList<ItemOperationable> itemList;

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getSmartCard() {
        return smartCard;
    }

    public void setSmartCard(int smartCard) {
        this.smartCard = smartCard;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public int getBorrowedItemCount() {
        return borrowedItemCount;
    }

    public void setBorrowedItemCount(int borrowedItemCount) {
        this.borrowedItemCount = borrowedItemCount;
    }
}
