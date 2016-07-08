package org.yyz.dao.daoImpl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.yyz.dao.WebBookDAO;
import org.yyz.databaseBasic.HibernateUtil;
import org.yyz.pojo.BookEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yyz on 2016/7/7.
 */
public class WebBookDAOImpl implements WebBookDAO{
    @Override
    public void addBook(BookEntity bookEntity) {
        Session session = HibernateUtil.getSession();

        if(bookEntity != null && null != bookEntity.getBookName() && !bookEntity.getBookName().equals("")){
            //开始事务
            HibernateUtil.begin(session);

            session.save(bookEntity);
            session.flush();

            //提交
            HibernateUtil.commit(session);
        }

    }

    @Override
    public List<BookEntity> searchBook(String bookName) {
        List<BookEntity> list = new ArrayList<BookEntity>();
        Session session = HibernateUtil.getSession();
        //start transaction
        HibernateUtil.begin(session);


        String hql = null;
        if(null == bookName || bookName.equals("")){
            hql = "from BookEntity";
            Query query = session.createQuery(hql);
            list= (List<BookEntity>)query.list();

        }else{
            hql = "from BookEntity as b where b.bookName like :bookName";
            Query query = session.createQuery(hql);
            query.setString("bookName","%"+bookName+"%");

            list = (List<BookEntity>)query.list();
        }

        //commit transaction
        HibernateUtil.commit(session);

        return list;
    }

    @Override
    public void modifyBook(BookEntity bookEntity) {
        Session session = HibernateUtil.getSession();
        //start transaction
        HibernateUtil.begin(session);

        if(bookEntity != null && null != bookEntity.getBookName() && !bookEntity.getBookName().equals("")){
            session.update(bookEntity);
        }
        //commit transaction
        HibernateUtil.commit(session);
    }

    @Override
    public void deleteBook(String bookName) {
        Session session = HibernateUtil.getSession();
        //start transaction
        HibernateUtil.begin(session);

        if(null != bookName && !bookName.equals("")){
            BookEntity bookEntity = new BookEntity();
            bookEntity.setBookName(bookName);
            session.delete(bookEntity);
        }
        //commit transaction
        HibernateUtil.commit(session);
    }
}
