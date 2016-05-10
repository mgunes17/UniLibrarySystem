package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="journal")
@PrimaryKeyJoinColumn(name="item_no")
public class Journal extends Item{
    @Column(name="editor", nullable=false)
    private String editor;
    @Column(name="issue", nullable=false)
    private int issue;
    @Column(name="publication_date")
    private String publicationDate;

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public int getIssue() {
        return issue;
    }

    public void setIssue(int issue) {
        this.issue = issue;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }
    
    
}
