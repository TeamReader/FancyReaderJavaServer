package org.yyz.databaseBasic;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.SessionFactoryImpl;
import org.hibernate.proxy.HibernateProxy;

/**
 * Created by yyz on 2016/7/6.
 */
public class HibernateUtil {
    private static SessionFactory sessionFactory;
    static{
        try{
            //读取hibernate.cfg.xml文件
            Configuration cfg=new Configuration().configure();

            //建立SessionFactory
            sessionFactory=cfg.buildSessionFactory();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 开启session
     * @return
     */
    public static Session getSession(){
        Session session = sessionFactory.openSession();

        return session;
    }

    /**
     * 关闭session事务
     * @param session
     */
    public static void closeSession(Session session){
        if(session!=null){
            if(session.isOpen()){
                session.close();
            }
        }
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
