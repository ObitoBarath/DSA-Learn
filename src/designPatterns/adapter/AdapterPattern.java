package designPatterns.adapter;

interface USBC{

    void connectWithUSBC();

}

class OldLaptop implements  USBC{

    OldLaptop oldLaptop;

    void connectWithUSBA(){
        System.out.println("USBA SUPPORT ");
    }

    @Override
    public void connectWithUSBC() {
        System.out.println("USBC SUPPORT ");
        oldLaptop.connectWithUSBA();

    }

}

public class AdapterPattern {

    public static void main(String[] args) {
        OldLaptop oldLaptop = new OldLaptop();
        oldLaptop.connectWithUSBC();


    }

}
