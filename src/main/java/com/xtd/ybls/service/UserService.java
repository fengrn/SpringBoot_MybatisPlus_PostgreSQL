package com.xtd.ybls.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.xtd.ybls.entity.Role;
import com.xtd.ybls.entity.UserPo;
import com.xtd.ybls.entity.UserRolePermissionVO;

import java.util.List;


/**
 * @author 冯瑞宁
 */
public interface UserService extends IService<UserPo> {

    /**
     * 插入一条用户信息
     * @param userPo
     * @return
     */
    int saveUser(UserPo userPo);
    /**
     * 通过用户名查询一条用户信息
     * @param name
     * @return
     */
    UserPo getUserByname(String name);
    /**
     * 获取所有用户信息
     * @return
     */
    List<UserPo> listUserPo();

    /**
     * 修改用户信息
     * @param userPo
     * @return
     */
    int updateUserById(UserPo userPo);

    /**
     * 修改用户密码
     * @param name
     * @param password
     * @param newPassword
     * @return
     */
    int updatePasswordByname(String name, String password, String newPassword);

    /**
     * 查询用户权限
     * @return
     */
    UserRolePermissionVO queryUserRolePermissionAll();
}
