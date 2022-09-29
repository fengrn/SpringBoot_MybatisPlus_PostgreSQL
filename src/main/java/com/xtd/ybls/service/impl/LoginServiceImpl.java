package com.xtd.ybls.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.xtd.ybls.dao.UserMapper;
import com.xtd.ybls.entity.Permission;
import com.xtd.ybls.entity.UserPo;
import com.xtd.ybls.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import java.util.Set;


/**
 * @author 冯瑞宁
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    private UserMapper userMapper;

    @Override
    public UserPo login(String name) {
        UserPo user = userMapper.queryUserByName(name);
        return user;
    }

    @Override
    public Set<Permission> listPermissions(String username) {
        return userMapper.listPermissions(username);
    }
}
