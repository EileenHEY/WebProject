package dao;

import entity.Userinfo;
import util.Dbtool;

import java.sql.ResultSet;
import java.sql.SQLException;

public class userinfoDao {
    public Userinfo getUserInfoByEmAndPwd(String email, String password){
        Dbtool dbtool=new Dbtool();
        String sql="select id,username,email,password,headimg,status from userinfo where status!=1 and email='"+email+"' and password='"+password+"'";
        System.out.println("通过邮箱密码查询用户sql语句："+sql);
        ResultSet rSet=dbtool.executeQuery(sql);
        Userinfo userinfo=null;
        try {
            if (rSet==null) {
                System.out.println("查找失败");
            }else {
                while (rSet.next()) {
                    userinfo=new Userinfo(rSet.getInt("id"),rSet.getString("username"),rSet.getString("username"),rSet.getString("password"),rSet.getString("headimg"),rSet.getInt("status"));
                    System.out.println("查找成功");
                    userinfo.toString();
                }
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return userinfo;
    }
}
