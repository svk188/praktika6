package pr2;
class Shape {
    class triangle {
        int a = 30;
        String type = "Равнобедренный";
        String shape = "Треугольник";
        public int getA() {
            return a;
        }
        public String getType() {
            return type;
        }
        public String getShape() {
            return shape;
        }
    }
}
class output
{
    public static void main(String[] args) {
        Shape tr = new Shape();
        Shape.triangle shape = tr.new triangle();
        String figura = shape.getShape();
        String tip = shape.getType();
        int a = shape.getA();
        System.out.println("Фигура - " + figura);
        System.out.println("Тип - " + tip);
        System.out.println("Длина сторон - " + a + " см");
    }
}