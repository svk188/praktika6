package practika7;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

abstract class Furniture {
    int price;
    int weight;
    String name;


    Furniture() {
    }

    void setPrice(int cost) {
        this.price = cost;
    }

    void setWeight(int Weight) {
        this.weight = this.weight;
    }

    void setName(String name) {
        this.name = name;
    }

    int getWeight() {
        return this.weight;
    }

    String getName() {
        return this.name;
    }

    public int getPrice() {
        return this.price;
    }
}

class Sofa extends Furniture {
    Sofa() {
        this.price = 20000;
        this.weight = 50;
        this.name = "Раскладной";
    }

    public String toString() {
        return "Диван, Цена=" + this.price + ", Вес=" + this.weight + ", Тип='" + this.name;
    }


}
class Table extends Furniture {
    int size;

    Table() {
        this.price = 5000;
        this.weight = 20;
        this.name = "Кухонный";
        this.size = 40;
    }

    void setSize(int size) {
        this.size = size;
    }

    int getSize() {
        return this.size;
    }

    public String toString() {
        return "Стол, Цена=" + this.price + ", Вес=" + this.weight + ", Тип='" + this.name + "', Размер=" + this.size;
    }


}

class Person {
    private ArrayList cart = new ArrayList();

    Person() {
    }
    void addToCart(Furniture tmp) {
        this.cart.add(tmp);
    }
    ArrayList getCart() {
        return this.cart;
    }
}
class FurnitureShop1 {
    FurnitureShop1() {
    }
    static Table BuyTable() {
        return new Table();
    }

    static Sofa BuySofa() {
        return new Sofa();
    }
}


class FurnitureTest {
    public FurnitureTest() {
    }

    public static void main(String[] args) {
        Person bob = new Person();
        System.out.println("Добро пожаловать в магазин.");
        Table table = new Table();
        Sofa sofa = new Sofa();
        Scanner console = new Scanner(System.in);
        int s;
        do {
            System.out.println("1 - посмотреть стол");
            System.out.println("2 - посмотреть диван");
            System.out.println("3 - посмотреть корзину");
            System.out.println("0 - выйти с магазина");
            System.out.println("Введите число: ");
            s = console.nextInt();
            switch (s) {
                case 1:
                    System.out.println("Название мебели: "+ table);
                    System.out.println("Добавить товар в корзину - 1, нет - 0");
                    int choice = console.nextInt();
                    if (choice == 1){
                        bob.addToCart(FurnitureShop1.BuyTable());
                    }
                    else {break;}
                    break;
                case 2:
                    System.out.println("Название мебели: "+ sofa);
                    System.out.println("Добавить товар в корзину - 1, нет - 0");
                    int choice2 = console.nextInt();
                    if (choice2 == 1){
                        bob.addToCart(FurnitureShop1.BuySofa());
                    }
                    else {break;}
                    break;
                case 3:
                    System.out.println("Корзина: ");
                    Iterator var2 = bob.getCart().iterator();
                    while(var2.hasNext()) {
                        Object item = var2.next();
                        System.out.println(item);
                    }
                case 0:
                    break;
                default:
                    System.out.println("Ошибка ввода");
                    break;
            }
        } while (s != 0);
    }
}