package com.xtd.ybls.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Timestamp;

/**
 * @author 冯瑞宁
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@TableName("user_role_mapping")
public class UserRole {
    @TableId(value = "id",type = IdType.AUTO)
    private int id;
    private int userId;
    private int roleId;
    /**
     *新增的时候填充数据
     */
    @TableField(fill = FieldFill.INSERT)
    private Timestamp createTime;
}
