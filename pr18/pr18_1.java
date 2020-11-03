package pr18;

public class pr18_1 {
    public static void recursion(int n, int k) {
        if (k > n / 2) {
            System.out.println(n);
            return;
        }
        if (n % k == 0) {
            System.out.println(k);
            recursion(n / k, k);
        }
        else {
            recursion(n, ++k);
        }
    }
    public static void main(String[] args) {
        recursion(18, 2);
    }
}
