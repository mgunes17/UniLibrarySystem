package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="book")
@PrimaryKeyJoinColumn(name="item_no")
public class Book extends Item{
    @Column(name="author", nullable=false)
    private String author;
    @Column(name="publisher", nullable=false)
    private String publisher;
    @Column(name="publication_year", nullable=false)
    private int publicationYear;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicatioYear(int publication_year) {
        this.publicationYear = publication_year;
    }
    
}
