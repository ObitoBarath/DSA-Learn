package tries;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Tries  {

    TrieNode root ;
    public Tries(){
        this.root = new TrieNode();

    }


    public void insert (String word){


        TrieNode temp= root;
        for (char c : word.toCharArray()) {
            if (!temp.containsKey(c)){
                temp.put(c , new TrieNode()) ;
            }
            temp = temp.get(c);

        }
        temp.isEndOfWord = true;
    }

    public void print(){
        TrieNode trieNode = root;

        printHelperUsingDFS(trieNode , new StringBuilder());
    }

    public  List<String> getMatchedWords(String prefix){
        TrieNode current = root;
        List<String> strings = new LinkedList<>();
        StringBuilder stringBuilder = new StringBuilder();

        for (char c : prefix.toCharArray()) {

            if (!current.containsKey(c)){
                return  strings;
            }else {
                stringBuilder.append(c);
                current = current.get(c);
            }
        }

        getWordsUsingDFS(current ,stringBuilder ,strings );


        return strings;

    }

    public void getWordsUsingDFS(TrieNode trieNode , StringBuilder stringBuilder , List<String> strings){

        if (trieNode.isEndOfWord){
            strings.add(stringBuilder.toString());
        }


        for (char c = 'a' ; c <= 'z' ; c++ ){
            if (trieNode.containsKey(c)){
                stringBuilder.append(c);
                getWordsUsingDFS(trieNode.get(c) , stringBuilder , strings);
                stringBuilder.deleteCharAt(stringBuilder.length()- 1);
            }
        }


    }

    public void printHelperUsingDFS(TrieNode trieNode  , StringBuilder stringBuilder ){

        if (trieNode.isEndOfWord){

            System.out.println(stringBuilder.toString());
        }

        for (char c = 'a' ; c <= 'z' ; c ++){


            if (trieNode.containsKey(c)){

                stringBuilder.append(c);
                printHelperUsingDFS(trieNode.get(c) , stringBuilder);
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
        }

    }


    public static void main(String[] args) {
        Tries trie = new Tries();
        trie.insert("hi");
        trie.insert("hello");
        trie.insert("hey");
        trie.insert("horse");
        trie.insert("hell");
        trie.insert("nell");
        trie.insert("well");
        trie.insert("eell");
        trie.print();
        List<String> h = trie.getMatchedWords("e");
        System.out.println("h = " + h);

        MyClass myClass = new MyClass("sa");
        System.out.println(myClass.number);
        System.out.println(myClass.text);

        Map<String, List<String>> collect = Stream.of("1", "2", "3")
                .filter(item -> item.contains("2") || item.contains("3")) // Filter items
                .collect(Collectors.toMap(
                        o1 -> "p",
                        o2 -> new ArrayList<>(Collections.singletonList(o2)),
                        (existing, replacement) -> {
                            existing.addAll(replacement);
                            return existing;
                        }
                ));

        System.out.println("collect =" + collect);
        parenthesisChecker();



    }

    public static void parenthesisChecker(){
        String parenthesis  = "{[()}}";
        Stack<Character> characterStack = new Stack<>();



        for (char c : parenthesis.toCharArray()) {

            if (Arrays.asList('(','[','{').contains(c)){
                characterStack.push(c);
            }else {
                if (characterStack.isEmpty()) {
                    System.out.println("No match");
                    return;
                };

                Character pop = characterStack.pop();
                if ((c == '(' && pop == ')') || (c == '[' && pop == ']') || (c == '{' && pop == '}')){
                    System.out.println("un matched ");
                    return;
                }
            }
        }
        if (characterStack.isEmpty())
        System.out.println("Valid");
        else
            System.out.println("Not valid");

    }

    static class TrieNode {
        TrieNode[] children  = new TrieNode[26];
        boolean isEndOfWord= false;


        public TrieNode get(char character){
            return children[character -'a'];
        }
        public TrieNode get(int index){
            return  children[index];
        }
        public void put (Character character  , TrieNode node){
            children[character -'a'] = node;
        }
        public boolean containsKey(char character){
            return children[character - 'a'] != null;
        }
        public boolean containsKey(int index){
            return children[index] != null;
        }

    }

}
class MyClass extends MainTries {
    int number;
    String text;

    // Constructor with no arguments
    MyClass() {

        this(123, "Default"); // Calls the constructor with two arguments
        super.sayHello();
        System.out.println("No-argument constructor called");
    }

    // Constructor with parameters
    MyClass(int num, String str) {
        number = num;
        text = str;
        System.out.println("Constructor with parameters called");
    }
    MyClass(String str){
        System.out.println("str =" +str);
//        this();
    }
}
