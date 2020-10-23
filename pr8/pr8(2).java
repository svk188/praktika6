package pr8;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


class Main2 extends JPanel {
    public static void main(String[] args) throws IOException {
        String path = args[0];
        BufferedImage image1 = ImageIO.read(new File(path));
        JFrame frame = new JFrame();
        JLabel label = new JLabel(new ImageIcon(image1));
        frame.add(label);
        frame.setSize(800, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}