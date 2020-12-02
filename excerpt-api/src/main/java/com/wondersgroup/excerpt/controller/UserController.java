package com.wondersgroup.excerpt.controller;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import com.wondersgroup.common.utils.JSONResult;
import com.wondersgroup.common.utils.MD5Utils;
import com.wondersgroup.excerpt.mapper.UsersMapper;
import com.wondersgroup.excerpt.pojo.Users;
import com.wondersgroup.excerpt.service.UserService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
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
    @Autowired
    private UserService userService;

    @GetMapping("query")
    public JSONResult query(){
        return JSONResult.ok(usersMapper.selectAll());
    }

    @GetMapping("login")
    @SneakyThrows
    public JSONResult login(String username,String password){
        if (StrUtil.isBlank(username)||StrUtil.isBlank(password)){
            JSONResult.errorMsg("用户名或密码为空！");
        }

        String psdMd5 = MD5Utils.getMD5Str(password);
        return JSONResult.ok(userService.queryForLogin(username, psdMd5));
    }
    @GetMapping("queryUsernameIsExist")
    public JSONResult queryUsernameIsExist(String username){
        boolean isExist = userService.queryUsernameIsExist(username);
        return JSONResult.ok(isExist);
    }
}
