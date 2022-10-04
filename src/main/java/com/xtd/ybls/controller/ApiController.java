package com.xtd.ybls.controller;

import com.xtd.ybls.result.ResultBody;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 测试knife4jConfig
 * @author frn
 * @date 2022/9/29 16:00
 */


@Api(tags = "api接口测试")
@RestController
@RequestMapping("/api")
public class ApiController {
    @ApiOperation(value = "查询所有用户")
    @GetMapping("/users")
    public ResultBody list() {
        Map<String, Object> map = new HashMap<>();
        map.put("姓名", "feng");
        map.put("性别", "男");
        map.put("学号",null);
        map.put("时间",new Date());
        return ResultBody.success(map);
    }

    @ApiOperation(value = "添加用户")
    @PostMapping("/users")
    public String add() {
        return "2";
    }

    @ApiOperation(value = "编辑用户")
    @PutMapping("/users")
    public String update() {
        return "3";
    }

    @ApiOperation(value = "删除用户")
    @DeleteMapping("/users")
    public String delete() {
        return "4";
    }
}