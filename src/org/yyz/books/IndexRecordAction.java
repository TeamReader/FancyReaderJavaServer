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
public class IndexRecordAction extends ActionSupport {
    private String bookName,userName;
    private int lineNum;
    private BookDAO bookDAOImpl;

    @Override
    public String execute() throws Exception {
        bookDAOImpl = new BookDAOImpl();
        boolean isSuccess = bookDAOImpl.recordIndex(bookName, userName, lineNum);
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
        lineNum = -1;

        return SUCCESS;
    }

    //getter and setter
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setLineNum(int lineNum) {
        this.lineNum = lineNum;
    }

    public String getBookName() {

        return bookName;
    }

    public String getUserName() {
        return userName;
    }

    public int getLineNum() {
        return lineNum;
    }
}
