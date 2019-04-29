package com.ren.springbill.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: wangren.
 * @Description: TODO()
 * @Date:Created in 2019/4/29 14:02.
 * @Modified By:
 */
public class LoginHanlderInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("loginUser");
        if (user != null) {
            return true;
        }
        request.setAttribute("msg","没有权限请先登录！");
        request.getRequestDispatcher("/index.html").forward(request,response);
        return false;
    }
}
