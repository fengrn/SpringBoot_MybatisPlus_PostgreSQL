package com.xtd.ybls.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xtd.ybls.dao.RolePermissionMapper;
import com.xtd.ybls.entity.RolePermission;
import com.xtd.ybls.service.RolePermissionService;
import org.springframework.stereotype.Service;

/**
 * @author 冯瑞宁
 */
@Service
@DS("dateService")
public class RolePermissionServiceImpl extends ServiceImpl<RolePermissionMapper, RolePermission> implements RolePermissionService {
}
