package pr21;

import java.util.Scanner;

class ExceptionsTest {

    public static void main(String[] args) {

        //Задание 1
        //System.out.println(2 / 0);
        //Задание 1.1
        //System.out.println(2.0 / 0.0); Выведется Infinity;
        //Задание 1.2
        //exceptionDemo(); Вводим число на которое хотим поделить, если вводить 0 то выводит ошибку ArithmeticException: / by zero

        //Задание 2
        //exception1Demo();
        /*При добавлении catch (Exception e) проверки на другие
        исключения выполняться не будут (класс Exception - родитель всех остальных видов исключений)*/
        //Задание 3
        /* происходит перехват ошибки и вывод "Невозможно поделить на 0"*/

        // Задание 4
        //exception2Demo();
        /*блок finally - программа будет выполнять код, находящийся в этом блоке,
        в любом случае, было ли исключение или нет*/


    }

    public static void exceptionDemo() {
            Scanner myScanner = new Scanner( System.in );
            System.out.print( "Enter an integer ");
            String intString = myScanner.next();
            int i = Integer.parseInt(intString);
            System.out.println( 2 / i );
    }
    public static void exception1Demo() {
        try {
            System.out.println(2 / 0);
        }catch (Exception e){
            System.out.println("Общее исключение класса Exception");
        }
    }
    public static void exception2Demo() {

        Scanner myScanner = new Scanner(System.in);
        System.out.print("Enter an int");
        try {
            int i = Integer.parseInt(myScanner.next());
            System.out.println(2 / i);
        }catch (ArithmeticException e){
            System.out.println("Невозможно поделить на 0");
        }catch (NumberFormatException e){
            System.out.println("Неправильный ввод");
        }finally{
            System.out.println("Finally");
        }
    }


}