package HashTables;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class HashingBasics {
    //Hash Table
    //Hash Map
    //LinkedHashMap
    //Concurrent Hash Map

    public static void hashTable() {

        Hashtable<Integer , String> integerStringHashtable = new Hashtable<>();
        integerStringHashtable.put(1, "a");
        integerStringHashtable.put(3, "c");
        integerStringHashtable.put(6, "f");
        integerStringHashtable.put(2, "b");
        integerStringHashtable.put(5, "e");
        integerStringHashtable.put(4, "d");

        System.out.println("Original: " + integerStringHashtable);

        // Adding more entries to break any apparent order
        integerStringHashtable.put(8, "h");
        integerStringHashtable.put(7, "g");
        integerStringHashtable.put(9, "i");

        System.out.println("Modified: " + integerStringHashtable);
    }

    public static void hashMap(){

        int[] array = new int[]{1,2,1,12,3,4,12,3,12,12,12,12,12};
        HashMap<Integer , Integer> stringStringHashMap = new HashMap<>();

        for (int  i = 0 ;  i< array.length  ; i ++){
            if (stringStringHashMap.get(array[i]) == null){
                stringStringHashMap.put(array[i] , 1);
            }else {
                Integer value = stringStringHashMap.get(array[i]);
                stringStringHashMap.put(array[i] , ++value);
            }
        }
        System.out.println("stringStringHashMap = " + stringStringHashMap);
    }


    public static void main(String[] args) {
//        hashTable();
        hashMap();
    }
}
