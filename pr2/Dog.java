package pr2;
import java.util.Arrays;

public class Dog {
    public String name;
    public int age;
    public Dog(String name, int age){
        this.name = name;
        this.age = age;
    }
    public String getName(){
            return name;
        }
    public int getAge()
    {
        return age;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int convert()
    {
        int ageCon = age * 7;
        return ageCon;
    }
    @Override
    public String toString(){
        return "Кличка - " + name + " " + "Возвраст - " + age;
    }
}
class PitomnikSabak
{
    static Dog[] dogs = new Dog[3];
    public static void main(String[] args) {
        dogs[0] = new Dog("Шарик", 2);
        dogs[1] = new Dog("Бобик", 5);
        dogs[2] = new Dog("Тузик", 8);
        for (int i = 0; i<3; i++){
            System.out.print("Кличка - " + dogs[i].name);
            System.out.println(" Возраст - " + dogs[i].age);
        }

        Dog dog = new Dog("Пушистик", 3);
        System.out.println(dog);
        int age = dog.convert();
        System.out.println("Перевод в человеческий возраст - " + age);
        dog.setAge(5);
        System.out.println(dog);
        int age2 = dog.convert();
        System.out.println("Перевод в человеческий возраст - " + age2);
    }
}
