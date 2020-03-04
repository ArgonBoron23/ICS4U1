
import java.io.*;
//import java.util.*;
//import java.text.*;

public class GreatestCommonDivisor {

    static int EuclidsMethod(int n1, int n2) {

        //Assume n1 > n2
        if ((n1 % n2) == (n2 % n2)) return n2;
        else return EuclidsMethod (n1 % (n2 - 1) , n2 % (n2 - 1));

    }

    public static void main(String[] args) throws IOException {

        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

        int n1, n2, GCD;

        System.out.println(
                "\n\n\n\n\n\n\n\n\n\nEnter two numbers which you want to find the greatest common divisor for.");
        System.out.print("Number 1: ");
        n1 = Integer.parseInt(stdin.readLine());
        System.out.print("Number 2: ");
        n2 = Integer.parseInt(stdin.readLine());


               // Checks which of the two input numbers is greater
               if (n1 > n2) {

               GCD = EuclidsMethod(n1, n2);
                
            } else {
    
                GCD = EuclidsMethod(n2, n1);
    
            }

        System.out.println("The greatest common divisor of " + n1 + " and " + n2 + " is " + GCD);

    }

}