package com.app;

import com.google.gson.Gson;
import dao.userinfoDao;
import entity.ResultVO;
import entity.Userinfo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.UUID;

@WebServlet(name = "ELogin", value = "/login")
public class ELogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Gson gson=new Gson();
        String email=request.getParameter("email");
        String password=request.getParameter("password");
        userinfoDao userdao=new userinfoDao();
        Userinfo user=userdao.getUserInfoByEmAndPwd(email,password);
        String info;
        ResultVO resultVO;
        if (user!=null){
            String token= UUID.randomUUID()+"";
            resultVO=new ResultVO(10000,token,user);
        }else {
            resultVO=new ResultVO(20000,"error",null);
        }
        info=gson.toJson(resultVO);
        response.setHeader("content-type","text/html;charset=utf-8");
        response.getWriter().write(info);
    }
}
