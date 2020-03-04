
import java.io.*;
//import java.util.*;
//import java.text.*;

public class Palindrome {

    static boolean isPalindrome(String word) {

        int length = word.length();
        
        if (length <= 1)
            return true;

        if ((word.charAt(0) == word.charAt(length - 1))) {

            String newWord = word.substring(1, length-1);
            return isPalindrome(newWord);
        } else
            return false;

    }

    public static void main(String[] args) throws IOException {

        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

        String word;

        // asks for user input
        System.out.print("\n\n\n\n\n\n\nPlease enter a word to check if it is a palindrome: ");
        word = stdin.readLine();

        if (isPalindrome(word))
            System.out.println("\n The word " + word + " is a palindrome");
        else
            System.out.println("\n The word " + word + " is not a palindrome");
    }

}