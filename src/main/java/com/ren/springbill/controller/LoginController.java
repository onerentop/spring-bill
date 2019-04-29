package com.ren.springbill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Author: wangren.
 * @Description: TODO()
 * @Date:Created in 2019/4/29 13:41.
 * @Modified By:
 */
@Controller
public class LoginController {

    @PostMapping("/login")
    public String login(HttpSession session, String username, String password, Map<String,Object> map) {
        if (!StringUtils.isEmpty(username) && "123".equals(password)) {
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        }
        map.put("msg", "用户名或密码错误");
        return "main/login";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("loginUser");
        session.invalidate();
        return "redirect:index.html";
    }
}
