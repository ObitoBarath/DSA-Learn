package tries;


import java.util.*;
import java.util.stream.Stream;
/*
class TrieNode{

    HashMap<Character , TrieNode> children = new HashMap<>();
    Boolean isEndOfWord;


}
class Trie{
    TrieNode root;

    public Trie(){
        this.root = new TrieNode();
    }


    public void insert(String word){
        TrieNode current = root;
        for (char c : word.toCharArray()){
            current.children.putIfAbsent(c , new TrieNode());
            current = current.children.get(c);
        }
        current.isEndOfWord = true;
    }

    public boolean search(String word){
        TrieNode current = root;

        for (char c : word.toCharArray()){
            if (!current.children.containsKey(c)){
                return false;
            }
            current = current.children.get(c);
        }

        return current.isEndOfWord;
    }

    public boolean startsWith(String prefix){
        TrieNode current = root;

        for (char c: prefix.toCharArray()){
            if (!current.children.containsKey(c)){
                return false;
            }
            current = current.children.get(c);

        }
        return true;


    }
}*/



class TrieNode {

    TrieNode[] children;
    boolean isEndOfWord;

    public TrieNode(){
        this.children = new TrieNode[26];
        this.isEndOfWord = false;
    }

    @Override
    public String toString (){
        return  Arrays.toString(children);
    }


}

class Trie {
    TrieNode root = new TrieNode();

    public void insert(String word){
        TrieNode current = root;
        for (char c : word.toCharArray()){
            if (current.children[c - 'a'] == null){

                TrieNode temp = new TrieNode();

                current.children[c -'a'] = temp;
            }
            current = current.children[ c -'a'];
        }
        current.isEndOfWord = true;

    }
    public boolean search(String word){
        TrieNode current = root;

        for (char c : word.toCharArray()){
            if (current.children[c -'a'] == null){
                return false;
            }
            current  = current.children[c-'a'];
        }
        return  current.isEndOfWord;
    }

    public String searchByPrefix(String word){
        StringBuilder stringBuffer = new StringBuilder();
        TrieNode trieNode = root;
        for (char c : word.toCharArray()) {
            if (trieNode.children[c-'a'] == null){
                return null;
            }else {

                trieNode = trieNode.children[c-'a'];
                stringBuffer.append(c);
            }
        }

       /* if (trieNode.isEndOfWord){
            return  stringBuffer.toString();
        }*/

        return null;
    }

    public List<String> findAllNodes(String prefix){

        List<String> strings = new LinkedList<>();
        StringBuilder stringBuilder = new StringBuilder();

        TrieNode trieNode = root;

        for (char c : prefix.toCharArray()) {

            if (trieNode.children[c -'a'] == null){
                return  strings;
            }
            else {
                stringBuilder.append(c);
                trieNode = trieNode.children[c -'a'];
            }

        }
        dfs(trieNode  , stringBuilder , strings);
        return  strings;

    }

    public void dfs(TrieNode trieNode , StringBuilder stringBuilder , List<String> word){

        if (trieNode.isEndOfWord){
            word.add(stringBuilder.toString());
        }


        for (char c = 'a' ; c <= 'z' ; c++){
            if (trieNode.children[c -'a'] != null){
                stringBuilder.append(c);
                dfs(trieNode.children[c-'a'] , stringBuilder , word);
                stringBuilder.deleteCharAt(stringBuilder.length() -1);
            }
        }
    }

    public void print(){
        StringBuilder stringBuilder = new StringBuilder();
        List<String> strings = new LinkedList<>();
        printHelperUsingDFS(root , stringBuilder , strings);
        strings.forEach(System.out::println);
    }
    public void printHelperUsingDFS (TrieNode trieNode , StringBuilder stringBuilder , List<String> words){
        if (trieNode.isEndOfWord){
            words.add(stringBuilder.toString());
        }

        for (int i = 0 ; i < 26 ; i ++){
            if (trieNode.children[i] != null){
                char ch = (char) (i +'a');
                stringBuilder.append(ch);
                printHelperUsingDFS(trieNode.children[i] , stringBuilder , words);
                stringBuilder.deleteCharAt(stringBuilder.length() -1 );
            }
        }

    }

    public void startsWith(Character prefix){



/*        TrieNodeUsingArray child = current.children[prefix - 'a'];
        System.out.println("child = " + child);*/
    }

}

public class MainTries {

public void sayHello(){
    System.out.println("Hello");
}
    public static void main(String[] args) {
        /*Trie trieNode = new Trie();

        trieNode.insert("hello");
        trieNode.insert("hello");
        trieNode.insert("hello");
        trieNode.insert("hello");
        System.out.println(new TrieNode().children);
//        System.out.println(trieNode.search("hello"));*/

        Trie trie = new Trie();
        trie.insert("hello");
        trie.insert("hell");
        trie.insert("held");
        trie.insert("he");
        trie.insert("hold");
        trie.insert("hero");
//        trie.startsWith('h');
//        System.out.println("Arrays.toString(current.children) = " + Arrays.toString(trie.root));
       trie.print();
        String s = trie.searchByPrefix("he");
        System.out.println("s = " + s);

        String input = "her";
        StringBuilder  stringBuilder = new StringBuilder();

        for (char c : input.toCharArray()) {
            stringBuilder.append(c);
            System.out.println(c+" -->"+trie.findAllNodes(stringBuilder.toString()));
        }

        WeakHashMap<String , String> stringStringWeakHashMap = new WeakHashMap<>();

        stringStringWeakHashMap.put("imran" , "barath");


        String s1 = stringStringWeakHashMap.get("barath");

        System.out.println("s1 = " + s1);
        Stream<Integer> integerStream = Stream.iterate(new int[]{0, 1}, fib -> new int[]{fib[1], fib[0] + fib[1]}).limit(10).map(fib -> fib[0]);

        integerStream.forEachOrdered(System.out::println);

//        System.out.println("find all Nodes = " + trie.findAllNodes("h"));

//        TrieNode hello = trie.search("hello");
//        System.out.println("hello = " + hello);




    }
}
