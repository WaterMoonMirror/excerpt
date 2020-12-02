package com.wondersgroup.excerpt.service;

import com.wondersgroup.excerpt.pojo.Users;
import org.springframework.stereotype.Service;

/**
 * @author: lizhu@wondesgroup.com
 * @date: 2020/12/2 15:15
 * @description: 用户业务服务接口
 */
public interface UserService {
    /**
     * 判断用户是否存在
     * @param username
     * @return 是否存在
     */
    boolean queryUsernameIsExist(String username);

    /**
     * 添加一个用户
     * @param users
     * @return 添加后的用户信息
     */
    Users createUser(Users users);

    /**
     * 用户登录获取用户信息
     * @param username
     * @param password
     * @return 查询的用户信息
     */
    Users queryForLogin(String username,String password);
}
