import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Connection connection=null;
        Statement statement=null;
        Scanner input =new Scanner(System.in);
        int num=0;
        String phone =null;
        int i=0;
        try {
            System.out.println( "请输入学生编号");
            num=input.nextInt();
            System.out.println("请输入修改的手机号");
            phone =input.next();
            Class.forName("com.mysql.jdbc.Driver");
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/myschool","root","123456");
            statement=connection.createStatement();
            i= statement.executeUpdate("UPDATE student SET phone='"+phone+"' WHERE studentNo='"+num+"'");
            System.out.println(i);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (i>0){
                System.out.println("修改成功");
            }else{
                System.out.println("修改失败");
            }
            if (statement!=null){
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (connection!=null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

    }
}
