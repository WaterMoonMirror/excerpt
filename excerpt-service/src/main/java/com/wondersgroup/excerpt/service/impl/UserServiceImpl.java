package com.wondersgroup.excerpt.service.impl;

import cn.hutool.core.util.StrUtil;
import com.wondersgroup.excerpt.mapper.UsersMapper;
import com.wondersgroup.excerpt.pojo.Users;
import com.wondersgroup.excerpt.service.UserService;
import org.apache.catalina.mbeans.UserMBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * @author: lizhu@wondesgroup.com
 * @date: 2020/12/2 15:24
 * @description:
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UsersMapper usersMapper;
    /**
     * 判断用户是否存在
     *
     * @param username 用户名
     * @return 是否存在
     */
    @Override
    public boolean queryUsernameIsExist(String username) {
        Example example=new Example(Users.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username",username);
        Users result = usersMapper.selectOneByExample(example);
        return result != null;
    }

    /**
     * 添加一个用户
     *
     * @param users
     * @return 添加后的用户信息
     */
    @Override
    public Users createUser(Users users) {
        int result = usersMapper.insert(users);
        users.setId(StrUtil.toString(result));
        return users;
    }

    /**
     * 用户登录获取用户信息
     *
     * @param username
     * @param password
     * @return 查询的用户信息
     */
    @Override
    public Users queryForLogin(String username, String password) {
        Example userExample = new Example(Users.class);
        Example.Criteria userCriteria = userExample.createCriteria();

        userCriteria.andEqualTo("username", username);
        userCriteria.andEqualTo("password", password);

        return usersMapper.selectOneByExample(userExample);
    }
}
