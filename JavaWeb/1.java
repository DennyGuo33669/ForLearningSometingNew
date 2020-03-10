package com.gzw.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({ "/login" })
public class ServletDemoSJ extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if ("admin".equalsIgnoreCase(username) && "123456".equalsIgnoreCase(password)) {
            resp.getWriter().print("欢迎。。。");
        } else {
            resp.getWriter().print("用户名或密码错误。。。");
        }

    }

}
