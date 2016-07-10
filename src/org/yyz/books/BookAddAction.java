package org.yyz.books;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.yyz.bean.BooleanResultBean;
import org.yyz.dao.BookDAO;
import org.yyz.dao.daoImpl.BookDAOImpl;
import org.yyz.util.JsonUtil;

/**
 * Created by yyz on 2016/7/6.
 */
public class BookAddAction extends ActionSupport {
    private String bookName,userName;
    private BookDAO bookDAOImpl;

    /**
     * delete book from personal book list
     * @return success or failure
     * @throws Exception
     */
    @Override
    public String execute() throws Exception {
        bookDAOImpl = new BookDAOImpl();
        boolean isSuccess = bookDAOImpl.addBook(bookName, userName);
        BooleanResultBean resultBean = new BooleanResultBean();
        if(isSuccess){
            resultBean.setResult("true");
        }else {
            resultBean.setResult("false");
        }
        //output type:json
        String data = JsonUtil.EntityToString(resultBean);
        ServletActionContext.getRequest().setAttribute("data",data);
        //clear data
        bookName = null;
        userName = null;

        return SUCCESS;
    }

    //getter and setter
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBookName() {

        return bookName;
    }

    public String getUserName() {
        return userName;
    }
}
