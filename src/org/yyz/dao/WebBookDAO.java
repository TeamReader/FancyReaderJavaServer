package org.yyz.dao;

import org.yyz.pojo.BookEntity;

import java.util.List;

/**
 * Created by yyz on 2016/7/7.
 */
public interface WebBookDAO {
    public void addBook(BookEntity bookEntity);
    public List<BookEntity> searchBook(String bookName);
    public void modifyBook(BookEntity bookEntity);
    public void deleteBook(String bookName);
}
