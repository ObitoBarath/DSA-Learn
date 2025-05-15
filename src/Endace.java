public class Endace {

    static public  Integer getNumberOfNodes(String nodeId) {

        if (nodeId.contains("1")){
            return 10;
        }


        return 0;
    }

    public static void main(String[] args) {
        System.out.println("Hello");

        System.out.println(getNumberOfNodes("2345678"));

    }
}
