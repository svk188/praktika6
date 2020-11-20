package pr22;

import java.util.List;

public interface UI {
    List<Student> students();
    void addStudent(Student student) throws EmptyStringException;
    void addStudents(List<Student> students);
    void sortByMark();
    Student getStudent(String name, String surname) throws StudentNotFoundException;
}
