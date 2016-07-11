package org.yyz.login;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.yyz.bean.BooleanResultBean;
import org.yyz.dao.UserDAO;
import org.yyz.dao.daoImpl.UserDAOImpl;
import org.yyz.pojo.UserEntity;
import org.yyz.util.JsonUtil;

/**
 * Created by yyz on 2016/7/8.
 */
public class RegisterAction extends ActionSupport {
    private String userName,password;
    private UserDAO userDAOImpl;

    @Override
    public String execute() throws Exception {
        boolean flag = null == userName || null == password || userName.equals("") || password.equals("");

        BooleanResultBean booleanResultBean = new BooleanResultBean();
        if(flag){
            booleanResultBean.setResult("false");
        }
        else {
            userDAOImpl = new UserDAOImpl();
            UserEntity userEntity = new UserEntity();
            userEntity.setUserName(userName);
            userEntity.setPassword(password);
            boolean isSuccess = userDAOImpl.regist(userEntity);

            if(isSuccess){
                booleanResultBean.setResult("true");
            }
            else {
                booleanResultBean.setResult("false");
            }
        }

        ServletActionContext.getRequest().setAttribute("data", JsonUtil.EntityToString(booleanResultBean));

        return SUCCESS;
    }

    //getter and setter
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {

        return userName;
    }

    public String getPassword() {
        return password;
    }
}
