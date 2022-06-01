package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class test1 {
    private static String user = "root";
    private static String password = "nzzfl2";
    private static String url = "jdbc:mysql://localhost:3306/pett?userSSL=true&useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT&allowPublicKeyRetrieval=true";
    private static Connection con = null;
    private static PreparedStatement pst=null;
    private static ResultSet rs=null;
    public static void main(String[] args) {
        try
        {
            //加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //连接数据库
            con=DriverManager.getConnection(url, user, password);
            //插入
            StringBuilder sqlString=new StringBuilder("INSERT INTO pet(id,master,name,health,love,adoptTime) VALUES(");
            sqlString.append("'3',");
            sqlString.append("'003',");
            sqlString.append("'旺财',");
            sqlString.append(98+",");
            sqlString.append(88+",");
            sqlString.append("'2020-12-02 9:28:49')");
            pst=con.prepareStatement(sqlString.toString());
            
            //删除
            String delString="delete from pet where id='1'";
            pst=con.prepareStatement(delString);

            //修改
            String updString="update pet set name='进宝' where id='2'";
            pst=con.prepareStatement(updString);
            //pst.executeUpdate();
            //查询
            String selString="select * from pet where master='001'";
            pst=con.prepareStatement(selString);
            rs=pst.executeQuery();
            while(rs.next())
            {
                System.out.println(rs.getString("id"));
                System.out.println(rs.getString("master"));
                System.out.println(rs.getString("name"));
                System.out.println(rs.getString("health"));
                System.out.println(rs.getString("love"));
               
            }
            con.close();
        }
       catch (ClassNotFoundException | SQLException e)
       {
           e.printStackTrace();
       }
    }
}
