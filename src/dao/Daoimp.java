package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Daoimp extends DataBase implements DaoInterface{


    @Override
    public boolean insertinto(Student student) {
        Connection connection = getConnection();
        PreparedStatement statement= null;
        Object []o = new Object[10];
        int j=0;
        try {
            statement = connection.prepareStatement("INSERT INTO student (studentNO,loginPwd,studentName,sex,gradeId,phone,address,bornDate,email,identityCard,age)\n" +
                    "VALUES(null,?,?,?,?,?,?,?,?,?,?)");
            //o[0]=student.getStudentNo();
            o[0]=student.getLoginPwd();
            o[1]=student.getStudentName();
            o[2]= student.getSex();
            o[3]= student.getGradeId();
            o[4]= student.getPhone();
            o[5]= student.getAddress();
            o[6]=student.getDatetime();
            o[7]=student.getEmail();
            o[8]=student.getIdentityCard();
            o[9]=student.getAge();

            for (int i=0;i<o.length;i++){
                statement.setObject((i+1),o[i]);
            }
            j=statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            close(statement,connection);
        }
        if (j>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public ArrayList<Student> select() {
        Connection connection=null;
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        ArrayList <Student> students=new ArrayList<>();
        try {
             connection = getConnection();
             statement = connection.prepareStatement("SELECT studentNO,loginPwd,studentName,sex,gradeId,phone,address,bornDate,email,identityCard,age FROM student");
             resultSet = statement.executeQuery();
            while (resultSet.next()){
                Student student=new Student();
                //System.out.println(resultSet.getInt("studentNO")+resultSet.getString("studentName"));
                student.setStudentNo(resultSet.getInt("studentNO"));
                student.setStudentName(resultSet.getString("studentName"));
                student.setSex(resultSet.getString("sex"));
                students.add(student);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
         close(resultSet,statement,connection);
        }
       return students;
    }
}
