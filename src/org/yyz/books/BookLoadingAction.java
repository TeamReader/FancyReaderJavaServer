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
    private String user_name;
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
        List<LoadBooksResultBean> list = bookDAOImpl.loadBooks(user_name);

        //output type:json
        String data = JsonUtil.EntityToString(list);
        ServletActionContext.getRequest().setAttribute("data",data);
        //clear data
        user_name = null;
        return SUCCESS;
    }

    //getter and setter
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_name() {

        return user_name;
    }


}
