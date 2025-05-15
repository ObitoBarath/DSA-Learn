import java.util.*;

public class ServerLoadOptimizer {
    /*Give an two arrays ,serverCapacity and server load each of the size n ,they represent the resource requirements or capacities of server  and the work load distribution across the serves. the total resource consumption is the sum of  server capcity[i] * servload[i](0<= i<n)


    the task is to rearrange the array server load , distributing the load across the server  to minimize the total resource  consumption  , ensuring their efficient utilisztion . return this optimal arrangement . In scenarios with multiple solution , return the lexiographically array of server load

    sample input

    server capacity  = [7,3,7]
    serverload =3,4,5

    sample output  : 3,5,4*/
    public static List<Integer> minimizeResourceConsumption(List<Integer> serverCapacity, List<Integer> serverLoad) {
        // Step 1: Pair server capacities with their original indices
        int n = serverCapacity.size();
        List<int[]> capacityWithIndex = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            capacityWithIndex.add(new int[]{serverCapacity.get(i), i});
        }

        // Step 2: Sort serverCapacity by capacity and serverLoad by value
        Collections.sort(capacityWithIndex, Comparator.comparingInt(a -> a[0]));
        Collections.sort(serverLoad);

        // Step 3: Rearrange serverLoad optimally
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[capacityWithIndex.get(i)[1]] = serverLoad.get(i);
        }

        // Step 4: Convert result array to a list and return it
        List<Integer> optimizedLoad = new ArrayList<>();
        for (int load : result) {
            optimizedLoad.add(load);
        }
        return optimizedLoad;
    }

    public static void main(String[] args) {
        // Example input
        List<Integer> serverCapacity = Arrays.asList(7, 3, 7);
        List<Integer> serverLoad = Arrays.asList(3, 4, 5);

        // Find the optimal server load arrangement
        List<Integer> optimalLoad = minimizeResourceConsumption(serverCapacity, serverLoad);

        // Print the result
        System.out.println(optimalLoad);
    }
}

