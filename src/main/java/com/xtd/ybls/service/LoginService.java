package com.xtd.ybls.service;

import com.xtd.ybls.entity.Permission;
import com.xtd.ybls.entity.UserPo;

import java.util.Set;

/**
 * @author 冯瑞宁
 */
public interface LoginService {
    /**
     * 验证用户名密码是否正确
     * @param name
     * @return
     */
    UserPo login(String name);

    /**
     * 查询用户所拥有的权限
     * @param username
     * @return
     */
    Set<Permission> listPermissions(String username);
}
