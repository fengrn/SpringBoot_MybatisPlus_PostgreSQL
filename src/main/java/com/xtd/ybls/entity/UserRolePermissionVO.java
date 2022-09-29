package com.xtd.ybls.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author 冯瑞宁
 */
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRolePermissionVO {
    private String userName;
    private String userCreateTime;
    private String userUpdateTime;
    private String userStation;
    private String roleName;
    private String permissionName;
    private String permissionPath;
}
