package com.model;

/**
 *
 * @author ercan
 */
public class Journal {
    private int itemNo;
    private String editor;
    private int issue;
    private String publisher;
    
    void detailedInfo(){
        System.out.println(editor + publisher + issue + itemNo);
    };
}
