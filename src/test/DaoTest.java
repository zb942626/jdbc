package test;

import dao.DaoInterface;
import dao.Daoimp;
import dao.Student;

import java.sql.Date;

public class DaoTest {
    public static void main(String[] args) {
        Student student=new Student();
        student.setAddress("sss");
        student.setAge(8);
        student.setDatetime(Student.strToDateLong("1998-08-09 00:00:00"));
        student.setEmail("192@qq.com");
        student.setGradeId(1);
        student.setLoginPwd("123456");
        student.setIdentityCard("32032221");
        student.setPhone("12331565");
        student.setSex("女");
        student.setStudentName("芒果");

        DaoInterface daoInterface=new Daoimp();
        boolean b = daoInterface.insertinto(student);
        if (b){
            System.out.println("添加成功");
        }else {
            System.out.println("添加失败");
        }
    }
}
