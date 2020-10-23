package pr13;

import java.util.Arrays;
import java.util.Scanner;

class Student {

    public int id;
    public double gpa;
    public String name;

    public Student(int id, double gpa, String name) {
        this.id = id;
        this.gpa = gpa;
        this.name = name;
    }
}

class SortingStudentsByGPA  implements Comparator{
    @Override
    public void QuickSort(double[] array, int low, int high) {
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
            QuickSort(array, low, j);

        if (high > i)
            QuickSort(array, i, high);
    }

    @Override
    public void MergeSort(double[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;

            MergeSort(arr, l, m);
            MergeSort(arr, m + 1, r);

            Merge(arr, l, m, r);
        }
    }

    @Override
    public void Merge(double[] arr, int l, int m, int r) {
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
public class pr13 {
    Student[] arr = new Student[5];
    int[] IDNumber = new int[5];
    double[] GPA = new double[5];
    String[] names = {"Владимир", "Павел", "Антон", "Егор", "Никита"};
    String name, id, gpa;
    SortingStudentsByGPA t1 = new SortingStudentsByGPA();

    public pr13() {
        for(int i = 0; i < 5; i++) {
            arr[i] = new Student((int) (Math.random() * 30), Math.round((Math.random()*((50.0-20.0)+1)+20.0))/10D, names[i]);
            IDNumber[i] = arr[i].id;
            GPA[i] = arr[i].gpa;
        }
        Scanner console = new Scanner(System.in);
        int s;
        do {
            System.out.println("1 - Список студентов");
            System.out.println("2 - Сортировка по ID");
            System.out.println("3 - Сортировка баллов методом Быстрой сортировки");
            System.out.println("4 - Сортировка баллов методом сортировки Слиянием");
            System.out.println("0 - Выход");
            System.out.println("Введите число: ");
            s = console.nextInt();
            switch (s) {
                case 1:
                    output();
                    break;
                case 2:
                    SortByID();
                    break;
                case 3:
                    t1.QuickSort(GPA, 0, GPA.length-1);
                    SortByGPA();
                    break;
                case 4:
                    t1.MergeSort(GPA, 0, GPA.length-1);
                    SortByGPA();
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
        for(int i = 0; i < 5; i++) {
            name = "Студент "+arr[i].name;
            id = "ID: "+arr[i].id;
            gpa = "GPA: "+arr[i].gpa;
            System.out.print(name+" "+id+" "+gpa+"\n");
        }
        System.out.println("");
    }

    private void SortByID() {
        Arrays.sort(IDNumber);
        System.out.println("Сортировка по ID:");
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++)
                if (IDNumber[i] == arr[j].id) {
                    Student temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
        }
        output();
    }

    private void SortByGPA() {
        System.out.println("Сортировка по GPA:");
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++)
                if (GPA[i] == arr[j].gpa) {
                    Student temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
        }
        output();
    }
    public static class Main {
        public static void main(String[] args) {
            pr13 test = new pr13();
        }
    }
}