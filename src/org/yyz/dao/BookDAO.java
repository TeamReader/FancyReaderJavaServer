package org.yyz.dao;

import org.yyz.bean.LoadBooksResultBean;

import java.util.List;

/**
 * Created by yyz on 2016/7/6.
 */
public interface BookDAO {
    public List<LoadBooksResultBean> loadBooks(String userName);
    public boolean deleteBook(String bookName, String userName);
    public boolean addBook(String bookName, String userName);

    public boolean recordIndex(String bookName, String userName, int lineNum);
    public List<LoadBooksResultBean> searchBooks(String bookName);
}
