package com.m77can.controller;

import com.m77can.entity.User;
import com.m77can.service.UserService;
import com.m77can.util.JsonUtil;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Singleton
public class UserServlet extends HttpServlet {

    @Inject
    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("处理GET请求");
        String userId = httpServletRequest.getParameter("userId");
        //获取输入
        PrintWriter out = response.getWriter();
        //指定输出文件类型和编码
        response.setContentType("application/json");
        //开始输出

        User user = userService.findById(userId);

        out.println(JsonUtil.toString(user));
    }
}