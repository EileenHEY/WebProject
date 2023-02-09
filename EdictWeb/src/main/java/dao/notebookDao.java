package dao;

import entity.Notebook;
import util.Dbtool;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class notebookDao {
    public ArrayList<Notebook> getNotebookByAuthorId(int authorid){
        Dbtool dbtool=new Dbtool();
        String sql="select id,name,author_id,wordscount,updatetime from notebook";
        System.out.println("通过用户id查询笔记集sql语句："+sql);
        ResultSet rSet=dbtool.executeQuery(sql);
        ArrayList<Notebook> notebooks=new ArrayList<Notebook>();

        try {
            if (rSet==null) {
                System.out.println("查找失败");
            }else {
                while (rSet.next()) {
                    Notebook notebook=new Notebook();
                    notebook.setId(rSet.getInt("id"));
                    notebook.setName(rSet.getString("name"));
                    notebook.setAuthor_id(rSet.getInt("author_id"));
                    notebook.setWordscount(rSet.getInt("wordscount"));

                    Long updatetime=rSet.getLong("updatetime");
                    notebook.setUpdatetime(updatetime);
                    SimpleDateFormat formatter = new SimpleDateFormat("yy/MM");
                    Date date = new Date(updatetime);
                    notebook.setUpdate(formatter.format(date));

                    System.out.println("查找成功");
                    notebook.toString();
                    notebooks.add(notebook);
                }
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return notebooks;
    }

    //添加卡片集
    public int addNotebook(int authorId,String bookname){
        Dbtool dbtool=new Dbtool();
        Long time=new Date().getTime();
        String sql="insert into notebook(name,author_id,wordscount,updatetime ) values('"+bookname+"',"+authorId+",0,"+time+")";
        System.out.println(sql);
        System.out.println("通过用户id查询笔记集sql语句："+sql);
        ResultSet rSet=dbtool.executeQuery(sql);
        return dbtool.executeUpdateReturnLAST_INSERT_ID(sql);
    }
}
