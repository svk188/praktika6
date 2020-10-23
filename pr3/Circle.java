package pr3;
public class Circle {
    double x;
    double y;
    double r;

    Circle(double x,double y,double r)
    {
        this.x = x;
        this.y = y;
        this.r = r;
    }
    public double getX()
    {
        return x;
    }
    public double getY()
    {
        return y;
    }
    public double getR()
    {
        return r;
    }
    public void setX(double x){
        this.x = x;
    }
    public void setY(double y){
        this.y = y;
    }
    public void setR(double r){
        this.r = r;
    }
}
class CircleTest{
    public static void main(String[] args) {
        Circle circle = new Circle(2.0,2.0,2.0);
        double x = circle.getX();
        double y = circle.getY();
        double r = circle.getR();
        System.out.println("X = "+ x +" Y = " + y + " R = "+ r);
        circle.setX(5.0);
        circle.setY(7.0);
        circle.setR(3.0);
        double a = circle.getX();
        double b = circle.getY();
        double c = circle.getR();
        System.out.println("X = "+ a +" Y = " + b + " R = "+ c);
    }
}