package dao;

import javax.swing.*;
import java.util.ArrayList;

public interface DaoInterface {
    boolean insertinto(Student student);
    ArrayList<Student> select();
}
