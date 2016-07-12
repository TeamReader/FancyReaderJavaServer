package org.yyz.web;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.yyz.dao.WebBookDAO;
import org.yyz.dao.daoImpl.WebBookDAOImpl;
import org.yyz.pojo.BookEntity;

import java.util.List;

/**
 * Created by yyz on 2016/7/7.
 */
public class BookSearchAction extends ActionSupport {
    private String bookName;
    private WebBookDAO webBookDAOImpl;

    @Override
    public String execute() throws Exception {
        webBookDAOImpl = new WebBookDAOImpl();
        List<BookEntity> list = webBookDAOImpl.searchBook(bookName);

        ServletActionContext.getRequest().getSession().setAttribute("data", list);

        return SUCCESS;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookName() {

        return bookName;
    }
}
