
import java.io.*;
//import java.util.*;
//import java.text.*;

public class Power {

    static int Powers(int base, int exponent) {

    if (exponent == 0) return 1;
    else return base * Powers (base, exponent - 1);

    }

    public static void main(String[] args) throws IOException {

        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

        int base, exponent;

        System.out.print ("\n\n\n\n\n\nEnter the base of the power: ");
        base = Integer.parseInt(stdin.readLine ());

        System.out.print ("Enter the exponent of the power: ");
        exponent = Integer.parseInt(stdin.readLine ());

        System.out.println ("\n" + base + "^" + exponent + " = " + Powers(base,exponent));

    }

}