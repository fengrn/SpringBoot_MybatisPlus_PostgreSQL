package com.xtd.ybls.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xtd.ybls.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author 冯瑞宁
 */
@Mapper
@Component
public interface RoleMapper extends BaseMapper<Role> {
}
