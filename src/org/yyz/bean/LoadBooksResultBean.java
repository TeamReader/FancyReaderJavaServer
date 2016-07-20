package org.yyz.bean;

/**
 * Created by yyz on 2016/7/6.
 */
public class LoadBooksResultBean {
    private String bookName,icoUrl,bookUrl,author,description;
//getter and setter
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setIcoUrl(String icoUrl) {
        this.icoUrl = icoUrl;
    }

    public void setBookUrl(String bookUrl) {
        this.bookUrl = bookUrl;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcoUrl() {

        return icoUrl;
    }

    public String getBookUrl() {
        return bookUrl;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public String getBookName() {

        return bookName;
    }
//construtor
    public LoadBooksResultBean(String bookName, String icoUrl, String bookUrl, String author, String description) {
        this.bookName = bookName;
        this.icoUrl = icoUrl;
        this.bookUrl = bookUrl;
        this.author = author;
        this.description = description;
    }

    public LoadBooksResultBean(){}
}
