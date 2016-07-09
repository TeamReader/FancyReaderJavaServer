package org.yyz.test;

import org.yyz.pojo.UserEntity;
import org.yyz.util.JsonUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yyz on 2016/7/7.
 */
public class TestJson {
    public static void main(String[] args){
        List<UserEntity> list = new ArrayList<>();
        for(int i=0; i < 10; i++){
            UserEntity userEntity = new UserEntity();
            userEntity.setUserName("name:"+i);
            userEntity.setPassword("password:"+i);
            list.add(userEntity);
        }
       System.out.println(JsonUtil.EntityToString(list));


    }
}
