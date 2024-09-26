package praktika6;


public abstract class Shape {
    public String color;
    abstract void area();

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
class Circle1 extends Shape{
    private int radius = 22;
    public int getRadius() {
        return radius;
    }
    @Override
    void area(){
        System.out.println("Площадь круга= " + Math.PI * radius* radius);
    }
}
class Rectangle1 extends Shape{
    public int b;
    public int a;
    public int speed;
    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    @Override
    void area(){
        System.out.println("Площадь прямоугольника= " +(a*b));
    }
}
interface Movable{
    public void move(int x,int y,int speedX,int speedY);
}
class MovableRectangle extends Rectangle1 implements Movable{

    @Override
    public void move(int x,int y,int speedX,int speedY)
    {
        a+=x;
        b+=y;
    }

    @Override
    public String toString() {
        return "A = "+a+"\nB = "+b;
    }
}
class MovablePoints extends Rectangle1 implements Movable
{
    int speedX,x,y,speedY;
    @Override
    public void move(int x, int y,int speedX,int speedY)
    {
        this.x+=x;
        this.y+=y;
        speedX+=speedX;
        speedY+=speedY;
    }
    String checkSpeed()
    {
        if (speedX==speedY)
            return "Скорость одинакова";
        else
            return  "Скорость разная";
    }
    @Override
    public String toString() {
        return "A = "+x+"\nB = "+y;
    }
}

class Triangle1 extends Shape{
    private int a = 6;
    private int h = 5;
    public int getH() {
        return h;
    }
    @Override
    void area(){
        System.out.println("Площадь треугольника= " +((0.5)*a*h));
    }
}
class Test{
    public static void main(String[] args) {
        MovableRectangle rectangle = new MovableRectangle();
        MovablePoints rectangle2 = new MovablePoints();
        rectangle2.move(2,5,4,4);
        rectangle.move(2,4,4,4);
        System.out.println(rectangle2+"\n"+ rectangle2.checkSpeed());

    }
}