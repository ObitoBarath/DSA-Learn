package OOPs.abstraction;

public class Abstraction {

    abstract class API {
        abstract public void add();
        public String returnValue(){
            return  "";
        }
    }
    interface InterfaceAPI{
        void get();
        default String getValue(){
            return  "";
        }
    }
    public static class InterfaceImplementation implements InterfaceAPI{

        @Override
        public void get() {

        }

    }

    public class Implementation extends API {

        @Override
        public void add() {

        }
    }


    public static void main(String[] args) {

        InterfaceImplementation interfaceImplementation  = new InterfaceImplementation() ;
        interfaceImplementation.getValue();
    }

}
