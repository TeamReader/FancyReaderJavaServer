package org.yyz.books;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import java.io.InputStream;

/**
 * Created by yyz on 2016/7/12.
 */
public class BookDownloadAction extends ActionSupport {
   private String bookUrl;
//    private InputStream targetFile;

    @Override
    public String execute() throws Exception {

        return SUCCESS;
    }

    /**
     * fetch txt file stream
     * @return
     */
    public InputStream getTargetFile(){
        InputStream in = null;
        try{
            in = ServletActionContext.getServletContext().getResourceAsStream(bookUrl);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            return in;
        }
//        in = ServletActionContext.getServletContext().getResourceAsStream(bookUrl);
//        targetFile = in;

    }

    //getter and setter
    public void setBookUrl(String bookUrl) {
        this.bookUrl = bookUrl;
    }

    public String getBookUrl() {

        return bookUrl;
    }
}
