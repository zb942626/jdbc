package test;

import dao.DaoInterface;
import dao.Daoimp;
import dao.Student;

import java.util.ArrayList;

public class DaoTest1 {
    public static void main(String[] args) {
        DaoInterface daoInterface=new Daoimp();
        ArrayList<Student> select = daoInterface.select();
        for (Student stu:select) {
            System.out.println(stu.getStudentNo()+" "+stu.getStudentName()+" "+stu.getSex());

        }
    }
}
