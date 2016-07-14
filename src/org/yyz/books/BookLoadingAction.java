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
 *
 * load personal books list
 */
public class BookLoadingAction extends ActionSupport {
    private String userName;
    private BookDAO bookDAOImpl;

    /**
     * load personal books list
     * output type:json
     * @return
     * @throws Exception
     */
    @Override
    public String execute() throws Exception {
        bookDAOImpl = new BookDAOImpl();
        List<LoadBooksResultBean> list = bookDAOImpl.loadBooks(userName);

        //output type:json
        String data = JsonUtil.EntityToString(list);
        ServletActionContext.getRequest().setAttribute("data",data);
        //clear data
        userName = null;
        return SUCCESS;
    }

    //getter and setter
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {

        return userName;
    }


}
