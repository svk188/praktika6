package pr17;

import javax.swing.*;
import java.awt.*;


public class MainFrame extends JFrame {
    public MainFrame(){
        setTitle("Snake");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(320,345);
        setLocation(400,400);
        add(new Game());
        setVisible(true);

    }

    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
    }
}
