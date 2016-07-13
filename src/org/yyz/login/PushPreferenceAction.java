package org.yyz.login;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.yyz.bean.BooleanResultBean;
import org.yyz.dao.UserDAO;
import org.yyz.dao.daoImpl.UserDAOImpl;
import org.yyz.pojo.UserEntity;
import org.yyz.util.JsonUtil;

/**
 * Created by yyz on 2016/7/10.
 */
public class PushPreferenceAction extends ActionSupport {
    private String userName,password,fontstyleApp,fontsizeApp;
    private String fontcolorApp,bgApp,fontstyleFx,fontsizeFx,fontcolorFx,bgFx;
    private UserDAO userDAOImpl;

    /**
     * set user preference action
     * @return
     * @throws Exception
     */
    @Override
    public String execute() throws Exception {
        boolean flag = null == userName || userName.equals("");
        String result = "false";
        if(!flag){
            UserEntity userEntity = new UserEntity();
            userEntity.setUserName(userName);
            userEntity.setPassword(password);
            userEntity.setFontstyleApp(fontstyleApp);
            userEntity.setFontsizeApp(fontsizeApp);
            userEntity.setFontcolorApp(fontcolorApp);
            userEntity.setBgApp(bgApp);

            userEntity.setFontstyleFx(fontstyleFx);
            userEntity.setFontsizeFx(fontsizeFx);
            userEntity.setFontcolorFx(fontcolorFx);
            userEntity.setBgFx(bgFx);

            userDAOImpl = new UserDAOImpl();

            boolean isSuccess = userDAOImpl.setPreference(userEntity);

            if(isSuccess){
                result = "true";
            }
        }

        BooleanResultBean booleanResultBean = new BooleanResultBean();
        booleanResultBean.setResult(result);
        String data = JsonUtil.EntityToString(booleanResultBean);
        ServletActionContext.getRequest().setAttribute("data",data);


        return SUCCESS;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getFontstyleApp() {
        return fontstyleApp;
    }

    public String getFontsizeApp() {
        return fontsizeApp;
    }

    public String getFontcolorApp() {
        return fontcolorApp;
    }

    public String getBgApp() {
        return bgApp;
    }

    public String getFontstyleFx() {
        return fontstyleFx;
    }

    public String getFontsizeFx() {
        return fontsizeFx;
    }

    public String getFontcolorFx() {
        return fontcolorFx;
    }

    public String getBgFx() {
        return bgFx;
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFontstyleApp(String fontstyleApp) {
        this.fontstyleApp = fontstyleApp;
    }

    public void setFontsizeApp(String fontsizeApp) {
        this.fontsizeApp = fontsizeApp;
    }

    public void setFontcolorApp(String fontcolorApp) {
        this.fontcolorApp = fontcolorApp;
    }

    public void setBgApp(String bgApp) {
        this.bgApp = bgApp;
    }

    public void setFontstyleFx(String fontstyleFx) {
        this.fontstyleFx = fontstyleFx;
    }

    public void setFontsizeFx(String fontsizeFx) {
        this.fontsizeFx = fontsizeFx;
    }

    public void setFontcolorFx(String fontcolorFx) {
        this.fontcolorFx = fontcolorFx;
    }

    public void setBgFx(String bgFx) {
        this.bgFx = bgFx;
    }


}
