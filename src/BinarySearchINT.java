package SearchTools;

import java.util.ArrayList;
import java.util.Arrays;

public class BinarySearchINT {
    private boolean enable_debug = false;

    // execute method
    public void run(int[] array, int key){
        array = b_sort(array);
        b_disp(array, key);
    }

    // sorter; uses insertion sort
    // BS only works if the array of numbers is sorted
    private int[] b_sort(int[] array){
        // insertion sort algorithm altered to work with array
        //  > link: https://github.com/cclett2000/insertion_sort/blob/master/src/HM_sort.java

        int i = 0;  // position
        int key;    // curr val

        System.out.println("\t> Sorting Array...");

        if(enable_debug){
            System.out.println("\t\t- Array Before Sort: " + Arrays.toString(array));
        }

        for (int j = 1; j < array.length; j++) {
            key = array[j];

            i = j - 1;

            //shift value if true; val > key
            while (i >= 0 && array[i] > key) {
                // replace ind + 1 with ind in hashmap
                // TODO: read more into how insertion sort works
                array[i + 1] = array[i];

                // decrement i
                i = i - 1;
            }

            // replace i + 1 with current val held in key
            array[i + 1] = key;
        }

        if(enable_debug){
            System.out.println("\t\t- Array After Sort: " + Arrays.toString(array));
        }

        System.out.println("\t> Sorting Done!\n");

        return array;
    }

    private int b_search(int[] num_array, int key){
        int keyIndex = -1;      // default = -1; key not found
        int mid = 0;
        int low = 0;
        int high = num_array.length - 1;

        System.out.println("\t> Beginning Search...");

        while (high >= low) {
            if (enable_debug) {
                System.out.println(
                        "\t\tKey: " + key
                                + " -> Low: " + low
                                + " | Mid: " + mid
                                + " | High: " + high
                );
            }

            mid = (high + low) / 2;                             // mid point; where to search

            if (num_array[mid] < key) low = mid + 1;            // go back if key < mid
            else if (num_array[mid] > key) high = mid - 1;      // go forward if key > mid

            else return keyIndex = mid;                         // if key found; set keyIndex to mid
        }

        return keyIndex;
    }

    private void b_disp(int[] array, int key){
        int keyIndex = b_search(array, key);

        if (keyIndex == -1){
            System.out.println("\t\t- Number does not exist within this array.");
            System.out.println("\t> Searching Finished!");
        }

        else{
            System.out.println("\t\t- Number found! -> Index = " + keyIndex);
            System.out.println("\t> Searching Finished!");
        }
    }
}
