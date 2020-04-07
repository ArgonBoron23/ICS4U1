import java.io.*;
import java.util.*;

public class Search {

    public static int arrayLookups; // variable to count how many times a value was called from the arry

    // Linear search method
    public static int linearSearch(int number, int[] values) {

        for (int i = 0; i < values.length; i++) { // for loop to check each number in the array
            if (values[i] == number) // checks if number is equal to target
                return i; // returns index if true
            arrayLookups++; // increments lookups counter
        }
        return -1; // returns -1 if number is not found
    }

    // Binary search method
    public static int binarySearch(int number, int startIndex, int endIndex, int[] values) {

        if (startIndex <= endIndex) { // checks if start index is end index
            int mid = startIndex + (endIndex - startIndex) / 2; // takes the middle of the current dataset

            int midNum = values[mid]; // sets middle number to that in the array
            arrayLookups++; // increments lookups counter

            if (midNum == number) // checks if middle number is the target
                return mid;

            if (midNum < number) // checks if the middle number is less than the target
                return binarySearch(number, mid + 1, endIndex, values); // snips off the left half of array if true

            return binarySearch(number, startIndex, mid - 1, values); // snips off the right half off arry of false
        }
        return -1; // returns -1 if number is not found
    }

    public static int interpolationSearch(int number, int startIndex, int endIndex, int[] values) {

        int startNum = values[startIndex]; // sets a variable to the starting value of the dataset
        arrayLookups++; // increments lookups counter

        int endNum = values[endIndex]; // sets a variable to the ending value of the dataset
        arrayLookups++; // increments lookups counter

        if (startIndex <= endIndex) { // checks if start index is still less than last one

            int mid = (int) (startIndex + ((0.0 + number - startNum) / (endNum - startNum) * (endIndex - startIndex))); // calculates
                                                                                                                        // 'middle'
                                                                                                                        // index
                                                                                                                        // of
                                                                                                                        // dataset
                                                                                                                        // using
                                                                                                                        // proportional
                                                                                                                        // system

            int midNum = values[mid]; // sets a variable to middle index value
            arrayLookups++; // increments lookups counter

            if (startNum == endNum) // checks if the array is one index long and if the values are the same
                return startIndex;

            if (midNum == number) // checks if the mid number is dead on the target
                return mid;

            if (midNum < number) // checks if the mid number is less than the target
                return interpolationSearch(number, mid + 1, endIndex, values); // snips off the left part of dataset

            return interpolationSearch(number, startIndex, mid - 1, values); // snips off the right part of dataset
        }

        return -1; // returns -1 if number is not found

    }

    public static void main(String[] args) throws Exception {

        int loopRuns = 100; // the amount of times the testing loop should run
        int randNum; // the random number to search for
        int totalLinSearch = 0, totalBinSearch = 0, totalIntSearch = 0; // declares total array lookups made

        //opens a new file reader and reads the first value of the array as the array length
        BufferedReader reader = new BufferedReader(new FileReader("sorted2.txt"));
        int arrayLength = Integer.parseInt(reader.readLine());
        String line;

        int[] values = new int[arrayLength]; // new array of integers for the array

        // loop to send all the values in the text file to an array
        for (int i = 0; i < arrayLength; i++) {
            line = reader.readLine();
            values[i] = Integer.parseInt(line);
        }
        reader.close();

        int avgLinSearch, avgBinSearch, avgIntSearch; // declares average searches for each search
        int minLinSearch = arrayLength, minBinSearch = arrayLength, minIntSearch = arrayLength; // declares and
                                                                                                // initialises minimum
                                                                                                // amount of searches
                                                                                                // for each search
        int maxLinSearch = 1, maxBinSearch = 1, maxIntSearch = 1; // delcares and initialises maximum amount of searches
                                                                  // for each search

        for (int j = 0; j < loopRuns; j++) { // loops test a certain amount of times

            Random rand = new Random(); // random number generator setup
            randNum = values[rand.nextInt(arrayLength)]; // generates a random number from the dataset

            // performs linear search on random number and tracks total, mimimum, and
            // maximum lookups
            arrayLookups = 0;
            linearSearch(randNum, values);
            totalLinSearch += arrayLookups;

            if (arrayLookups < minLinSearch)
                minLinSearch = arrayLookups;

            if (arrayLookups > maxLinSearch)
                maxLinSearch = arrayLookups;

            // performs binary search on random number and tracks total, mimimum, and
            // maximum lookups
            arrayLookups = 0;
            binarySearch(randNum, 0, values.length - 1, values);
            totalBinSearch += arrayLookups;

            if (arrayLookups < minBinSearch)
                minBinSearch = arrayLookups;

            if (arrayLookups > maxBinSearch)
                maxBinSearch = arrayLookups;

            // performs interpolation search on random number and tracks total, mimimum, and
            // maximum lookups
            arrayLookups = 0;
            interpolationSearch(randNum, 0, values.length - 1, values);
            totalIntSearch += arrayLookups;

            if (arrayLookups < minIntSearch)
                minIntSearch = arrayLookups;

            if (arrayLookups > maxIntSearch)
                maxIntSearch = arrayLookups;

        }

        // calculates average amount of lookups made for each search type
        avgLinSearch = totalLinSearch / loopRuns;
        avgBinSearch = totalBinSearch / loopRuns;
        avgIntSearch = totalIntSearch / loopRuns;

        System.out.println("\n\nAfter searching for 100 values, the following lookups were made:");

        System.out.println("\n|Linear Search|\n\tAverage lookups: " + avgLinSearch + "\n\tMinimum lookups: "
                + minLinSearch + "\n\tMaximum lookups: " + maxLinSearch);
        System.out.println("\n|Binary Search|\n\tAverage lookups: " + avgBinSearch + "\n\tMinimum lookups: "
                + minBinSearch + "\n\tMaximum lookups: " + maxBinSearch);
        System.out.println("\n|Interpolation Search|\n\tAverage lookups: " + avgIntSearch + "\n\tMinimum lookups: "
                + minIntSearch + "\n\tMaximum lookups: " + maxIntSearch);

        System.out.println("\n");

    }

}