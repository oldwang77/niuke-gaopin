package factory;

public class ShapeFactory {
    public Shape getShape(String shape) {
        if (shape == null) {
            return null;
        }
        if (shape == "circle") {
            return new Circle();
        } else if (shape == "rectangle") {
            return new Rectangle();
        } else if (shape == "square") {
            return new Square();
        }
        return null;
    }
}
