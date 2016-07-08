package org.yyz.dao;

import org.yyz.pojo.UserEntity;

/**
 * Created by yyz on 2016/7/6.
 */
public interface UserDAO {
    public boolean checkUser(UserEntity user);
    public UserEntity getPreference(String userName);
    public boolean regist(UserEntity userEntity);
}
