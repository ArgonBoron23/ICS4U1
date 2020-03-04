import java.io.*;
import java.util.*;

public class Search {

    public static int arrayLookups; // variable to count how many times a value was called from the arry

    // Linear search method
    public static int linearSearch(int number, int[] values) {

        for (int i = 0; i < values.length; i++) {
            if (values[i] == number)
                return i;
            arrayLookups++;
        }
        return -1;
    }

    // Binary search method
    public static int binarySearch(int number, int startIndex, int endIndex, int[] values) {

        if (startIndex <= endIndex) {
            int mid = startIndex + (endIndex - startIndex) / 2;

            int midNum = values[mid];
            arrayLookups++;

            if (midNum == number)
                return mid;

            if (midNum < number)
                return binarySearch(number, mid + 1, endIndex, values);

            return binarySearch(number, startIndex, mid - 1, values);
        }
        return -1;
    }

    public static int interpolationSearch(int number, int startIndex, int endIndex, int[] values) {

        int startNum = values[startIndex];
        arrayLookups++;

        int endNum = values[endIndex];
        arrayLookups++;

        if (startIndex <= endIndex) {

            int mid = (int) (startIndex + ((0.0 + number - startNum) / (endNum - startNum) * (endIndex - startIndex)));

            int midNum = values[mid];
            arrayLookups++;

            if (startNum == endNum)
                return startIndex;

            if (midNum == number)
                return mid;

            if (midNum < number)
                return interpolationSearch(number, mid + 1, endIndex, values);

            return interpolationSearch(number, startIndex, mid - 1, values);
        }

        return -1;

    }

    public static void main(String[] args) throws Exception {

        int loopRuns = 100; // the amount of times the testing loop should run
        int randNum; // the random number to search for
        int totalLinSearch = 0, totalBinSearch = 0, totalIntSearch = 0;

        BufferedReader reader = new BufferedReader(new FileReader("sorted2.txt")); // new file reader
        int arrayLength = Integer.parseInt(reader.readLine()); // reads first value (lengths of the array)
        String line; // variable for the text on each line of the file
        int[] values = new int[arrayLength]; // new array of integers for the array

        // loop to send all the values in the text file to an array
        for (int i = 0; i < arrayLength; i++) {
            line = reader.readLine();
            values[i] = Integer.parseInt(line);
        }
        reader.close();

        int avgLinSearch, avgBinSearch, avgIntSearch;
        int minLinSearch = arrayLength, minBinSearch = arrayLength, minIntSearch = arrayLength;
        int maxLinSearch = 1, maxBinSearch = 1, maxIntSearch = 1;

        for (int j = 0; j < loopRuns; j++) {

            Random rand = new Random();
            randNum = values[rand.nextInt(arrayLength)];

            arrayLookups = 0;
            linearSearch(randNum, values);
            totalLinSearch += arrayLookups;
            
            if (arrayLookups < minLinSearch)
                minLinSearch = arrayLookups;

            if (arrayLookups > maxLinSearch)
                maxLinSearch = arrayLookups;

            arrayLookups = 0;
            binarySearch(randNum, 0, values.length - 1, values);
            totalBinSearch += arrayLookups;
            if (arrayLookups < minBinSearch)
                minBinSearch = arrayLookups;
            if (arrayLookups > maxBinSearch)
                maxBinSearch = arrayLookups;

            arrayLookups = 0;
            interpolationSearch(randNum, 0, values.length - 1, values);
            totalIntSearch += arrayLookups;
            if (arrayLookups < minIntSearch)
                minIntSearch = arrayLookups;
            if (arrayLookups > maxIntSearch)
                maxIntSearch = arrayLookups;

        }

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