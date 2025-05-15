package Graph;



import java.util.*;

class Node {
    char character;

    public Node(char character) {
        this.character = character;
    }

}

class Graph {
    ArrayList<Node> nodes;
    int[][] matrix;

    public Graph(int size) {
        this.matrix = new int[size][size];
    }

    public void addNode(Node node) {
        nodes.add(node);
    }

    public void addEdge(int src, int dest) {
        matrix[src][dest] = 1;
    }

    public boolean checkEdgeIsPresent(int src, int dest) {
        return matrix[src][dest] == 1;
    }

    public void print() {


        for (Node node : nodes) {
            System.out.print(node);
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int i1 = 0; i1 < matrix[i].length; i1++) {
                System.out.print(matrix[i][i1] + " ");
            }
            System.out.println();
        }
    }

}


public class MainGraph {

    public void addEdge(int[][] matrix , int start , int end) {
            matrix[start][end] = 1;
    }
    public  void addEdge(int[][] matrix , int from , int to  , int weight){
        matrix[from][to] = weight;
    }
    public void print(int[][] matrix){

        for (int[] mat : matrix){
            for (int m : mat){
                System.out.print(m + " ");
            }
            System.out.println();
        }

    }

    public void addAdjacencyList(List<List<Integer>> adjacency , int u , int v){

            adjacency.get(u).add(v);
    }
    public void printAdjacencyList(List<List<Integer>> adjacency){
        for (int i = 0; i < adjacency.size(); i++) {
            System.out.print(i +" --> ");
            for (int j : adjacency.get(i)){
                System.out.print(j  + " ");
            }
            System.out.println();
        }

    }

    public void addAdjacencyListWithWeight(List<List<AbstractMap.SimpleEntry<Integer , Integer>>>  adjacency  , int u , int v , int weight){
        adjacency.get(u).add(new AbstractMap.SimpleEntry<>(v , weight));
    }

    public void printAdjacencyListWithWeight(List<List<AbstractMap.SimpleEntry<Integer,Integer>>> adjacency ){
        for (int i = 0; i < adjacency.size(); i++) {
            System.out.print(i + ": ");
            for (AbstractMap.SimpleEntry<Integer, Integer> j : adjacency.get(i)) {
                System.out.print("{" + j.getKey() + ", " + j.getValue() + "} ");
            }
            System.out.println();
        }

    }
    public static void main(String[] args) {
        MainGraph graph = new MainGraph();
       /* int V = 4;
        int[][] matrix = new int[V][V];


        mainGraph.addEdge(matrix , 0 ,1 , 10);
        mainGraph.addEdge(matrix , 1 ,0 , 1);
        mainGraph.addEdge(matrix , 1 ,2 , 2);
        mainGraph.addEdge(matrix , 2 ,1,3);
        mainGraph.addEdge(matrix , 2 ,3,4);
        mainGraph.addEdge(matrix , 3 ,2,5);

        mainGraph.print(matrix);*/

        Integer V = 3;
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        graph.addAdjacencyList(adjacencyList , 1 , 1);
        graph.addAdjacencyList(adjacencyList , 1 , 2);
        graph.addAdjacencyList(adjacencyList , 1 , 3);
        graph.addAdjacencyList(adjacencyList , 1 , 4);
        graph.addAdjacencyList(adjacencyList , 1 , 5);
        graph.addAdjacencyList(adjacencyList , 2 , 1);
        graph.printAdjacencyList(adjacencyList);


        List<List<AbstractMap.SimpleEntry<Integer,Integer>>> adjacencyListWithWeight = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            adjacencyListWithWeight.add(new ArrayList<>());
        }


        graph.addAdjacencyListWithWeight(adjacencyListWithWeight,2,10 , 10);
        graph.addAdjacencyListWithWeight(adjacencyListWithWeight,2,11 , 10);
        graph.addAdjacencyListWithWeight(adjacencyListWithWeight,2,12 , 10);
        graph.addAdjacencyListWithWeight(adjacencyListWithWeight,2,13 , 10);
        graph.addAdjacencyListWithWeight(adjacencyListWithWeight,2,14 , 10);
        graph.printAdjacencyListWithWeight(adjacencyListWithWeight);



      /*  Map<String, List<String>> adjacencyList = new HashMap<>();

        graph.addAdjacencyList(adjacencyList , "A" , "B");
        graph.addAdjacencyList(adjacencyList , "A" , "C");
        graph.addAdjacencyList(adjacencyList , "B" , "D");
        graph.addAdjacencyList(adjacencyList , "B" , "E");
        graph.addAdjacencyList(adjacencyList , "C" , "F");
        graph.addAdjacencyList(adjacencyList , "D" , null);
        graph.addAdjacencyList(adjacencyList , "E" , "F");
        graph.addAdjacencyList(adjacencyList , "F" , null);
//        graph.DFSUsingStackForAdjacencyList("A" , adjacencyList);



        int[][] adjMatrix = {
                {0, 1, 1, 0, 0, 0}, // A
                {0, 0, 0, 1, 1, 0}, // B
                {0, 0, 0, 0, 0, 1}, // C
                {0, 0, 0, 0, 0, 0}, // D
                {0, 0, 0, 0, 0, 1}, // E
                {0, 0, 0, 0, 0, 0}  // F
        };
//        graph.DFSUsingStackForAdjacencyMatrix(0 , adjMatrix);

        ArrayList<String> strings = new ArrayList<>();
        strings.add("A");
        strings.add("B");
        strings.add("C");
        strings.add("D");

//        A--> B --> c

        int[][] matrix = {
                {0 ,1 ,0},
                {0 ,0 ,1},
                {0 ,1 ,0},

        };


        graph.BFSUsingAdjacencyMatrix(0 ,matrix , strings);
*/
    }


    public  void addAdjacencyList(Map<String, List<String>> adjacencyList , String u , String v){


        adjacencyList.putIfAbsent(u , new ArrayList<>());
        if (v != null){
            adjacencyList.get(u).add(v);
        }

    }


    public void DFSUsingStackForAdjacencyMatrix(Integer start , int[][] adjMatrix){

        Stack<Integer> stack = new Stack<>();
        Set<Integer>  visited = new HashSet<>();

        stack.push(start);

        while (!stack.isEmpty()){
            Integer pop = stack.pop();
            if (!visited.contains(pop)){
                visited.add(pop);
                System.out.print(pop+" ");

                for (int neighbor = adjMatrix.length - 1; neighbor >= 0; neighbor--) {
                    if (adjMatrix[pop][neighbor] == 1 && !visited.contains(neighbor)) {
                        stack.push(neighbor);
                    }
                }
            }
        }




    }

    public void DFSUsingStackForAdjacencyList(String start, Map<String , List<String>> adjList){
        Stack<String> stack = new Stack<>();
        Set<String> visited = new HashSet<>();


        stack.add(start);
        while (!stack.empty()){
            String node = stack.pop();

            if (!visited.contains(node)){
                visited.add(node);
                System.out.print(node + " ");
                List<String> neighbours =  adjList.getOrDefault(node , new LinkedList<>());


                for (int i = neighbours.size() -1 ; i >=0 ; i --){
                    stack.push(neighbours.get(i));
                }


            }
        }

    }

    public void BFSUsingAdjacencyMatrix(Integer start , int[][] adjacencyMatrix , ArrayList<String> nodes){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[adjacencyMatrix.length];

        queue.offer(start);

        visited[start] = true;

        while (!queue.isEmpty()){
            Integer poll = queue.poll();

            System.out.print(nodes.get(poll) + " ");

            for (int i = 0; i < adjacencyMatrix[start].length; i++) {
                if (adjacencyMatrix[start][i] ==1 && !visited[i]){
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }

    }
}
