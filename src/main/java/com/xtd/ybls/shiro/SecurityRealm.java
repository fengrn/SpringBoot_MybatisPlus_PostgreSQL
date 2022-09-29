package com.xtd.ybls.shiro;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xtd.ybls.constant.UserNameType;
import com.xtd.ybls.entity.ActiveUser;
import com.xtd.ybls.entity.Permission;
import com.xtd.ybls.entity.UserPo;
import com.xtd.ybls.service.LoginService;
import com.xtd.ybls.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author 冯瑞宁
 */
public class SecurityRealm extends AuthorizingRealm {
    @Resource
    private LoginService loginService;
    
    @Lazy
    @Resource
    private UserService userService;

    /**
     * 认证方法测试
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String name = (String) token.getPrincipal();
        UserNameType.USERNMAE = name;
        // 数据库获取用户信息
        UserPo user = userService.getOne((Wrapper<UserPo>) new QueryWrapper().eq("name",name));
        if (user == null){
            throw new UnknownAccountException();
        }
        UserNameType.STATION = user.getStation();
        ActiveUser activeUser = new ActiveUser();
        activeUser.setId(user.getId());
        activeUser.setName(user.getName());
        activeUser.setPassword(user.getPassword());
        activeUser.setStation(user.getStation());
        // 如果能查询到，再由框架比对数据库中查询到的密码和页面提交的密码是否一致
        AuthenticationInfo info = new SimpleAuthenticationInfo(activeUser, user.getPassword(), "customRealm");
        SecurityUtils.getSubject().getSession().setTimeout(-1000L);
        return info;
    }

    /**
     * 授权方法
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("授权===================================================================================");
        //根据realm的名字去找对应的realm
        ActiveUser username = (ActiveUser)principals.fromRealm("customRealm").iterator().next();
        List<String> permissions = new ArrayList<String>();
        Set<Permission> module = loginService.listPermissions(username.getName());
        for (Permission permission : module) {
            permissions.add(permission.getPath());
        }
        //new一个授权信息
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

        //给授权信息设置权限集合
        simpleAuthorizationInfo.addStringPermissions(permissions);
        return simpleAuthorizationInfo;
    }

    public void clearCached() {
        PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
        super.clearCache(principals);

    }
}
