package com.wondersgroup.excerpt.controller;

import com.wondersgroup.excerpt.mapper.UsersMapper;
import com.wondersgroup.excerpt.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: lizhu@wondesgroup.com
 * @date: 2020/12/2 14:21
 * @description:
 */
@RestController
public class UserController {
    @Autowired
    private UsersMapper usersMapper;

    @GetMapping("query")
    public List<Users> query(){
        return usersMapper.selectAll();
    }
}
