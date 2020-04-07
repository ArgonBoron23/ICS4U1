import java.io.*;
import java.util.*;
import java.text.*;

public class sortingMethods {

    // method to store all the sorted values in the array to a new file
    public static void storeValuesToFile(int[] values, String filename) throws Exception {
        Writer fileout = new FileWriter(filename);
        fileout.write("" + values.length + "\n");
        for (int i = 0; i < values.length; i++) {
            fileout.write("" + values[i] + "\n");
        }
        fileout.close();
    }

    // method to read the unsorted values from a text file into an array
    public static int[] readValuesFromFile(String filename) throws Exception {

        BufferedReader filein = new BufferedReader(new FileReader(filename));
        int numValues = Integer.parseInt(filein.readLine());

        // the first line indicates the amount of values in the file
        int[] values = new int[numValues];

        for (int i = 0; i < numValues; i++) {
            values[i] = Integer.parseInt(filein.readLine());
        }

        filein.close();
        return values;
    }

    // check if the array is sorted
    public static boolean isSorted(int[] values) {

        int arrayLength = values.length;

        // checks every single value and makes sure the next value is greater than the
        // previous
        for (int i = 0; i < arrayLength - 1; i++) {

            if (values[i] > values[i + 1]) {
                return false;

            }
        }
        return true;
    }

    // SO BEGIN THE SORT METHODS___________________________________________________
    // Perform a Bubble Sort on the entire "values" array.
    // The array should be sorted IN PLACE, and in increasing order of the values.
    // The method should return the runtime for the algorithm.
    public static int bubbleSort(int[] values) {

        int temp;
        int arrayLength = values.length;

        // goes through the array once for every single element in it
        for (int j = 1; j <= arrayLength; j++) {

            // sorts one value in the array
            for (int i = 0; i < arrayLength - 1; i++) {

                // checks if the target value is greater than the one after it and switches them
                // if that is the case
                if (values[i] > values[i + 1]) {
                    temp = values[i + 1];
                    values[i + 1] = values[i];
                    values[i] = temp;

                }
            }
        }

        // useless
        return 0;
    }

    // Perform a Selection Sort on the entire "values" array.
    // The array should be sorted IN PLACE, and in increasing order of the values.
    // The method should return the runtime for the algorithm.
    public static int selectionSort(int[] values) {
        int temp;
        int arrayLength = values.length;

        // goes through the array from the highest index down
        for (int j = arrayLength - 1; j >= 0; j--) {

            // sets the top of the index to the current j value (the selection keeps
            // shrinking)
            int upperIndex = j;
            int upperValue = values[j];

            // sorts one number in the array
            for (int i = 0; i <= j - 1; i++) {

                // checks if the i value is greater than the previous highest value
                if (values[i] > upperValue) {

                    // sets the highest index and array to the new greatest value
                    upperIndex = i;
                    upperValue = values[i];

                }
            }

            // checks if the current highest index is not the same as the array's max index
            if (upperIndex != j) {

                // swaps the values of the active value and current highest value
                temp = values[j];
                values[j] = values[upperIndex];
                values[upperIndex] = temp;
            }
        }

        // useless
        return 0;
    }

    // Perform a Merge Sort on a section of the "values" array only from the
    // "startIndex" to the "endIndex".
    // The array should be sorted IN PLACE, and in increasing order of the values.
    // The method should return the runtime for the algorithm.
    private static int mergeSort(int[] values, int low, int high) {

        // makes sure the low index is not greater than the high index of the selection
        if (low < high) {

            // finds the middle index of the selection
            int middle = low + (high - low) / 2;

            // sorts the left side of the selection
            mergeSort(values, low, middle);

            // sorts the right side of the selection
            mergeSort(values, middle + 1, high);

            // combines the two halves
            merge(values, low, middle, high);
        }

        // useless
        return 0;
    }

    // Quick Sort helper method
    private static void merge(int[] values, int low, int middle, int high) {

        // creates a helper array as long as the main array
        int[] helper = new int[values.length];

        // transfers vales to the helper array
        for (int i = low; i <= high; i++) {
            helper[i] = values[i];
        }

        // checking values
        int i = low;
        int j = middle + 1;
        int k = low;

        // checks that i has not reached the middle and j has not reached the end
        while (i <= middle && j <= high) {

            // checks if the lower value is still lower or equal to the mid value
            if (helper[i] <= helper[j]) {

                // sets the value at start of the selection to the lowest value of the selection
                // and increments the low checking index
                values[k] = helper[i];
                i++;

            } else {

                // sets the value at the start of the selection to the middle array value and
                // increments the mid checking index
                values[k] = helper[j];
                j++;
            }

            // increments the lowest checking value
            k++;
        }

        // sets the low sorted value to the low helper value and increments the low
        // checking values all until the middle of the array is incremented to
        while (i <= middle) {
            values[k] = helper[i];
            k++;
            i++;
        }
    }

    // Quick Sort method
    public static int quickSort(int[] values, int low, int high) {

        // calls partition method to obtain a paritition point index
        int partition = partition(values, low, high);

        // makes sure the pivot index is not less than the array's starting index and
        // recurses to sort the items before the partition
        if (partition - 1 > low) {
            quickSort(values, low, partition - 1);
        }

        // makes sure the pivot index is less the array's end index and recurses to sort
        // the items after the partition
        if (partition + 1 < high) {
            quickSort(values, partition + 1, high);
        }

        // useless
        return 0;

    }

    // helper method for Quick Sort to move values around the pivot
    public static int partition(int[] values, int low, int high) {

        // creates a pivot point at the end index of the selection
        int pivot = values[high];

        // creates a variable for the switching value at a place before the lowest index
        int i = (low - 1);

        // counts up from the lowest index of the selection to the index under the end
        // of the selection
        for (int j = low; j < high; j++) {

            // checks if the value is less than the pivot
            if (values[j] < pivot) {

                // if it is, that value is switched with the switch value
                i++;
                int temp = values[i];
                values[i] = values[j];
                values[j] = temp;
            }
        }

        // switches the value after the current switch value with the highest index in
        // the selection
        int temp = values[i + 1];
        values[i + 1] = values[high];
        values[high] = temp;

        // returns the index after the current switch value
        return i + 1;
    }

    public static void main(String[] args) throws Exception {

        // read values from input file
        int[] values = readValuesFromFile("unsorted.txt");

        // Perform a sort, and store the "runtime" of the algorithm
        // int runtime = bubbleSort(values);
        // int runtime = selectionSort(values);
        int runtime = mergeSort(values, 0, values.length - 1);
        // int runtime = quickSort(values, 0, values.length - 1);

        // store the (hopefully) sorted array to an output file
        storeValuesToFile(values, "sorted3.txt");

        // check if the array was properly sorted and give a message to the user via
        // console.
        if (isSorted(values)) {
            System.out.println("The values are sorted!");
        } else {
            System.out.println("The values are NOT sorted.");
        }

    }

}
