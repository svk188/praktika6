package pr22;
import java.util.Scanner;

class UnacceptableInnException extends Exception {
    public UnacceptableInnException() {
        super("ָֽֽ סמסעמטע טח 12 צטפנ");
    }
}

class Person {
    final private String inn;
    final private String name;
    final private String secondName;
    final private String surname;


    public Person(String surname, String name, String secondName, String inn)
            throws UnacceptableInnException {
        if (inn.length() != 12)
            throw new UnacceptableInnException();
        this.inn = inn;
        this.name = name;
        this.secondName = secondName;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Customer" + "\nSurname:'" + surname + '\'' + "\nName:'" + name +
                '\'' + "\nSecond Name:'" + secondName + '\'' + "\nINN:'" + inn + '\'';
    }
}
public class pr22 {
    public static void main(String[] args)
            throws UnacceptableInnException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("To place an order, enter your data");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Surname: ");
        String surname = scanner.nextLine();
        System.out.print("Second Name: ");
        String secondname = scanner.nextLine();
        System.out.print("INN: ");
        String inn = scanner.nextLine();
        Person cust1 = new Person(surname, name,secondname, inn);
        System.out.println(cust1);
    }
}
