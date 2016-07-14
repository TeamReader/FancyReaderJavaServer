package org.yyz.dao.daoImpl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.yyz.dao.UserDAO;
import org.yyz.databaseBasic.HibernateUtil;
import org.yyz.pojo.UserEntity;

import java.util.List;

/**
 * Created by yyz on 2016/7/6.
 */
public class UserDAOImpl implements UserDAO {

    /**
     * check if user is legal
     * @param user
     * @return
     */
    @Override
    public boolean checkUser(UserEntity user) {
        boolean flag = false;
        if(null == user || null == user.getUserName() || null == user.getPassword()
                || user.getUserName().equals("") || user.getPassword().equals("")){
            return false;
        }
        Session session = HibernateUtil.getSession();
        //begin transaction
        HibernateUtil.begin(session);

        String hsql = "from UserEntity as user where user.userName=:name and user.password=:pwd";
        Query query = session.createQuery(hsql);
        query.setString("name", user.getUserName());
        query.setString("pwd", user.getPassword());

        List<UserEntity> list = query.list();
        if(null == list || list.size() < 1){
            flag = false;
        }else {
            flag = true;
        }

        //commit transaction
        HibernateUtil.commit(session);

        return flag;
    }

    /**
     * fetch the setting of user client
     * @param userName
     * @return
     */
    @Override
    public UserEntity getPreference(String userName) {
        UserEntity userEntity = null;
        if(null == userName || userName.equals("")){
            return null;
        }
        Session session = HibernateUtil.getSession();
        //begin transaction
        HibernateUtil.begin(session);

        String hql = "from UserEntity as u where u.userName=:userName";
        Query query = session.createQuery(hql);
        query.setString("userName", userName);
        userEntity = (UserEntity) query.uniqueResult();

        //commit transaction
        HibernateUtil.commit(session);

        return userEntity;
    }

    /**
     * set user preference
     * @param userEntity
     * @return
     */
    public boolean setPreference(UserEntity userEntity){
        boolean isSuccess = false;
        Session session = HibernateUtil.getSession();
        //begin transaction
        HibernateUtil.begin(session);
        session.update(userEntity);

        //commit transaction
        HibernateUtil.commit(session);
        isSuccess = true;
        return isSuccess;
    }
    /**
     * register a user account
     * @param userEntity
     * @return
     */
    @Override
    public boolean regist(UserEntity userEntity) {
        if(null == userEntity){
            return false;
        }

        //weather exist this user
        boolean isExist = false;
        Session session = HibernateUtil.getSession();
        //begin transaction
        HibernateUtil.begin(session);
        String hql = "from UserEntity as u where u.userName=:name";
        Query query = session.createQuery(hql);
        query.setString("name", userEntity.getUserName());
        List<UserEntity> list =  query.list();
        if(null == list || 0 == list.size()){
            isExist = false;
        }
        else {
            isExist = true;
        }

        //register
        if(isExist){
            return false;
        }
        session.save(userEntity);

        //commit transaction
        HibernateUtil.commit(session);

        return true;
    }
}
