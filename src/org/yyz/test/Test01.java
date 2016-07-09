package org.yyz.test;

import org.yyz.pojo.UserEntity;
import org.yyz.util.JsonUtil;

/**
 * Created by yyz on 2016/7/6.
 */
public class Test01 {
    public static void main(String[] args){
        UserEntity userEntity = JsonUtil.StringToEntity("{\"password\":\"123\",\"userName\":\"yyz\"}",UserEntity.class);

        System.out.println(userEntity.getUserName());
        System.out.println(userEntity.getBgApp());

    }
}
