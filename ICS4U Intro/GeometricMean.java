import java.io.*;
import java.util.*;
import java.text.*;


public class GeometricMean {

    public static void main(String[] args) throws IOException {

    BufferedReader stdin = new BufferedReader (new InputStreamReader (System.in));

        // single-slot variables
        int n = 0, recipn;
        String exit = null, nString;

        // array of all the inputted values
        int[] nums = new int[255];

        System.out.println("Enter as many numbers as you would like. Enter 'x' to stop entering numbers");

        do {

            System.out.print("Enter a number: ");
            nString = stdin.readLine ();

            if (exit.equals("x")) {
                break;
            }

        } while (1 == 1);

        nums[0] = 5;

        System.out.print("testing testing");
    }

}