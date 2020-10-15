package pr11;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class pr11 extends JFrame {
    public static void main(String[] args) {
        new pr11();
    }
    private int randNum;
    private int attemps = 3;
    pr11() {
        setLayout(null);
        setTitle("Game");
        setMinimumSize(new Dimension(500, 500));
        setSize(500, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        Label label = new Label("Введите число от 0 до 20");
        label.setBounds(160, 110, 400, 40);
        add(label);

        JTextField textField = new JTextField(10);
        textField.setBounds(180,150,90,40);
        add(textField);

        Random rand = new Random();
        randNum = rand.nextInt(21);
        System.out.println(randNum);

        JButton button = new JButton("GO");
        button.setBounds(195,200,60,30);
        add(button);

        Label label2 = new Label();
        label2.setVisible(false);
        add(label2);

        Label label3 = new Label();
        label3.setVisible(false);
        add(label3);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int UserNum = Integer.parseInt(textField.getText());
                if (UserNum == randNum)
                {
                    label2.setBounds(200,230,100,50);
                    label2.setText("Победа!");
                    label2.setVisible(true);
                    button.setVisible(false);
                    label3.setVisible(false);
                }
                else{
                    if(attemps > 1) {
                        label2.setBounds(180, 230, 100, 50);
                        label3.setBounds(160, 240, 150, 100);
                        if (UserNum > randNum) {
                            label2.setText("Число меньше!");
                            label2.setVisible(true);
                            attemps--;
                            label3.setText("Осталось попыток: " + attemps);
                            label3.setVisible(true);
                        } else {
                            label2.setText("Число больше!");
                            label2.setVisible(true);
                            attemps--;
                            label3.setText("Осталось попыток: " + attemps);
                            label3.setVisible(true);
                        }
                    }
                    else
                    {
                        label2.setText("Вы проиграли!");
                        label2.setVisible(true);
                        label3.setVisible(false);
                        button.setVisible(false);
                    }
                }
            }
        });
        setVisible(true);
    }
}