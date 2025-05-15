package HashTables;

import java.util.LinkedList;
import java.util.Map;

public class Hashing<K, V>
{
    public LinkedList<Entry<K, V>>[] buckets;
    public static int size;

    public Hashing(int capacity) {


        buckets = new LinkedList[capacity];
        size = 0;
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    public int hashIndex(K key) {
        int hashedCode = key.hashCode();
        System.out.println("hashedCode = " + hashedCode);
        return Math.abs(hashedCode) % buckets.length;
    }

    public V remove(K key){
        int i = hashIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets[i];

        for (Entry<K,V> b : bucket) {
                if (b.getKey().equals(key)){
                    V value = b.getValue();
                    bucket.remove(value);
                    size --;
                    return value;
                }
        }

        return null;
    }

    public void put(K key, V value) {

        int hashedIndex = hashIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets[hashedIndex];

        for (Entry<K ,V> buc : bucket){
            if (buc.getKey() == key){
                buc.setValue(value);
                return;
            }
        }
        bucket.push(new Entry<K, V>(key , value));
        size++;

    }


    private static class Entry<K, V> {
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }


    public static   void main(String[] args) {
        Hashing<String,String> stringStringHashing  = new Hashing<String, String>(10);
        stringStringHashing.put("a" , "b");
        String a = stringStringHashing.remove("a");

        System.out.println("a = " + a);
    }


}
