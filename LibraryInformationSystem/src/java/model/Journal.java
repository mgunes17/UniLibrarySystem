package model;

/**
 *
 * @author ercan
 */
public class Journal {
    private int itemNo;
    private String editor;
    private String issue;
    private int publisher;
    
    void detailedInfo(){
        System.out.println(editor + publisher + issue + itemNo);
    };
}
