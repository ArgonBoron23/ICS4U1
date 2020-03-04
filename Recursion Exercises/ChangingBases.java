
import java.io.*;
//import java.util.*;
//import java.text.*;

public class ChangingBases {

    static int binToDec(int binNum) {

        if (binNum == 0)
            return 0;
        else
            return (2 * binToDec(binNum / 10) + binNum % 10);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

        int binNum;

        System.out.print("\n\n\n\n\n\nEnter a binary number to convert it to a decimal: ");
        binNum = Integer.parseInt(stdin.readLine());

        System.out.println("\nThe decimal equivalent of " + binNum + " is " + binToDec(binNum));

    }

}