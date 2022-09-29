package com.xtd.ybls.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.*;

import java.sql.Timestamp;

/**
 * @author 冯瑞宁
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@TableName("permission")
public class Permission {
	@TableId(value = "id",type = IdType.AUTO)
	private Integer id;
	private String name;
	private String path;
	/**
	 * 新增的时候填充数据
	 */
	@TableField(fill = FieldFill.INSERT)
	private Timestamp createTime;
	/**
	 * 新增或修改的时候填充数据
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Timestamp updateTime;
}
