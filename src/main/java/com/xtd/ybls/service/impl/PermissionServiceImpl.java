package com.xtd.ybls.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xtd.ybls.dao.PermissionMapper;
import com.xtd.ybls.entity.Permission;
import com.xtd.ybls.service.PermissionService;
import org.springframework.stereotype.Service;

/**
 * @author 冯瑞宁
 */
@Service
@DS("dateService")
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {

}
