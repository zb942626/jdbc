package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) throws SQLException {
        Connection connection=null;
        Statement statement=null;
        Scanner input =new Scanner(System.in);

        int i=0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/myschool","root","123456");
            statement=connection.createStatement();
            i= statement.executeUpdate("" +
                    "INSERT INTO student (studentNo,loginPwd,studentName,sex,bornDate)" +
                    "VALUES(null ,'123456','小艾','母','2016-3-4 00:00:00')," +
                    "(null ,'123456','小艾','母','2016-3-4 00:00:00')");
            System.out.println(i);
            if (i>0){
                System.out.println("添加成功");
            }else{
                System.out.println("添加失败");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            if (statement!=null){
                statement.close();
            }
            if (connection!=null) {
                connection.close();
            }
        }
    }
}
