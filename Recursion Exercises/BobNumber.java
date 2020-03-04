
import java.io.*;
//import java.util.*;
//import java.text.*;

public class BobNumber {

    static int Bob(int n) {

        if (n == 1) return 2;
        if (n == 2) return 3;
        else return n * (Bob (n-2) - Bob (n - 1));
    }

    public static void main(String[] args) throws IOException {

        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

        int n;

        //asks for user input
        System.out.print("\n\n\n\n\n\n\nPlease enter the term number to calculate the corresponding Bob Number: ");
        n = Integer.parseInt (stdin.readLine());
        System.out.println ("\nThe Bob Number for term number " + n + " is " + Bob (n));

        

    }

}