package org.yyz.books;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.yyz.bean.LoadBooksResultBean;
import org.yyz.dao.BookDAO;
import org.yyz.dao.daoImpl.BookDAOImpl;
import org.yyz.util.JsonUtil;

import java.util.List;

/**
 * Created by yyz on 2016/7/6.
 */
public class BookSearchAction extends ActionSupport {
    private String bookName;
    private BookDAO bookDAOImpl;

    /**
     * search books in server
     * @return
     * @throws Exception
     */
    @Override
    public String execute() throws Exception {
        bookDAOImpl = new BookDAOImpl();
        List<LoadBooksResultBean> list = bookDAOImpl.searchBooks(bookName);
        //output type:json
        String data = JsonUtil.EntityToString(list);
        ServletActionContext.getRequest().setAttribute("data",data);

        return SUCCESS;
    }

    //getter and setter
    public String getBookName() {
        return bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
