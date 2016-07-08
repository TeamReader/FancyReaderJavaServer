package org.yyz.pojo;

import javax.persistence.*;

/**
 * Created by yyz on 2016/7/5.
 */
@Entity
@Table(name = "user", schema = "txtreader", catalog = "")
public class UserEntity {
    private String userName;
    private String password;
    private String fontstyleApp;
    private String fontsizeApp;
    private String fontcolorApp;
    private String bgApp;
    private String fontstyleFx;
    private String fontsizeFx;
    private String fontcolorFx;
    private String bgFx;

    @Id
    @Column(name = "user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "fontstyle_app")
    public String getFontstyleApp() {
        return fontstyleApp;
    }

    public void setFontstyleApp(String fontstyleApp) {
        this.fontstyleApp = fontstyleApp;
    }

    @Basic
    @Column(name = "fontsize_app")
    public String getFontsizeApp() {
        return fontsizeApp;
    }

    public void setFontsizeApp(String fontsizeApp) {
        this.fontsizeApp = fontsizeApp;
    }

    @Basic
    @Column(name = "fontcolor_app")
    public String getFontcolorApp() {
        return fontcolorApp;
    }

    public void setFontcolorApp(String fontcolorApp) {
        this.fontcolorApp = fontcolorApp;
    }

    @Basic
    @Column(name = "bg_app")
    public String getBgApp() {
        return bgApp;
    }

    public void setBgApp(String bgApp) {
        this.bgApp = bgApp;
    }

    @Basic
    @Column(name = "fontstyle_fx")
    public String getFontstyleFx() {
        return fontstyleFx;
    }

    public void setFontstyleFx(String fontstyleFx) {
        this.fontstyleFx = fontstyleFx;
    }

    @Basic
    @Column(name = "fontsize_fx")
    public String getFontsizeFx() {
        return fontsizeFx;
    }

    public void setFontsizeFx(String fontsizeFx) {
        this.fontsizeFx = fontsizeFx;
    }

    @Basic
    @Column(name = "fontcolor_fx")
    public String getFontcolorFx() {
        return fontcolorFx;
    }

    public void setFontcolorFx(String fontcolorFx) {
        this.fontcolorFx = fontcolorFx;
    }

    @Basic
    @Column(name = "bg_fx")
    public String getBgFx() {
        return bgFx;
    }

    public void setBgFx(String bgFx) {
        this.bgFx = bgFx;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
//        if (fontstyleApp != null ? !fontstyleApp.equals(that.fontstyleApp) : that.fontstyleApp != null) return false;
//        if (fontsizeApp != null ? !fontsizeApp.equals(that.fontsizeApp) : that.fontsizeApp != null) return false;
//        if (fontcolorApp != null ? !fontcolorApp.equals(that.fontcolorApp) : that.fontcolorApp != null) return false;
//        if (bgApp != null ? !bgApp.equals(that.bgApp) : that.bgApp != null) return false;
//        if (fontstyleFx != null ? !fontstyleFx.equals(that.fontstyleFx) : that.fontstyleFx != null) return false;
//        if (fontsizeFx != null ? !fontsizeFx.equals(that.fontsizeFx) : that.fontsizeFx != null) return false;
//        if (fontcolorFx != null ? !fontcolorFx.equals(that.fontcolorFx) : that.fontcolorFx != null) return false;
//        if (bgFx != null ? !bgFx.equals(that.bgFx) : that.bgFx != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userName != null ? userName.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (fontstyleApp != null ? fontstyleApp.hashCode() : 0);
        result = 31 * result + (fontsizeApp != null ? fontsizeApp.hashCode() : 0);
        result = 31 * result + (fontcolorApp != null ? fontcolorApp.hashCode() : 0);
        result = 31 * result + (bgApp != null ? bgApp.hashCode() : 0);
        result = 31 * result + (fontstyleFx != null ? fontstyleFx.hashCode() : 0);
        result = 31 * result + (fontsizeFx != null ? fontsizeFx.hashCode() : 0);
        result = 31 * result + (fontcolorFx != null ? fontcolorFx.hashCode() : 0);
        result = 31 * result + (bgFx != null ? bgFx.hashCode() : 0);
        return result;
    }
}
