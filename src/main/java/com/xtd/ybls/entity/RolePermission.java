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
@TableName("role_permission_mapping")
public class RolePermission {
    @TableId(value = "id",type= IdType.AUTO)
    private int id;
    private int roleId;
    private int permissionId;
    /**
     * 新增的时候填充数据
     */
    @TableField(fill = FieldFill.INSERT)
    private Timestamp createTime;
}
