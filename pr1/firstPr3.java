package pr1;

public class firstPr3 {
    static int Factorial(int n)
    {
        int factorial = 1;
        for (int i = 1; i <= n;i++)
        {
            factorial = factorial*i;
        }
        return factorial;
    }

    public static void main(String[] args) {
        System.out.println(Factorial(5));
    }
}
