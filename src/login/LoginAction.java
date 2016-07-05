package login;

import com.opensymphony.xwork2.ActionSupport;

import java.util.Date;

/**
 * Created by yyz on 2016/7/5.
 */
public class LoginAction extends ActionSupport {
    private String user_name;
    private String password;
    private String result;

    /**
     * descript:to check user
     * @return
     * @throws Exception
     */
    @Override
    public String execute() throws Exception {
        result = new Date().toString();


        return SUCCESS;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getPassword() {
        return password;
    }
}
