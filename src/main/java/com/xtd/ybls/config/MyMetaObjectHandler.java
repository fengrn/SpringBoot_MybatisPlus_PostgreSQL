package com.xtd.ybls.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * @author 冯瑞宁
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("createTime",new Timestamp(System.currentTimeMillis()),metaObject);
        this.setFieldValByName("updateTime",new Timestamp(System.currentTimeMillis()),metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime",new Timestamp(System.currentTimeMillis()),metaObject);
    }
}
