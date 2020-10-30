package pr16;


import java.util.ArrayDeque;
import java.util.Scanner;

public class pr16 {
    ArrayDeque<Integer> gamer1 = new ArrayDeque<Integer>();
    ArrayDeque<Integer> gamer2 = new ArrayDeque<Integer>();
    Scanner console = new Scanner(System.in);
    pr16() {
        String s = console.nextLine();
        char[] result = s.toCharArray();
        for (int i = 0; i < result.length; i++) {
            if (result[i] != '\t') {
                gamer1.add((int) result[i] - 48);
            }
        }
        String s2 = console.nextLine();
        char[] result2 = s2.toCharArray();
        for (int i = 0; i < result2.length; i++) {
            if (result2[i] != '\t') {
                gamer2.add((int) result2[i] - 48);
            }
        }
        game();
    }
    public void game() {
        int counter = 0;
        for (int i = 0; i < 106; i++) {
            counter++;
            if (gamer1.getFirst() < gamer2.getFirst() || ((gamer1.getFirst() == 9) && (gamer2.getFirst() == 0))) {
                gamer2.addLast(gamer1.getFirst());
                gamer2.addLast(gamer2.getFirst());
            } else if (gamer1.getFirst() > gamer2.getFirst() || ((gamer1.getFirst() == 0) && (gamer2.getFirst() == 9))) {
                gamer1.addLast(gamer1.getFirst());
                gamer1.addLast(gamer2.getFirst());
            }
            gamer1.remove();
            gamer2.remove();
            if (gamer1.isEmpty()) {
                System.out.println("second " + counter);
                break;
            } else if (gamer2.isEmpty()) {
                System.out.println("first " + counter);
                break;
            }
        }
    }
    public void out()
    {
        for(Integer i:gamer1)
        {
            System.out.print(i+"\t");
        }
        System.out.print("\n");
        for(Integer i:gamer2)
        {
            System.out.print(i+"\t");
        }

    }
    public static void main(String[] args) {
        pr16 test = new pr16();
    }
}
