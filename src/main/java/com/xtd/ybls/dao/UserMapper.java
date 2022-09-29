package com.xtd.ybls.dao;


import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xtd.ybls.entity.Permission;
import com.xtd.ybls.entity.UserPo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author 冯瑞宁
 */
@Mapper
@Component
public interface UserMapper extends BaseMapper<UserPo> {

	/**
	 * 查询用户
	 * @param name
	 * @return
	 */
	UserPo queryUserByName(String name);

	/**
	 * 查询用户所拥有的权限
	 * @param username
	 * @return
	 */
	Set<Permission> listPermissions(String username);
}
