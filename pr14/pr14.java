package pr14;


import java.util.Arrays;
import java.util.Scanner;


class Student2 {

    public int id;
    public double gpa;
    public String name;

    public Student2(int id, double gpa, String name) {
        this.id = id;
        this.gpa = gpa;
        this.name = name;
    }
}
class SortingStudentsByGPA2  implements Comp2 {
    @Override
    public void QuickSort2(double[] array, int low, int high) {
        if (array.length == 0)
            return;

        if (low >= high)
            return;

        int middle = low + (high - low) / 2;
        double opora = array[middle];

        int i = low, j = high;
        while (i <= j) {
            while (array[i] > opora) {
                i++;
            }

            while (array[j] < opora) {
                j--;
            }

            if (i <= j) {
                double temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        if (low < j)
            QuickSort2(array, low, j);

        if (high > i)
            QuickSort2(array, i, high);
    }

    @Override
    public void MergeSort2(double[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;

            MergeSort2(arr, l, m);
            MergeSort2(arr, m + 1, r);

            Merge2(arr, l, m, r);
        }
    }

    @Override
    public void Merge2(double[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        double[] L = new double[n1];
        double[] R = new double[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] >= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

}
class Binar implements Comp{
    @Override
    public void binarySearch(double[] arr, int first, int last, double item)
    {
        int position;
        int comparisonCount = 1;
        position = (first + last) / 2;

        while ((arr[position] != item) && (first <= last)) {
            comparisonCount++;
            if (arr[position] > item) {
                last = position - 1;
            } else {
                first = position + 1;
            }
            position = (first + last) / 2;
        }
        if (first <= last) {
            System.out.println(item + " является " + position + " элементом в массиве");
            System.out.println("Метод бинарного поиска нашел число после " + comparisonCount +
                    " сравнений");
        } else {
            System.out.println("Элемент не найден в массиве. Метод бинарного поиска закончил работу после "
                    + comparisonCount + " сравнений");
        }
    }
}
public class pr14 {
    Student2[] arr = new Student2[5];
    int[] IDNumber = new int[5];
    double[] GPA = new double[5];
    String[] names = {"Владимир", "Павел", "Антон", "Егор", "Никита"};
    String name, id, gpa;
    Binar t1 = new Binar();
    SortingStudentsByGPA2 t2 = new SortingStudentsByGPA2();
    public pr14() {
        for (int i = 0; i < 5; i++) {
            arr[i] = new Student2((int) (Math.random() * 30), Math.round((Math.random() * ((50.0 - 20.0) + 1) + 20.0)) / 10D, names[i]);
            IDNumber[i] = arr[i].id;
            GPA[i] = arr[i].gpa;
        }
        Scanner console = new Scanner(System.in);
        int s;
        do {
            System.out.println("1 - Вывод");
            System.out.println("2 - Бинарный поиск");
            System.out.println("3 - Линейный поиск");
            System.out.println("4 - Вывод сортированного");
            System.out.println("0 - Выход");
            System.out.println("Введите число: ");
            s = console.nextInt();
            switch (s) {
                case 1:
                    output();
                    break;
                case 2:
                    int first, last;
                    double item;
                    Scanner input = new Scanner(System.in);
                    Arrays.sort(GPA);
                    System.out.println("Введите элемент для бинарного поиска: ");
                    item = input.nextDouble();
                    first = 0;
                    last = 5;
                    t1.binarySearch(GPA, first, last, item);
                    break;
                case 3:
                    double item2;
                    Scanner input2 = new Scanner(System.in);
                    System.out.println("Введите элемент для бинарного поиска: ");
                    item2 = input2.nextDouble();
                    for(int i =0; i < 5;i++){
                        if(GPA[i]==item2){
                            System.out.println("Элемент "+ item2 +" найден на позиции " + i);
                        }
                    }
                    break;
                case 4:
                    t2.QuickSort2(GPA, 0, GPA.length-1);
                    SortByGPA2();
                    break;
                case 0:
                    System.out.println("Выход...");
                    break;
                default:
                    System.out.println("Ошибка ввода");
            }
        } while (s != 0);
    }

    public void output() {
        for (int i = 0; i < 5; i++) {
            name = "Студент " + arr[i].name;
            id = "ID: " + arr[i].id;
            gpa = "GPA: " + arr[i].gpa;
            System.out.print(name + " " + id + " " + gpa + "\n");
        }
        System.out.println("");
    }
    private void SortByGPA2() {
        System.out.println("Сортировка по GPA:");
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++)
                if (GPA[i] == arr[j].gpa) {
                    Student2 temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
        }
        output();
    }

    public static class Main {
        public static void main(String[] args) {
            pr14 test = new pr14();
        }
    }
}