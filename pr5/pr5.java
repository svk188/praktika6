package pr5;

abstract class Shape {
    abstract void area();
}
class Circle extends Shape{
    @Override
    void area(){
        System.out.println("Площадь круга= " + 55);
    }
}
class Rectangle extends Shape{
    @Override
    void area(){
        System.out.println("Площадь прямоугольника= " +35);
    }
}
class Triangle extends Shape{
    @Override
    void area(){
        System.out.println("Площадь треугольника= " +15);
    }
}
class Test{
    public static void main(String[] args) {
        Circle circle = new Circle();
        Rectangle rectangle = new Rectangle();
        Triangle triangle = new Triangle();
        circle.area();
        rectangle.area();
        triangle.area();
    }
}