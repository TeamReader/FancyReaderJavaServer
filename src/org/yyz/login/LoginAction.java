package org.yyz.login;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.yyz.bean.BooleanResultBean;
import org.yyz.dao.UserDAO;
import org.yyz.dao.daoImpl.UserDAOImpl;
import org.yyz.pojo.UserEntity;
import org.yyz.util.JsonUtil;


/**
 * Created by yyz on 2016/7/5.
 */
public class LoginAction extends ActionSupport {
    private String userName,password;
    private String result;
    private UserDAO userDAOImpl;

    @Override
    public String execute() throws Exception {
//        result = new Date().getTime()+";"+user_name+";"+password;
//        String data = JsonUtil.EntityToString(result);
        UserEntity userEntity = new UserEntity();
        userEntity.setPassword(password);
        userEntity.setUserName(userName);
        userDAOImpl = new UserDAOImpl();
        boolean isExist = userDAOImpl.checkUser(userEntity);
        if(isExist){
            result = "true";
        }else{
            result = "false";
        }

        BooleanResultBean resultBean = new BooleanResultBean();
        resultBean.setResult(result);
        String data = JsonUtil.EntityToString(resultBean);
        ServletActionContext.getRequest().setAttribute("data",data);
//        ServletActionContext.getRequest().setAttribute("result",resultBean);

        return SUCCESS;
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getUserName() {

        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getResult() {
        return result;
    }
}
