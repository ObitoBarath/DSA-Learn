package designPatterns.factory;


interface Shape{
    void draw();
}

class Square implements Shape{


    public void draw() {
        System.out.println("Drawing Square ");
    }
}

class Circle implements Shape{

    public void draw() {
        System.out.println("Drawing Circle ");
    }
}

class ShapeFactory{
    public  static Shape getShape(String type){

        return switch (type){
            case "Circle" -> {
                yield  new Circle();
            }

            case "Square" -> new Square();
            default -> null;
        };
    }
}
public class FactoryPattern {



    public static void main(String[] args) {
        Shape circle = ShapeFactory.getShape("Square");
        circle.draw();
    }

}
