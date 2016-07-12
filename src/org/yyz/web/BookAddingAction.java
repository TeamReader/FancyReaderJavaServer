package org.yyz.web;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.yyz.dao.WebBookDAO;
import org.yyz.dao.daoImpl.WebBookDAOImpl;
import org.yyz.pojo.BookEntity;

/**
 * Created by yyz on 2016/7/7.
 */
public class BookAddingAction extends ActionSupport {
    private String bookName,icoUrl,author,description;

    /**
     * add book to server
     * @return
     * @throws Exception
     */
    @Override
    public String execute() throws Exception {
        boolean flag = null != bookName && !bookName.equals("") && null != author && !author.equals("");
        if(flag){
            WebBookDAO webBookDAOImpl = new WebBookDAOImpl();
            BookEntity bookEntity = new BookEntity();
            bookEntity.setBookName(bookName);
            bookEntity.setAuthor(author);
            bookEntity.setIcoUrl(icoUrl);
            bookEntity.setDescription(description);

            webBookDAOImpl.addBook(bookEntity);

            ServletActionContext.getRequest().setAttribute("result","success");
        }
        else{
            ServletActionContext.getRequest().setAttribute("result","failure");
        }

        return SUCCESS;
    }

    //getter and setter
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setIcoUrl(String icoUrl) {
        this.icoUrl = icoUrl;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBookName() {

        return bookName;
    }

    public String getIcoUrl() {
        return icoUrl;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }
}
