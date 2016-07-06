package org.yyz.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by yyz on 2016/7/5.
 */
public class RecordEntityPK implements Serializable {
    private String userName;
    private String bookName;

    @Column(name = "user_name")
    @Id
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(name = "book_name")
    @Id
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RecordEntityPK that = (RecordEntityPK) o;

        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (bookName != null ? !bookName.equals(that.bookName) : that.bookName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userName != null ? userName.hashCode() : 0;
        result = 31 * result + (bookName != null ? bookName.hashCode() : 0);
        return result;
    }
}
