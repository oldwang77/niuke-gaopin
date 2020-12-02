package factory;

public class FactoryPatternDemo {
    public static void main(String[] args) {
        ShapeFactory s = new ShapeFactory();
        s.getShape("circle").draw();
    }
}
