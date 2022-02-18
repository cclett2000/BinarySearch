/*
Charles Lett Jr.
February 18, 2022
Desc: program performs a binary search on a given array
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    /* TOTALLY HELPFUL COMMENT
        > Inner Me: So, why did put this out here. Do you even know what this does?
        > Me: Dunno, don't care, coffee.
     */

    static int key = 712;

    public static void main (String[] args) throws FileNotFoundException {
        long runtime_start = System.currentTimeMillis();

        // data storage
        int[] numbers = new int[10];

        // initializers
        File file = new File("sample_10.txt");
        SearchTools.BinarySearchINT BS_int = new SearchTools.BinarySearchINT();
        Scanner reader = new Scanner(file);

        // array fill
        int i = 0;
        while(reader.hasNextLine()){
            numbers[i] = Integer.parseInt(reader.nextLine());
            i++;
        }

        // execute program
        System.out.println(">>> Array to search: " + Arrays.toString(numbers) + "\n>>> Looking for " + key);
        BS_int.run(numbers, key);


        // post-processing - runtime & memory usage
        DecimalFormat f = new DecimalFormat("#.00");
        double used_mem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        long runtime_end = System.currentTimeMillis() - runtime_start;
        System.out.println("\n>>> Runtime: " + runtime_end + " ms");
        System.out.println(">>> Memory Usage: " + f.format(used_mem / Math.pow(10, 6)) + " MB");
    }
}
