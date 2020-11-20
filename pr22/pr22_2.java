package pr22;

import java.util.*;
class StudentNotFoundException extends Exception {
    public StudentNotFoundException(String student) {
        super(student + " не найден!");
    }
}
class EmptyStringException extends Exception {
    public EmptyStringException() {
        super("Информация студента отсутствует");
    }

}
class Student implements Comparable<Student> {
    final private String name;
    final private String surname;
    private Double mark;

    public Student(String name, String surname, Double mark)
            throws EmptyStringException {
        if (name.isEmpty() || surname.isEmpty())
            throw new EmptyStringException();
        this.name = name;
        this.surname = surname;
        this.mark = mark;
    }

    public Double getMark() {
        return mark;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setMark(Double mark) {
        this.mark = mark;
    }

    @Override
    public int compareTo(Student secondStudent) {
        return mark.compareTo(secondStudent.getMark());
    }

    @Override
    public String toString() {
        return "Студент: " +
                  name + ' ' +
                 surname + ' ' +
                "\t" + "Оценка: " + mark ;
    }
}
class ClassDriver implements UI {
    private List<Student> students;

    public ClassDriver() {
        this.students = new ArrayList<>();
    }

    @Override
    public List<Student> students() {
        return students;
    }

    @Override
    public void addStudent(Student student) {
        students.add(student);
    }

    @Override
    public void addStudents(List<Student> students) {
        this.students.addAll(students);
    }

    @Override
    public void sortByMark() {
        students.sort(Comparator.comparing(Student::getMark));
        Collections.reverse(students);
    }

    @Override
    public Student getStudent(
            String name,
            String surname)
            throws StudentNotFoundException {
        return students.stream().filter(st -> st.getName().equals(name) && st.getSurname().equals(surname))
                .findFirst()
                .orElseThrow(() ->
                        new StudentNotFoundException(
                                String.format("%s %s", name, surname)));
    }

    @Override
    public String toString() {
        StringBuilder listOfStudents = new StringBuilder("");

        for (Student student : students) {
            listOfStudents.append(student.toString()).append("\n");
        }

        return listOfStudents.toString();
    }
}

class LabClass {
    final private UI classUI;

    public LabClass() {
        this.classUI = new ClassDriver();
    }

    public UI getClassUi() {
        return classUI;
    }

    @Override
    public String toString() {
        return classUI.toString();
    }
}

public class pr22_2 {
    public static void main(String[] args)
            throws EmptyStringException, StudentNotFoundException {
        UI classUI = new LabClass().getClassUi();
        System.out.println("--------------------Список студентов--------------------");
        classUI.addStudent(new Student("Владимир", "Пупкин",  5.0));
        classUI.addStudent(new Student("Иван", "Иванов",  3.5));
        classUI.addStudent(new Student("Сергей", "Петров",  4.2));
        classUI.addStudent(new Student("Антон", "Сидоров",  3.3));

        ArrayList<Student> testStudents= new ArrayList<Student>();
        testStudents.add(new Student("Игорь", "Ломоносов", 4.8));
        testStudents.add(new Student("Никита", "Назаров", 2.6));
        testStudents.add(new Student("Вадим", "Сергеев", 3.8));
        //testStudents.add(new Student("Михаил", "", 2.0));
        classUI.addStudents(testStudents);
        System.out.println(classUI);
        System.out.println("------------Список сортированных студентов по оценкам-------------");
        classUI.sortByMark();
        System.out.println(classUI);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя и фамилию для поиска студента: ");
        System.out.println(classUI.getStudent(scanner.next(), scanner.next()));
    }
}
