import java.util.ArrayList;
import java.util.List;

public class Fibonacci {
    private static int counter = 0 ;
    public void main(String[] args) {
        /*int previousNumber = 0;
        int currentNumber = 1;
        fibonacciWithRecursion(previousNumber, currentNumber);*/

        /*int nthFibonacci = findNthFibonacci(5);
        System.out.println("nthFibonacci = " + nthFibonacci);*/


        List<String> numberString = new ArrayList<>();

        numberString.add("1");
        numberString.add("2");
        numberString.add("3");
        numberString.add("4");
        numberString.add("5");
        numberString.add("6");
        System.out.println("numberString = " + numberString);
        List<Integer> integerList = numberString.stream().map(Integer::parseInt).toList();
        System.out.println("integerList = " + integerList);

    }

    public   int  findNthFibonacci(int nthNumber) {

        if (nthNumber <= 1) {
            System.out.println(" case 1 ");
            return nthNumber;
        }
        else{
            System.out.println(" case 2 ");
            return findNthFibonacci(nthNumber - 1) + findNthFibonacci(nthNumber -2);
        }
    }

    private static void fibonacciWithRecursion(int previousNumber, int currentNumber){
        counter ++;

        if(currentNumber < 0){
            return;
        }
        int fibb = previousNumber + currentNumber;

        System.out.println("fibb = " + fibb  + " of = " + counter);

        previousNumber = currentNumber;

        fibonacciWithRecursion( previousNumber  , fibb);
    }


    private void fibonacciWithForLoop() {
        int previousNumber = 0;
        int currentNumber = 1;

        for (int i = 0; i <= 100; i++) {
            int fibNumber = previousNumber + currentNumber;

            System.out.println("fibonacci number = " + fibNumber);
            previousNumber = currentNumber;
            currentNumber =  fibNumber;
        }
    }
}
