package com.sl.controller;


import com.sl.entity.RestModel;
import com.sl.entity.User;
import com.sl.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ShuLu
 */
@RestController
public class LoginController {
    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 验证登录
     *
     * @return url
     */
    @RequestMapping("/login")
    public RestModel<String> login(HttpServletRequest request) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if (user != null && user.getId() != null) {
            return new RestModel<>(200, "登陆成功", null);
        }
        String msg = "请先登陆";
        String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
        if (exceptionClassName != null) {
            if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
                msg = "账号不存在";
            } else if (IncorrectCredentialsException.class.getName().equals(
                    exceptionClassName) || AuthenticationException.class.getName().equals(exceptionClassName)) {
                msg = "用户名/密码错误";
            } else {
                throw new RuntimeException(exceptionClassName);
            }
        }
        return new RestModel<>(401, msg, null);
    }

    @PostMapping("/overpower")
    public RestModel<String> overpower() {
        return new RestModel<>(402, "越权访问", null);
    }

    @PostMapping("/register")
    public RestModel<String> register(String name, String password) {
        userService.saveUser(name, password);
        return new RestModel<>(200,"注册成功",null);
    }
}
