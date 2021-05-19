package dao;


import java.util.ArrayList;

/**
 * @author zb
 */
public interface DaoInterface {
    boolean insertinto(Student student);

    ArrayList<Student> select();
}
