package HashTables;

public class HashTables {
    public int size;
    public DataItem[] hashArray;
    public DataItem dummyItem;

    public HashTables() {

    }
    public HashTables(int size){
        this.size = size;
        hashArray = new DataItem[size];
        dummyItem = new DataItem(-1,-1);
    }

    public  class DataItem {

        int key;
        int value;


        public DataItem() {

        }

        public DataItem(int key, int value) {

            this.key = key;
            this.value = value;

        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "DataItem{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    public  int getHashIndex(int key){
        return  key % size;
    }
    public void insert(DataItem item){
        int key = item.getKey();

        //get the hash
        int hashIndex = getHashIndex(key);
        System.out.println("hashIndex = " + hashIndex);
        System.out.println("hashArray = " + hashArray[hashIndex]);
        //move in array until an empty or deleted cell
        while(hashArray[hashIndex] !=null && hashArray[hashIndex].getKey() != -1){
            //go to next cell
            ++hashIndex;
            //wrap around the table
            hashIndex %= size;
        }

        hashArray[hashIndex] = item;
    }

    public void insertItem(int key , int value){
        int hashIndex = getHashIndex(key);
        System.out.println("hashIndex = " + hashIndex);
        System.out.println("hashArray[hashIndex] = " + hashArray[hashIndex]);


        while (hashArray[hashIndex] != null ){
            hashIndex++;

            hashIndex %= size;
        }

        hashArray[hashIndex] = new DataItem();
        hashArray[hashIndex].setKey(key);
        hashArray[hashIndex].setValue(value);

    }

    public void print () {

        for (int i =0  ; i < size ; i ++){
            if (hashArray[i] != null){
                System.out.println( " { "+hashArray[i].getKey() + " = "+ hashArray[i].getValue() +" } ");
            }
        }
    }

    public void display(){
        for(int i=0; i<size; i++) {
            if(hashArray[i] != null)
                System.out.print(" ("
                        +hashArray[i].getKey()+","
                        +hashArray[i].getValue() + ") ");
            else
                System.out.print(" ~~ ");
        }
        System.out.println("");
    }


    public DataItem get(int key){
        int hashIndex = getHashIndex(key);

        if (hashArray[hashIndex] != null && hashArray[hashIndex].getKey() == key){
            return hashArray[hashIndex];
        }

        while (hashArray[hashIndex] != null ){

            if (hashArray[hashIndex].getKey() == key){
                return hashArray[hashIndex];

            }
            hashIndex ++;
            hashIndex %= size;
        }

        return  null;
    }

    public void main(String[] args) {
        HashTables hashTables = new HashTables(10);
        hashTables.insert(new DataItem(3,1));

//        hashTables.insert(new DataItem(3,4));
//        hashTables.insert(new DataItem(3,4));
        hashTables.insertItem(1,4);
        hashTables.insertItem(1,4);
        hashTables.insertItem(1,4);
        hashTables.insertItem(1,4);
        hashTables.insertItem(1,4);
        hashTables.insertItem(1,4);
        hashTables.insertItem(1,4);
        hashTables.insertItem(1,4);
        hashTables.insert(new DataItem(3,2));
        hashTables.insert(new DataItem(3,2));
//        hashTables.print();
        System.out.println("hashTables = " + hashTables.get(1));
        hashTables.display();
//        System.out.println("hashTables = " + hashTables.hashArray[0]);

    }
}
