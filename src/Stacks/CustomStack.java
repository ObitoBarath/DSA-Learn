package Stacks;

public class CustomStack implements Runnable {


    static CustomStack customStack =null;
    int[] customStackArray;
    int minCapacity = 10;
    int topElement;

    public static CustomStack getCustomStackInstance(){
        if (customStack == null){
            synchronized (CustomStack.class){
                if (customStack ==null){
                    customStack = new CustomStack();
                }
            }
        }
        return customStack;

    }


    private CustomStack(){
        customStackArray = new int[minCapacity];
        topElement  = -1;
    }

    public void push(int value){
        if (topElement == minCapacity -1){
            resize();
        }

        customStackArray[++topElement] = value;
    }

    public int pop(){
        System.out.println("topElement = " + topElement);
        if (isEmpty()){
            throw new NegativeArraySizeException("Array is empty , nothing to pop ");
        }

        return customStackArray[topElement--];
    }

    public boolean isEmpty(){
        return topElement == -1;
    }

    public void resize(){
        int[] newArray = new int[minCapacity * 2];
        System.arraycopy(customStackArray , 0 ,newArray , 0 , minCapacity );
        customStackArray = newArray;
        minCapacity *= 2;
    }
    public int getMin(){
        int i = topElement;

        int min = Integer.MAX_VALUE;
        while (i > -1){
            if (customStackArray[i] < min){
                min = customStackArray[i];
            }else {
                i--;
            }

        }

        return min;
    }


    @Override
    public void run() {

    }
}
