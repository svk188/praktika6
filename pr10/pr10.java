package pr10;


public class pr10 {
    public static int recursion(int len, int sum, int k, int s) {
        if (len == k) {
            if (sum == s) {
                return 1;
            } else {
                return 0;
            }
        }
        int r = (len == 0 ? 1 : 0);
        int result = 0;
        for (int i = r; i < 10; i++) {
            result += recursion(len + 1, sum + i, k, s);
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(recursion(0, 0, 2, 15));
    }
}