package org.yyz.web;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.yyz.dao.WebBookDAO;
import org.yyz.dao.daoImpl.WebBookDAOImpl;
import org.yyz.pojo.BookEntity;

/**
 * Created by yyz on 2016/7/7.
 */
public class BookModifyAction extends ActionSupport {
    private String bookName,author,icoUrl,description;
    private WebBookDAO webBookDAOImpl;

    @Override
    public String execute() throws Exception {
        boolean flag = null == bookName || bookName.trim().equals("");
        if(flag){
            ServletActionContext.getRequest().setAttribute("result","failure");
        }
        else{
            webBookDAOImpl = new WebBookDAOImpl();
            BookEntity bookEntity = new BookEntity();
            bookEntity.setAuthor(author);
            bookEntity.setBookName(bookName);
            bookEntity.setDescription(description);

            webBookDAOImpl.modifyBook(bookEntity);


            ServletActionContext.getRequest().setAttribute("result","success");
        }

        return SUCCESS;
    }

    //getter and setter
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setIcoUrl(String icoUrl) {
        this.icoUrl = icoUrl;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBookName() {

        return bookName;
    }

    public String getAuthor() {
        return author;
    }

    public String getIcoUrl() {
        return icoUrl;
    }

    public String getDescription() {
        return description;
    }
}
