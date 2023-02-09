package dao;

import entity.Notecard;
import util.Dbtool;

import java.sql.ResultSet;
import java.sql.SQLException;

public class notecardDao {
    public Notecard getNotecardByBookId(int bookid){
        Dbtool dbtool=new Dbtool();
        String sql="select id,name,def,note,img,book_id,hit,author_id from notecard";
        System.out.println("通过bookid查询单词卡片sql："+sql);
        ResultSet rSet=dbtool.executeQuery(sql);
        Notecard notecard=new Notecard();
        try {
            if (rSet==null) {
                System.out.println("查找失败");
            }else {
                while (rSet.next()) {
                    notecard.setId(rSet.getInt("id"));
                    notecard.setName(rSet.getString("name"));
                    notecard.setDef(rSet.getString("def"));
                    notecard.setImg(rSet.getString("img"));
                    notecard.setBook_id(rSet.getInt("book_id"));
                    notecard.setHit(rSet.getInt("hit"));
                    notecard.setAuthor_id(rSet.getInt("author_id"));
                    System.out.println("查找成功");
                    notecard.toString();
                }
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return notecard;
    }
}
