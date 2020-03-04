
import java.io.*;
//import java.util.*;
//import java.text.*;

public class Factorial {

    static int FactorialRecursion(int n) {
        // n is used for factorial n!
        if (n==0) {
            return 1;
        } else {
            return n * FactorialRecursion(n-1);
        }
    };

    static int FactorialRepetition(int n) {
        // n is used for factorial n!

        int num = 1;

        for (int i = 1; i <= n; i++) {

            num = num * i;

        }

        return num;
    };

    public static void main(String[] args) throws IOException {

        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

        int input;

        // Checks if the user has already made an account
        System.out.print("\n\n\n\nEnter the number you want to be factorialised: ");
        input = Integer.parseInt(stdin.readLine());

        System.out.println("\n" + input + "! = " + FactorialRecursion(input));

    };

};