/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;

/**
 *
 * @author Camer
 */
public class Entry {

    private int entryId;
    private String categoryName;
    private String heading;
    private Date published;
    private String imageName;
    private String imageCaption;
    private String author;
    private String content;

    public Entry(int entryId, String categoryName, String heading, Date published, String imageName, String imageCaption, String author, String content) {
        this.entryId = entryId;
        this.categoryName = categoryName;
        this.heading = heading;
        this.published = published;
        this.imageName = imageName;
        this.imageCaption = imageCaption;
        this.author = author;
        this.content = content;
    }

    public int getEntryId() {
        return entryId;
    }

    public void setEntryId(int entryId) {
        this.entryId = entryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public Date getPublished() {
        return published;
    }

    public void setPublished(Date published) {
        this.published = published;
    }

    public String getImageName() {
        return "img/" + imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageCaption() {
        return imageCaption;
    }

    public void setImageCaption(String imageCaption) {
        this.imageCaption = imageCaption;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
