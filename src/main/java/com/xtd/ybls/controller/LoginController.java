package com.xtd.ybls.controller;
import com.xtd.ybls.result.ResultBody;
import com.xtd.ybls.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.net.URLEncoder;

/**
 * @author frn
 */
@Api(tags = "首页模块")
@RestController
@RequestMapping("login")
public class LoginController {
    @Resource
    private LoginService loginService;

    @ApiImplicitParam(name = "name",value = "姓名",required = true)
    @ApiOperation(value = "向客人问好")
    @PostMapping("todo/login")
    public ResultBody todoLogin(@RequestParam String userName,String passWord) {
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(userName, passWord);
        try {
            System.out.println();
            SecurityUtils.getSubject().login(usernamePasswordToken);
            return ResultBody.login("200", URLEncoder.encode(userName, "UTF-8"), "用户登陆成功");
        } catch (Throwable e) {
            return ResultBody.login("500", e.getMessage(), "用户登陆失败");
        }

    }

}

