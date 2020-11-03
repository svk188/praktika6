package pr17;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class Game extends JPanel implements ActionListener {
    private final int size =  320;
    private final int DotSize = 16;
    private final int all_dots = 400;
    private int points = 0;
    private Image dot;
    private Image point;
    private int pointX;
    private int pointY;
    private int[] x = new int[all_dots];
    private int[] y = new int[all_dots];
    private int dots;
    private Timer timer;
    private boolean  left,right=true,up,down,inGame=true;
    public Game(){
        setBackground(Color.yellow);
        images();
        initGame();
        addKeyListener(new KeyLissen());
        setFocusable(true);
    }
    public void initGame(){
        dots = 3;
        for(int i= 0;i<dots;i++){
            x[i]=48-i*DotSize;
            y[i]=48;
        }
        timer = new Timer(250,this);
        timer.start();
        createPoint();
    }
    public void createPoint(){
        pointX = new Random().nextInt(19)*DotSize;
        pointY = new Random().nextInt(19)*DotSize;
    }
    public void images(){
        ImageIcon img = new ImageIcon("C:/Users/pypki/IdeaProjects/pr9/src/pr17/black.jpg");
        point = img.getImage();
        ImageIcon img2 = new ImageIcon("C:/Users/pypki/IdeaProjects/pr9/src/pr17/red.jpg");
        dot = img2.getImage();
    }

    public void move(){
        for(int i =dots; i>0;i--){
            x[i]=x[i-1];
            y[i]=y[i-1];
        }
        if (left){
            x[0] -= DotSize;
        }
        if(right)
        {
            x[0] += DotSize;
        }
        if(up)
        {
            y[0] -= DotSize;
        }
        if(down)
        {
            y[0] += DotSize;
        }
    }
    public void checkPoint(){
        if(x[0] == pointX && y[0]==pointY){
            dots++;
            if (dots % 3 == 0) {
                timer.setDelay(timer.getDelay() - 20);
            }
            createPoint();
            points++;
        }
    }

    public void checkCollisions() {
        for(int i = dots;i>0; i--){
            if(i>4 && x[0] == x[i] && y[0] == y[i]){
                inGame = false;
            }
        }
        if(x[0] > size){
            inGame = false;
        }
        if(x[0] < 0){
            inGame = false;
        }
        if(y[0] > size){
            inGame = false;
        }
        if(y[0] < 0){
            inGame = false;
        }
    }
    public void recreate(){
        timer.stop();
        dots = 3;
        points = 0;
        for(int i= 0;i<dots;i++){
            x[i]=48-i*DotSize;
            y[i]=48;
        }
        timer = new Timer(250,this);
        timer.restart();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(inGame){
            checkPoint();
            checkCollisions();
            move();
        }
        repaint();
    }
    class KeyLissen extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            int key = e.getKeyCode();
            if(key == KeyEvent.VK_LEFT && !right){
                left = true;
                up = false;
                down = false;
            }
            if(key == KeyEvent.VK_RIGHT && !left){
                right = true;
                up = false;
                down = false;
            }
            if(key == KeyEvent.VK_UP && !down){
                left =false;
                up = true;
                right = false;
            }
            if(key == KeyEvent.VK_DOWN && !up){
                left = false;
                right = false;
                down = true;
            }
            if (key == KeyEvent.VK_P) {
                timer.stop();
            }

            if (key == KeyEvent.VK_O) {
                timer.start();
            }
        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(inGame){
            g.drawImage(point,pointX,pointY,this);
            for(int i=0;i<dots;i++){
                g.drawImage(dot,x[i],y[i],this);
            }
            String str = "Points - "+points;
            Font f = new Font("Times New Roman",Font.BOLD,14);
            g.setColor(Color.blue);
            g.setFont(f);
            g.drawString(str,10,10);
        }
        else {
            String str = "Game Over";
            Font f = new Font("Times New Roman",Font.BOLD,14);
            g.setColor(Color.black);
            g.setFont(f);
            g.drawString(str,125,size/2);
            String str2 = "Points - " + points;
            Font f2 = new Font("Times New Roman",Font.BOLD,14);
            g.setFont(f);
            g.drawString(str2,125,180);
            JButton button = new JButton("Restart");
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    MainFrame frame = new MainFrame();
                }
            });
            button.setBounds(110,200,100,30);
            add(button);

        }
    }
}
