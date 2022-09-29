package com.xtd.ybls.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xtd.ybls.dao.RoleMapper;
import com.xtd.ybls.dao.UserMapper;
import com.xtd.ybls.entity.Role;
import com.xtd.ybls.entity.UserPo;
import com.xtd.ybls.entity.UserRolePermissionVO;
import com.xtd.ybls.service.UserService;
import com.xtd.ybls.util.Encrypt;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.Wrapper;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;


/**
 * @author 冯瑞宁
 */
@Service
@DS(value = "dateService")
public class UserServiceImpl extends ServiceImpl<UserMapper, UserPo>  implements UserService{
    @Resource
    private UserMapper userMapper;
    @Resource
    private RoleMapper roleMapper;
    @Override
    public int saveUser(UserPo userPo) {
        //将密码进行加密
        String password = userPo.getPassword();
        String name = userPo.getName();
        String encryptionPassword = Encrypt.md5(password, name);
        userPo.setPassword(encryptionPassword);
        return userMapper.insert(userPo);
    }
    @Override
    public UserPo getUserByname(String name) {
        UserPo userPo = userMapper.selectOne((Wrapper<UserPo>) new QueryWrapper().eq("name",name));
        userPo.setPassword(null);
        return  userPo;
    }
    @Override
    public List<UserPo> listUserPo() {
        List<UserPo> listUser = userMapper.selectList(new QueryWrapper());
        for (UserPo userPo : listUser) {
            userPo.setPassword(null);
        }
        return listUser;
    }

    @Override
    public int updateUserById(UserPo userPo) {
        //将密码置为null避免执行修改接口时将密码修改掉
        userPo.setPassword(null);
        return userMapper.updateById(userPo);
    }

    @Override
    public int updatePasswordByname(String name, String password, String newPassword) {
        int i = 0;
        //获取用户信息
        UserPo userPo = userMapper.selectOne((Wrapper<UserPo>) new QueryWrapper().eq("name",name));
        //将用户提供的旧密码加密
        String encryptionPassword = Encrypt.md5(password, name);
        //与数据库进行比对
        if (userPo.getPassword().equals(encryptionPassword))
        {
            //将新密码加密
            String newEncryptionPassword = Encrypt.md5(newPassword, name);
            userPo.setPassword(newEncryptionPassword);
            i = userMapper.updateById(userPo);
        }
        return i;
    }

    @Override
    public UserRolePermissionVO queryUserRolePermissionAll() {

        return null;
    }

}
