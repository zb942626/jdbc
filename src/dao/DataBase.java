package dao;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

/**
 * @author zhangmaomao
 */
public class DataBase {

    private static  String url;
    private static  String user;
    private static  String password;
    private  static String driver;
    static {

        try {
            /**
             * 获取配置文件的地址
             */
            Properties properties=new Properties();
            ClassLoader classLoader= DataBase.class.getClassLoader();
            URL res= classLoader.getResource("jdbc.properties");
            String path = res.getPath();

            properties.load(new FileReader(path));
            url=properties.getProperty("url");
            user=properties.getProperty("user");
            password=properties.getProperty("password");
            driver=properties.getProperty("driver");
            Class.forName(driver);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection()  {
        Connection connection=null;
        try {
             connection = DriverManager.getConnection(url,user,password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }



    public static void close(PreparedStatement pr, Connection co){
        try {
            if (pr!=null){
                pr.close();
            }

        } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        try {
            if (co!=null) {
                co.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    public static void close(ResultSet re , PreparedStatement pr, Connection co){
        try {
            if (re!=null) {
                re.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            if (pr!=null){
                pr.close();
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            if (co!=null) {
                co.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

}
