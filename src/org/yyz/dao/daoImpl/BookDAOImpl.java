package org.yyz.dao.daoImpl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.yyz.bean.LoadBooksResultBean;
import org.yyz.dao.BookDAO;
import org.yyz.databaseBasic.HibernateUtil;
import org.yyz.pojo.RecordEntity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by yyz on 2016/7/6.
 */
public class BookDAOImpl implements BookDAO {
    /**
     * load personal books list
     * @param userName
     * @return
     */
    @Override
    public List<LoadBooksResultBean> loadBooks(String userName) {
        List<LoadBooksResultBean> list = null;
        if(null != userName && !userName.equals("")){
            list = new ArrayList<>();
            Session session = HibernateUtil.getSession();
            //begin transaction
            HibernateUtil.begin(session);

            String hsql = "select r.bookName,b.icoUrl,b.author,b.description from RecordEntity as r inner join BookEntity as b where r.userName=:username";
            Query query = session.createQuery(hsql);
            query.setString("username", userName);
            Iterator iterator = query.iterate();
            resultToList(iterator, list);

            //commit transaction
            HibernateUtil.commit(session);
        }
        return list;
    }

    /**
     * delete book from personal book list
     * @param bookName
     * @param userName
     * @return
     */
    @Override
    public boolean deleteBook(String bookName, String userName) {
        boolean isSuccess = false;
        if(null == bookName || null == userName
                || bookName.equals("") || userName.equals("")){
            return false;
        }
        Session session = HibernateUtil.getSession();
        //begin transaction
        HibernateUtil.begin(session);

        RecordEntity recordEntity = new RecordEntity();
        recordEntity.setUserName(userName);
        recordEntity.setBookName(bookName);
        recordEntity.setLineNum(0);

        session.delete(recordEntity);
        isSuccess = true;

        //commit transaction
        HibernateUtil.commit(session);

        return isSuccess;
    }

    /**
     * add book to personal book list
     * @param bookName
     * @param userName
     * @return
     */
    @Override
    public boolean addBook(String bookName, String userName) {
        boolean isSuccess = false;
        if(null == bookName || null == userName
                || bookName.equals("") || userName.equals("")){
            return false;
        }
        Session session = HibernateUtil.getSession();
        //begin transaction
        HibernateUtil.begin(session);

        RecordEntity recordEntity = new RecordEntity();
        recordEntity.setUserName(userName);
        recordEntity.setBookName(bookName);
        recordEntity.setLineNum(0);

        session.save(recordEntity);
        isSuccess = true;

        //commit transaction
        HibernateUtil.commit(session);

        return isSuccess;
    }

    /**
     * record the line num of (userName,bookName) to remember the position of reading
     * @param bookName
     * @param userName
     * @param lineNum
     * @return
     */
    @Override
    public boolean recordIndex(String bookName, String userName, int lineNum) {
        boolean isSuccess = false;
        if(null == bookName || null == userName
                || bookName.equals("") || userName.equals("") || lineNum < 0){
            return false;
        }
        Session session = HibernateUtil.getSession();
        //begin transaction
        HibernateUtil.begin(session);

        RecordEntity recordEntity = new RecordEntity();
        recordEntity.setUserName(userName);
        recordEntity.setBookName(bookName);
        recordEntity.setLineNum(lineNum);

        session.save(recordEntity);
        isSuccess = true;

        //commit transaction
        HibernateUtil.commit(session);

        return isSuccess;
    }

    /**
     * search books in server
     *      if bookName equals null or its length is 1,then return all books
     *      else return books whose name contains bookName
     * @param bookName
     * @return
     */
    @Override
    public List<LoadBooksResultBean> searchBooks(String bookName) {
        List<LoadBooksResultBean> list = new ArrayList<>();
        Session session = HibernateUtil.getSession();
        //begin transaction
        HibernateUtil.begin(session);

        String hql = null;
        if(null == bookName || bookName.equals("")){
            hql = "select b.bookName,b.icoUrl,b.author,b.description from BookEntity as b";
            Query query = session.createQuery(hql);
            Iterator iterator = query.iterate();

            resultToList(iterator, list);
        }else{
            hql = "select b.bookName,b.icoUrl,b.author,b.description from BookEntity as b where b.bookName like :bookName";
            Query query = session.createQuery(hql);
            query.setString("bookName","%"+bookName+"%");
            Iterator iterator = query.iterate();

            resultToList(iterator, list);
        }
        //commit transaction
        HibernateUtil.commit(session);

        return list;
    }

    /**
     * translate query result to List<LoadBooksResultBean> list
     * @param iterator
     * @param list
     */
    private void resultToList(Iterator iterator, List<LoadBooksResultBean> list){
        while (iterator.hasNext()){
            String[] result = (String[])iterator.next();
            LoadBooksResultBean bean = new LoadBooksResultBean();
            bean.setBookName(result[0]);
            bean.setIcoUrl(result[1]);
            bean.setAuthor(result[2]);
            bean.setDescription(result[3]);
            bean.setBookUrl("/resource/books/"+result[0]);
            list.add(bean);
        }
    }
}
