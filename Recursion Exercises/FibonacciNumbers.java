
import java.io.*;
//import java.util.*;
//import java.text.*;

public class FibonacciNumbers {

    static int Fibonacci(int n) {
        if (n==1) return 0;
        else if (n==2) return 1;
        else return (Fibonacci (n-1) + Fibonacci(n-2));
    }

    public static void main(String[] args) throws IOException {

        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

        int n;

        System.out.print("\n\n\n\n\n\n\nPlease enter the Fibonacci number's term number you would would like to calculate: ");
        n = Integer.parseInt (stdin.readLine());

        System.out.println ("\nThe Fibonacci number with term number " + n + " is " + Fibonacci(n));

    }

}