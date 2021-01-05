package com.m77can.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/banners")
public class BannerServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse response) throws ServletException, IOException {
        //获取输入
        PrintWriter out = response.getWriter();
        //指定输出文件类型和编码
        response.setContentType("application/json");
        //开始输出
        out.println("banner");
    }
}