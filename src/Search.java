public class Search {

    public void linearSearch() {
        int[] array = {1, 25, 6, 8, 12, 34, 6};
        int target = 12;
        for (int arrayElements : array) {
            if (arrayElements == target) {
                System.out.println("arrayElements = " + arrayElements);
                return;
            }
        }
        System.out.println(" = Element not found = "  );
    }

    public void binarySearch(){
        int[] array = {1, 6, 8, 12,25, 34};
        int target = 1;

        int start = 0;
        int end = array.length -1;
        System.out.println("array.length = " + array.length);
        while (start <= end){
            int mid = (start + end) / 2;
            System.out.println("mid = " + mid);
            System.out.println("array[mid] = " + array[mid]);
            if (target == array[mid]){
                System.out.println(" Element found in index "+ mid );
                return;
            }else if (target >  array[mid]){
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        System.out.println(" No element found= " );

    }

    public void main(String[] args) {
//            linearSearch();
        binarySearch();
    }


}
