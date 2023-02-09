package com.app;

import com.google.gson.Gson;
import dao.notebookDao;
import entity.Notebook;
import entity.ResultVO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

@WebServlet(name = "DNotebook", value = "/mynotebook")
public class DNotebook extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int author_id=Integer.parseInt(request.getParameter("author_id")) ;
        notebookDao notebookDao=new notebookDao();
        Gson gson=new Gson();
        String info;
        ResultVO resultVO;
        ArrayList<Notebook> notebooks=notebookDao.getNotebookByAuthorId(author_id);
        if (notebooks.size()>0){
            resultVO=new ResultVO(10000,"success",notebooks);
        }else {
            resultVO=new ResultVO(20000,"error",null);
        }
        info=gson.toJson(resultVO);
        response.setHeader("content-type","text/html;charset=utf-8");
        response.getWriter().write(info);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
