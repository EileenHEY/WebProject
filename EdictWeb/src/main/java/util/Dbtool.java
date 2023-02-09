package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Dbtool {

    // mysql5.x
    // final static String classforname = "com.mysql.jdbc.Driver";
    // final static String url =
    // "jdbc:mysql://localhost/demo?useSSL=false&user=root&password=root";

    // mysql 8.x
    final static String classforname = "com.mysql.cj.jdbc.Driver";
    final static String url = "jdbc:mysql://localhost/edict?useSSL=false&serverTimezone=Hongkong&useUnicode=true&characterEncoding=utf-8&user=root&password=root";

    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    /***
     *
     *
     * @param sql
     * @return
     */
    public int executeUpdate(String sql) {

        int rtv = 0;
        try {
            //注册驱动
            Class.forName(classforname);
            conn = DriverManager.getConnection(url);// 获取连接
            stmt = conn.createStatement();// 执行sql对象
            rtv = stmt.executeUpdate(sql);// 执行sql语句

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rtv;
    }

    /***
     * author:denny
     *
     * @param sql
     * @return
     */
    public ResultSet executeQuery(String sql) {
        try {
            Class.forName(classforname);
            conn = DriverManager.getConnection(url);
            stmt = null;
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    /***
     * author:denny
     *
     * @param sql
     * @return 返回自增id信息
     */
    public int executeUpdateReturnLAST_INSERT_ID(String sql) {
        int rtv = 0;// 数据库受影响的行数
        try {
            Class.forName(classforname);
            conn = DriverManager.getConnection(url);
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            // 增加记录后，立刻查询自增id
            ResultSet rs = stmt.executeQuery("SELECT LAST_INSERT_ID()as num");
            rs.next();
            rtv = rs.getInt("num");
            // System.out.println("刚刚增加的id=" + rtv);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rtv;
    }

    public void close() {
        if (rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}