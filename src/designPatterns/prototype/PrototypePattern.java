package designPatterns.prototype;


class Prototype implements Cloneable{
    String name;

    Prototype(String name){
        this.name = name;
    }
    public Prototype clone() throws CloneNotSupportedException{
        return (Prototype) super.clone();
    }
    public void show(){
        System.out.println("Cloned "+name);
    }
}

public class PrototypePattern {


    public static void main(String[] args) throws CloneNotSupportedException {
        Prototype  prototype = new Prototype("Hello");

        Prototype clone = prototype.clone();
        clone.show();
    }


}
