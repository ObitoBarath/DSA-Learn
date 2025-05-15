package designPatterns.singleton;

public class Singleton {

    private static Singleton instance;

    private Singleton(){
    }

    public synchronized  static  Singleton getInstance(){


        synchronized (Singleton.class){

        }
        if (instance == null){

            instance  = new Singleton();

        }
        return  instance;
    }



    public void sayHello(){
        System.out.println("Hello ");
    }

    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        instance.sayHello();;
    }


}




