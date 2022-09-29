package com.xtd.ybls.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xtd.ybls.dao.RoleMapper;
import com.xtd.ybls.entity.Role;
import com.xtd.ybls.service.RoleService;
import org.springframework.stereotype.Service;

/**
 * @author 冯瑞宁
 */
@Service
@DS("dateService")
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
}
