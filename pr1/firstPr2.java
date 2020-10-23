package pr1;

import java.util.Random;
import java.util.Arrays;
public class firstPr2 {
    public static void main(String[] args){
        int[] arr = new int[10];
        int[] arr2 = new int[10];
        System.out.print("Math.random = ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 10);
            System.out.print(arr[i]+ " ");
        }
        Arrays.sort(arr);
        System.out.print("\nSorted arr - " );
        for(int i = 0;i< arr.length;i++) {
            System.out.print(arr[i]+ " ");
        }
        System.out.print("\nRandom = ");
        for (int i = 0; i < arr.length; i++) {
            Random rand = new Random();
            int a = rand.nextInt(10);
            arr2[i] = a;
            System.out.print(arr2[i]+ " ");
        }
        Arrays.sort(arr2);
        System.out.print("\nSorted arr - " );
        for(int i = 0;i< arr.length;i++) {
            System.out.print(arr2[i]+ " ");
        }
    }
}
