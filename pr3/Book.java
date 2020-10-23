package pr3;
import com.sun.jdi.StringReference;

public class Book {
    String avtor;
    String name;
    int date;

    Book(String avtor,String name,int date)
    {
        this.avtor = avtor;
        this.name = name;
        this.date = date;
    }
    public String getAvtor()
    {
        return avtor;
    }
    public String getName()
    {
        return name;
    }
    public int getDate()
    {
        return date;
    }
    public void setAvtor(String avtor){
        this.avtor = avtor;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setDate(int date) {
        this.date = date;
    }
}
class BookTest{
    public static void main(String[] args) {
        Book book = new Book("Александр Сергеевич Пушкин", "Капитанская дочка", 1836);
        String avtor = book.getAvtor();
        String name = book.getName();
        int date = book.getDate();
        System.out.println("Автор: "+ avtor + "\n" + "Название: " + name + "\n" + "Год написания "+ date);
        book.setAvtor("Михаил Юрьевич Лермонтов");
        book.setName("Герой нашего времени");
        book.setDate(1840);
        System.out.println("---------------------");
        String avtor2 = book.getAvtor();
        String name2 = book.getName();
        int date2 = book.getDate();
        System.out.println("Автор: "+ avtor2 + "\n" + "Название: " + name2 + "\n" + "Год написания "+ date2);
    }
}