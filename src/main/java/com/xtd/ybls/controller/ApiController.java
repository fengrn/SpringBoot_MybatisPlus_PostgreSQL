package com.xtd.ybls.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

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
    public String list() {
        return "1";
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