public class PrintingPatterns {


    public  void main(String[] args) {

        pattern1();
    }
    public void pattern1(){
        int  n = 4;
        for (int i =0 ; i <=n;i++){

            for (int j  = 0   ; j <= n ; j++){
                if (i != 1 && i != 4){
                    System.out.print("*");
                }

            }
            System.out.println();

        }
    }
}
