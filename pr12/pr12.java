package pr12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;


enum Planet {
    МЕРКУРИЙ (3.303e+23, 2.4397e6),
    ВЕНЕРА   (4.869e+24, 6.0518e6),
    ЗЕМЛЯ   (5.976e+24, 6.37814e6),
    МАРС    (6.421e+23, 3.3972e6),
    ЮПИТЕР (1.9e+27,   7.1492e7),
    САТУРН  (5.688e+26, 6.0268e7),
    УРАН  (8.686e+25, 2.5559e7),
    НЕПТУН (1.024e+26, 2.4746e7);


    private final double weight;
    private final double radius;
    Planet(double weight, double radius) {
        this.weight = weight;
        this.radius = radius;
    }
    public static final double G = 6.67300E-11;
    double surfaceGravity() {
        return G * weight / (radius * radius);
    }
}
public class pr12 extends JFrame {
    public static void main(String[] args) {
        new pr12();
    }

    JMenuBar menuBar = new JMenuBar();

    pr12() {
        setLayout(null);
        setTitle("Planet");
        setMinimumSize(new Dimension(500, 500));
        setSize(815, 500);
        getContentPane().setBackground(Color.YELLOW);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        Label label = new Label("Выберите планету!");
        label.setBounds(300, 150, 200, 35);
        Font font = new Font("Times New Roman", Font.ITALIC, 18);
        label.setFont(font);
        label.setVisible(true);
        add(label);

        final ImageIcon icon1 = new ImageIcon("src/pr12/planet.jpg");
        final JLabel label1 = new JLabel(icon1);
        label1.setBounds(0,0,800,150);
        add(label1);

        Label label2 = new Label();
        label2.setBounds(200, 225, 400, 30);
        Font font2 = new Font("Times New Roman", Font.ITALIC, 20);
        label2.setFont(font2);
        label2.setVisible(false);
        add(label2);

        Label label3 = new Label();
        label3.setBounds(310, 250, 400, 30);
        Font font3 = new Font("Times New Roman", Font.ITALIC, 18);
        label3.setFont(font3);
        label3.setVisible(false);
        add(label3);

        JComboBox faceCombo = new JComboBox();
        Planet[] allPlanet = Planet.values();
        faceCombo.setEditable(true);
        for (Planet planet : allPlanet) {
            faceCombo.addItem(planet);
        }


        faceCombo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                //label.setAlignment((int)(Planet.MARS.surfaceGravity()));

                Object item = faceCombo.getSelectedItem();
                label2.setText("Гравитация на планете " + String.valueOf(item) + " равна ");
                label2.setVisible(true);
                //label.setText(Double.toString(Planet.item.surfaceGravity()));
                if (String.valueOf(item) == "МЕРКУРИЙ") {
                    label3.setText(Double.toString(Planet.МЕРКУРИЙ.surfaceGravity()));
                    label3.setVisible(true);
                } else if (String.valueOf(item) == "ВЕНЕРА") {
                    label3.setText(Double.toString(Planet.ВЕНЕРА.surfaceGravity()));
                    label3.setVisible(true);
                } else if (String.valueOf(item) == "ЗЕМЛЯ") {
                    label3.setText(Double.toString(Planet.ЗЕМЛЯ.surfaceGravity()));
                    label3.setVisible(true);
                } else if (String.valueOf(item) == "МАРС") {
                    label3.setText(Double.toString(Planet.МАРС.surfaceGravity()));
                    label3.setVisible(true);
                } else if (String.valueOf(item) == "ЮПИТЕР") {
                    label3.setText(Double.toString(Planet.ЮПИТЕР.surfaceGravity()));
                    label3.setVisible(true);
                } else if (String.valueOf(item) == "САТУРН") {
                    label3.setText(Double.toString(Planet.САТУРН.surfaceGravity()));
                    label3.setVisible(true);
                } else if (String.valueOf(item) == "УРАН") {
                    label3.setText(Double.toString(Planet.УРАН.surfaceGravity()));
                    label3.setVisible(true);
                } else if (String.valueOf(item) == "НЕПТУН") {
                    label3.setText(Double.toString(Planet.НЕПТУН.surfaceGravity()));
                    label3.setVisible(true);
                }
            }
        });
        faceCombo.setBounds(325, 190, 100, 35);
        faceCombo.setBackground(Color.YELLOW);
        add(faceCombo);
        setVisible(true);
    }

}