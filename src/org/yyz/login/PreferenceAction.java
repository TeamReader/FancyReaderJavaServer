package org.yyz.login;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.yyz.dao.UserDAO;
import org.yyz.dao.daoImpl.UserDAOImpl;
import org.yyz.pojo.UserEntity;
import org.yyz.util.JsonUtil;


/**
 * Created by yyz on 2016/7/6.
 */
public class PreferenceAction extends ActionSupport {
    private String userName;
    private UserDAO userDAOImpl;

    /**
     * fetch user preference action
     * @return
     * @throws Exception
     */
    @Override
    public String execute() throws Exception {
        userDAOImpl = new UserDAOImpl();
        UserEntity userEntity = userDAOImpl.getPreference(userName);
        //output type:json
        String data = JsonUtil.EntityToString(userEntity);
        ServletActionContext.getRequest().setAttribute("data",data);
        //clear data
        userName = null;

        return SUCCESS;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {

        return userName;
    }
}
