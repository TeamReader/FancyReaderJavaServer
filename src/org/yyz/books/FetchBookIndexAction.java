package org.yyz.books;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.yyz.dao.BookDAO;
import org.yyz.dao.daoImpl.BookDAOImpl;
import org.yyz.pojo.RecordEntity;
import org.yyz.util.JsonUtil;

/**
 * Created by yyz on 2016/7/10.
 */
public class FetchBookIndexAction extends ActionSupport {
    private String userName,bookName;

    private BookDAO bookDAOImpl;
    /**
     * fetch book record index action
     * @return
     * @throws Exception
     */
    @Override
    public String execute() throws Exception {
        boolean flag = null==bookName || bookName.equals("") || null==userName || userName.equals("");
        RecordEntity recordEntity = null;
        if(!flag){
            bookDAOImpl = new BookDAOImpl();
            recordEntity = bookDAOImpl.fetchRecord(bookName, userName);
        }

        String data = JsonUtil.EntityToString(recordEntity);
        ServletActionContext.getRequest().setAttribute("data", data);

        return SUCCESS;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getUserName() {

        return userName;
    }

    public String getBookName() {
        return bookName;
    }
}
