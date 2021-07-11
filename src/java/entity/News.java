/*
 * Copyright (C) 2021, FPT University<br>
 * J3.L.P0004<br>
 * Digital News<br>
 *
 * Record of change:<br>
 * DATE          Version    Author           DESCRIPTION<br>
 * 2021-05-18    1.0        NangNN           First Version<br>
 */
package entity;

import java.util.Date;

/**
 * This class used to contain attributes and methods getter, setter of <code>News</code> object
 * This class represents the <code>News</code> table in database
 * 
 * @author nangnnhe130538
 */
public class News {

    /**
     * <code>News</code> id
     */
    private int id;
    /**
     * <code>News</code> title
     */
    private String title;
    /**
     * <code>News</code> description
     */
    private String description;
    /**
     * <code>News</code> image
     */
    private String image;
    /**
     * <code>News</code> author
     */
    private String author;
    /**
     * <code>News</code> timePost
     */
    private Date timePost;
    /**
     * <code>News</code> shortDes
     */
    private String shortDes;

    /**
     * Constructor with no parameter
     */
    public News() {
    }

    /**
     * Constructor with parameter
     *
     * @param id it is an <code>int</code>
     * @param title it is a <code>java.lang.String</code>
     * @param description it is a <code>java.lang.String</code>
     * @param image it is a <code>java.lang.String</code>
     * @param author it is a <code>java.lang.String</code>
     * @param timePost it is a <code>java.util.Date</code>
     * @param shortDes it is a <code>java.lang.String</code>
     */
    public News(int id, String title, String description, String image, String author, Date timePost, String shortDes) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.image = image;
        this.author = author;
        this.timePost = timePost;
        this.shortDes = shortDes;
    }

    /**
     * Get value from id attribute of <code>News</code> class. <br>
     *
     * @return id it is an <code>int</code>
     */
    public int getId() {
        return id;
    }

    /**
     * Set value to id attribute of <code>News</code> class
     *
     * @param id id it is an <code>int</code>
     *
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get value from title attribute of <code>News</code> class. <br>
     *
     *
     * @return title it is a <code>java.lang.String</code>
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set value to title attribute of <code>News</code> class
     *
     * @param title it is a <code>java.lang.String</code>
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Get value from description attribute of <code>News</code> class. <br>
     *
     * @return description it is a <code>java.lang.String</code>
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set value to description attribute of <code>News</code> class
     *
     * @param description it is a <code>java.lang.String</code>
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get value from image attribute of <code>News</code> class. <br>
     *
     *
     * @return image it is a <code>java.lang.String</code>
     */
    public String getImage() {
        return image;
    }

    /**
     * Set value to image attribute of <code>News</code> class
     *
     * @param image it is a <code>java.lang.String</code>
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * Get value from author attribute of <code>News</code> class. <br>
     *
     *
     * @return author it is a <code>java.lang.String</code>
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Set value to author attribute of <code>News</code> class
     *
     * @param author it is a <code>java.lang.String</code>
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Get value from timePost attribute of <code>News</code> class. <br>
     *
     *
     * @return timePost it is a <code>java.util.Date</code>
     */
    public Date getTimePost() {
        return timePost;
    }

    /**
     * Set value to timePost attribute of <code>News</code> class
     *
     * @param timePost it is a <code>java.util.Date</code>
     */
    public void setTimePost(Date timePost) {
        this.timePost = timePost;
    }

    /**
     * Get value from shortDes attribute of <code>News</code> class. <br>
     *
     *
     * @return shortDes it is a <code>java.lang.String</code>
     */
    public String getShortDes() {
        return shortDes;
    }

    /**
     * Set value to shortDes attribute of <code>News</code> class
     *
     * @param shortDes it is a <code>java.lang.String</code>
     */
    public void setShortDes(String shortDes) {
        this.shortDes = shortDes;
    }

}
