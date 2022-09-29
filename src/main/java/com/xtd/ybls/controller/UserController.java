package com.xtd.ybls.controller;

import com.xtd.ybls.entity.*;
import com.xtd.ybls.result.ResultBody;
import com.xtd.ybls.service.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
/**
 * @author 冯瑞宁
 */
@RestController
@RequestMapping("user/api/v1/")
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private RoleService roleService;
    @Resource
    private PermissionService permissionService;
    @Resource
    private UserRoleService userRoleService;
    @Resource
    private RolePermissionService rolePermissionService;


   /**
    *添加新用户
    *@author: frn
    *@createTime: 2021/11/29 11:16
    *@param:
    *@return:
    */
    @PostMapping("addUser")
    public ResultBody addUser(@RequestBody UserPo userPo){
        return ResultBody.success(userService.saveUser(userPo));
    }
    /**
     *@Description: 通过用户名查询信息
     *@author: frn
     *@createTime: 2021/11/29 12:52
     *@param:
     *@return:
     */
    @PostMapping("queryUserByName")
    public ResultBody qyeryUserByname(@RequestParam String name){
        UserPo userByname = userService.getUserByname(name);


        return ResultBody.success(

        );
    }
    /**
     *@Description: 查询所有用户信息
     *@author: frn
     *@createTime: 2021/11/29 16:43
     *@param:
     *@return:
     */
    @PostMapping("qyeryUserAll")
    public ResultBody qyeryUserAll(){
        return ResultBody.success(
                userService.listUserPo()
        );
    }
    /**
     *@Description: 修改用户信息
     *@author: frn
     *@createTime: 2021/11/29 16:58
     *@param:
     *@return:
     */
    @PostMapping("updateUserById")
    public ResultBody updateUserById(@RequestBody UserPo userPo){
        return ResultBody.success(
                userService.updateUserById(userPo)
        );
    }
    /**
     *@Description: 修改用户密码
     *@author: frn
     *@createTime: 2021/11/29 16:58
     *@param:
     *@return:
     */
    @PostMapping("updatePasswordByname")
    public ResultBody updatePasswordByname(@RequestParam String name,String password,String newPassword){
        return ResultBody.success(
                userService.updatePasswordByname(name,password,newPassword)
        );
    }
    /**
     *@Description: 删除用户
     *@author: frn
     *@createTime: 2021/11/29 16:58
     *@param:
     *@return:
     */
    @PostMapping("deleteUserById")
    public ResultBody deleteUserById(@RequestParam int id){
        boolean b = userService.removeById(id);
        return ResultBody.success(b);
    }
    //角色的增删改查
    /**
     *@Description:添加角色
     *@author: frn
     *@createTime: 2021/11/30 15:55
     *@param:
     *@return:
     */
    @PostMapping("addRole")
    public ResultBody addRole(@RequestBody Role role){
        return ResultBody.success(roleService.save(role));
    }
    /**
     *@Description:删除角色
     *@author: frn
     *@createTime: 2021/11/30 15:55
     *@param:
     *@return:
     */
    @PostMapping("deleteRoleById")
    public ResultBody deleteRoleById(@RequestParam int id){
        return ResultBody.success(roleService.removeById(id));
    }
    /**
     *@Description:修改角色
     *@author: frn
     *@createTime: 2021/11/30 9:58
     *@param:
     *@return:
     */
    @PostMapping("updateRoleById")
    public ResultBody updateRoleById(@RequestBody Role role){
        return ResultBody.success( roleService.updateById(role));
    }
    /**
     *@Description:查询角色（单）
     *@author: frn
     *@createTime: 2021/11/30 16:00
     *@param:
     *@return:
     */
    @PostMapping("queryRoleById")
    public ResultBody queryRoleById(@RequestParam int id){
        return ResultBody.success( roleService.getById(id));
    }
    /**
     *@Description:查询角色（多）
     *@author: frn
     *@createTime: 2021/11/30 16:00
     *@param:
     *@return:
     */
    @PostMapping("queryRoleAll")
    public ResultBody queryRoleAll(){
        return ResultBody.success( roleService.list());
    }
    //权限的增删改查
    /**
     *@Description:添加权限
     *@author: frn
     *@createTime: 2021/11/30 15:55
     *@param:
     *@return:
     */
        @PostMapping("addPermission")
    public ResultBody addPermission(@RequestBody Permission permission){
        return ResultBody.success(permissionService.save(permission));
    }
    /**
     *@Description:删除权限
     *@author: frn
     *@createTime: 2021/11/30 15:55
     *@param:
     *@return:
     */
        @PostMapping("deletePermissionById")
    public ResultBody deletePermissionById(@RequestParam int id){
        return ResultBody.success(permissionService.removeById(id));
    }
    /**
     *@Description:修改权限
     *@author: frn
     *@createTime: 2021/11/30 9:58
     *@param:
     *@return:
     */
    @PostMapping("updatePermissionById")
    public ResultBody updatePermissionById(@RequestBody Permission permission){
        return ResultBody.success( permissionService.updateById(permission));
    }
    /**
     *@Description:查询权限（单）
     *@author: frn
     *@createTime: 2021/11/30 16:00
     *@param:
     *@return:
     */
    @PostMapping("queryPermissionById")
    public ResultBody queryPermissionById(@RequestParam int id){
        return ResultBody.success( permissionService.getById(id));
    }
    /**
     *@Description:查询权限（多）
     *@author: frn
     *@createTime: 2021/11/30 16:00
     *@param:
     *@return:
     */
    @PostMapping("queryPermissionAll")
    public ResultBody queryPermissionAll(){
        return ResultBody.success( permissionService.list());
    }
    /**
     *@Description:给用户绑定角色
     *@author: frn
     *@createTime: 2021/11/30 16:47
     *@param:
     *@return:
     */
    @PostMapping("userBindRole")
    public ResultBody userBindRole(@RequestBody UserRole userRole){
        return ResultBody.success(userRoleService.save(userRole));
    }
    /**
     *@Description:删除用户绑定角色
     *@author: frn
     *@createTime: 2021/11/30 16:47
     *@param:
     *@return:
     */
    @PostMapping("deleteUserBindRole")
    public ResultBody deleteUserBindRole(@RequestParam int id){
        return ResultBody.success(userRoleService.removeById(id));
    }
    /**
     *@Description:角色绑定权限
     *@author: frn
     *@createTime: 2021/11/30 17:06
     *@param:
     *@return:
     */
    @PostMapping("/roleBindPermission")
    public ResultBody roleBindPermission(@RequestBody RolePermission rolePermission){
        return ResultBody.success(rolePermissionService.save(rolePermission));
    }
//    /**
//     *@Description:查询角色绑定权限（单）
//     *@author:frn
//     *@createTime:2021/11/30 17:06
//     *@param:
//     *@return:
//     */
//    @PostMapping("roleBindPermission")
//    public ResultBody roleBindPermission(@RequestBody RolePermission rolePermission){
//        //查询账号
//        return ResultBody.success(rolePermissionService.save(rolePermission));
//    }
//    /**
//     *@Description:查询角色绑定权限（多）
//     *@author:frn
//     *@createTime:2021/11/30 17:06
//     *@param:
//     *@return:
//     */
//    @PostMapping("roleBindPermission")
//    public ResultBody roleBindPermission(@RequestBody RolePermission rolePermission){
//        return ResultBody.success(rolePermissionService.save(rolePermission));
//    }
    /**
     *@Description:删除角色绑定权限记录
     *@author: frn
     *@createTime: 2021/11/30 17:06
     *@param:
     *@return:
     */
    @PostMapping("deleteRoleBindPermission")
    public ResultBody deleteRoleBindPermission(@RequestParam int id){
        return ResultBody.success(rolePermissionService.removeById(id));
    }
    /**
     *@Description:查询用户绑定的角色以及所拥有的权限
     *@author: frn
     *@createTime: 2021/11/30 17:17
     *@param:
     *@return:
     */
    @PostMapping("api/vi/queryUserRolePermission")
    public ResultBody queryUserRolePermissionAll(){
        userService.queryUserRolePermissionAll();
        return null;
    }



}
