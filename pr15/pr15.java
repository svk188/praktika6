package pr15;
import java.util.ArrayList;
import java.util.Scanner;


public class pr15 {
    ArrayList<Integer> list = new ArrayList();
    pr15() {
        Scanner console = new Scanner(System.in);
        int s;
        System.out.println("1 - Добавление элемента");
        System.out.println("2 - Вывод");
        System.out.println("3 - Удаление по индексу");
        System.out.println("4 - Удаление по значению");
        System.out.println("5 - Поиск по индексу");
        System.out.println("6 - Поиск по значению");
        System.out.println("7 - Максимальное значение");
        System.out.println("8 - Минимальное значение");
        System.out.println("9 - Среднее арифметическое");
        System.out.println("0 - Выход");
        do {
            System.out.println("Введите число: ");
            s = console.nextInt();
            switch (s) {
                case 1:
                    add();
                    break;
                case 2:
                    out();
                    break;
                case 3:
                    popIndx();
                    break;
                case 4:
                    popEl();
                    break;
                case 5:
                    SearchIndx();
                    break;
                case 6:
                    SearchEl();
                    break;
                case 7:
                    Max();
                    break;
                case 8:
                    Min();
                    break;
                case 9:
                    SrArif();
                    break;
                case 0:
                    System.out.println("Выход...");
                    break;
                default:
                    System.out.println("Ошибка ввода");
            }
        } while (s != 0);
    }
    public void add(){
        System.out.println("Введите число которое хотите добавить -");
        Scanner console = new Scanner(System.in);
        int s;
        s = console.nextInt();
        list.add(s);
        System.out.println("Число "+ s +" добавлено!");
    }
    public void out(){
        int len = list.size();
        for(int i =0;i<len;i++){
            System.out.println(list.get(i)+ " ");
        }
    }
    public void popIndx(){
        System.out.println("Введите индекс числа которое хотите удалить -");
        Scanner console = new Scanner(System.in);
        int s;
        s = console.nextInt();
        if(s <= list.size()) {
            list.remove(s);
            System.out.println("Число с индексом "+s+" удалено");
        }
        else{
            System.out.println("Такого индекса не существует!");
        }
    }
    public void popEl(){
        System.out.println("Введите число которое хотите удалить -");
        Scanner console = new Scanner(System.in);
        int s;
        s = console.nextInt();
        if(list.contains(s) == true){
            int k = list.indexOf(s);
            list.remove(k);
            System.out.println("Число "+ s +" удалено!");
            }
        else{
                System.out.println("Такого элемента нет в списке!");
            }
    }
    public void SearchIndx(){
        System.out.println("Введите индекс числа которое хотите найти -");
        Scanner console = new Scanner(System.in);
        int s;
        s = console.nextInt();
        System.out.println("Под индексом " + s + " находится элемент - "+list.get(s));
    }
    public void SearchEl(){
        System.out.println("Введите число которое хотите найти -");
        Scanner console = new Scanner(System.in);
        int s;
        s = console.nextInt();
        int k = list.indexOf(s);
        System.out.println("Число " + s + " находится на " + k + " позиции");
    }
    public void Max(){
        int max = list.get(0);
        for (Integer i: list) {
            if(i > max)
                max = i;
        }
        System.out.println("Максимальный элемент - "+ max);
    }
    public void Min(){
        int min = list.get(0);
        for (Integer i: list) {
            if(i < min)
                min = i;
        }
        System.out.println("Минимальный элемент - "+ min);
    }
    public void SrArif(){
        double count = 0;
        double result;
        for(Integer i: list){
            count+=i;
        }
        result = count / list.size();
        System.out.println("Среднее арифметическое - " + result);
    }
    public static void main(String[] args) {
        pr15 test = new pr15();
        }
}

