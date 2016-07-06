package org.yyz.pojo;

import javax.persistence.*;

/**
 * Created by yyz on 2016/7/5.
 */
@Entity
@Table(name = "record", schema = "txtreader", catalog = "")
@IdClass(RecordEntityPK.class)
public class RecordEntity {
    private String userName;
    private String bookName;
    private int lineNum;

    @Id
    @Column(name = "user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Id
    @Column(name = "book_name")
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Basic
    @Column(name = "line_num")
    public int getLineNum() {
        return lineNum;
    }

    public void setLineNum(int lineNum) {
        this.lineNum = lineNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RecordEntity that = (RecordEntity) o;

        if (lineNum != that.lineNum) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (bookName != null ? !bookName.equals(that.bookName) : that.bookName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userName != null ? userName.hashCode() : 0;
        result = 31 * result + (bookName != null ? bookName.hashCode() : 0);
        result = 31 * result + lineNum;
        return result;
    }
}
