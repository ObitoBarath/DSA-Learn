package Stacks;

public class Main {


    public static void main(String[] args) {
        /*CustomStack customStack = CustomStack.getCustomStackInstance();

        customStack.push(-2);
        customStack.push(0);
        customStack.push(-3);
        System.out.println("customStack = " + customStack.getMin());
        customStack.pop();
        System.out.println("top = " + customStack.topElement);
        System.out.println("customStack = " + customStack.getMin());
        System.out.println(Arrays.toString(customStack.customStackArray));
*/

        CustomLinkedListStack customLinkedListStack  = new CustomLinkedListStack();
        customLinkedListStack.push(2);
        customLinkedListStack.push(3);
        customLinkedListStack.push(4);
        customLinkedListStack.push(5);
        customLinkedListStack.push(6);
        customLinkedListStack.pop();
        customLinkedListStack.pop();
        customLinkedListStack.pop();
        customLinkedListStack.pop();
        customLinkedListStack.pop();

        System.out.println("customLinkedListStack = " + customLinkedListStack.isEmpty());
        System.out.println("customLinkedListStack = " + customLinkedListStack.peek());









    }


}
