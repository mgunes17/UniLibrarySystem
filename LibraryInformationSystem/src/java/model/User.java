package model;

import java.util.ArrayList;

public class User {
    private SmartCard smartCard;
    private String name;
    private String surname;
    private String mail;
    private String phone;
    private int userType;
    private String iban;
    private int borrowedItemCount;
    private ArrayList<ItemOperationable> itemList;
}
