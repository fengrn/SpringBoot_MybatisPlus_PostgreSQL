package com.xtd.ybls.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xtd.ybls.dao.UserRoleMapper;
import com.xtd.ybls.entity.UserRole;
import com.xtd.ybls.service.UserRoleService;
import org.springframework.stereotype.Service;

/**
 * @author 冯瑞宁
 */
@Service
@DS("dateService")
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {
}
