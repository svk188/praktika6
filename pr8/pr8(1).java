package pr8;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;

abstract   class Shape1 extends  JComponent {
    private int a,b,c,d;
    Shape1(int a,int b,int c, int d)
    {
        this.a=a;
        this.b=b;
        this.c=c;
        this.d=d;
    }

}
class Figure1 extends Shape1 {

    protected int x,y,w,h;
    protected int r=0,t=0,u=0;
    Figure1(int a,int b,int c,int d){
        super(a,b,c,d);

    }
    public void Rand(){
        x=(int)(Math.random()*1000);
        y=(int)(Math.random()*900);
        w=(int)(Math.random()*400);
        h=(int)(Math.random()*300);
        r=(int)(Math.random()*255);
        t=(int)(Math.random()*255);
        u=(int)(Math.random()*255);
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        for(int i=0;i<10;i++)
        {
            Rand();
            g2.drawOval(x,y,w,h);
            g2.setPaint(new Color(r,t,u));
        }
        for(int i=0;i<10;i++)
        {
            Rand();
            g2.drawRect(x,y,w,h);
            g2.setPaint(new Color(r,t,u));
        }
    }
}
class Figure{
    public static void main(String[]args) {
        JFrame jFrame = getFrame();
        jFrame.add(new Figure1(28,9,56,11));
    }

    static JFrame getFrame()
    {
        JFrame jFrame=new JFrame(){};
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setBounds(0,0,1980,1080);
        return jFrame;
    }
}