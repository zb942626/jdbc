package test;

import java.sql.*;

public class Test1 {
    public static void main(String[] args) {
        Connection connection=null;
        Statement statement =null;
        ResultSet resultSet =null;
        //String s= "王五";
        try {
            Class.forName("com.mysql.jdbc.Driver");
             connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdb","root","123456");
             statement =connection.createStatement();
             resultSet=statement.executeQuery("SELECT u.customerID,u.customerName FROM userinfo u ");
             while (resultSet.next()){
                 System.out.println(resultSet.getInt("customerID")+","+resultSet.getString("customerName"));
             }
            resultSet.last();
            System.out.println(resultSet.getRow());

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        finally {

            try {
                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }


        }
    }
}
