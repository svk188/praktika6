package pr1;

public class firstPr {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        int sum = 0;
        int sum2 = 0;
        int sum3 = 0;
        int k=0;
        int j=0;

        for (int i = 0; i < arr.length+1;i++){
            sum += i;
        }

        while (k<6)
        {
            sum2 += arr[k];
            k++;
        }

        do{
            sum3 += arr[j];
            j++;
        }while(j<6);

        System.out.println("for = " + sum);
        System.out.println("while = " + sum2);
        System.out.println("do while = " + sum3);
    }
}
