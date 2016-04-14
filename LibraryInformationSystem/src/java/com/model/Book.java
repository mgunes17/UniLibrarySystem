package model;

/**
 *
 * @author ercan
 */
public class Book {
    private String author;
    private String publisher;
    private int publication_year;
    
    void detailedInfo(){
        System.out.println(author + publisher + publication_year);
    };
}
