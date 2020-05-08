import java.io.*;
import java.util.Stack;

public class BalancedParentheses {

    // Helper to check for opening par.
    public static boolean isOpeningParentheses(char p) {

        if (p == '(' || p == '{' || p == '[') {
            return true;
        }
        return false;
    }

    // Helper to check for closing par.
    public static boolean isClosingParentheses(char p) {

        if (p == ')' || p == '}' || p == ']') {
            return true;
        }
        return false;
    }

    // Helper method to check for matching type
    public static boolean isMatchingType(char opening, char closing) {

        if (opening == '(' && closing == ')')
            return true;

        if (opening == '{' && closing == '}')
            return true;

        if (opening == '[' && closing == ']')
            return true;

        return false;
    }

    public static boolean isBalanced(String userInput) {

        // convert the userInput string to a char[] array
        char[] charArray = userInput.toCharArray();

        // temporary char for opening par. popped off stack
        char temp;

        // create a Stack with generic type Character to hold parentheses
        Stack<Character> parenthesesStack = new Stack<Character>();

        // pushes the array into a stack with many checks
        for (int i = 0; i <= charArray.length - 1; i++) {

            // if the character is an opening bracket, push it onto the stack
            if (isOpeningParentheses(charArray[i])) {

                parenthesesStack.push(charArray[i]);

                // if the character is a closing bracket
            } else if (isClosingParentheses(charArray[i])) {

                if (!parenthesesStack.isEmpty()) {
                    temp = parenthesesStack.pop();

                    if (!isMatchingType(temp, charArray[i])) {
                        return false;
                    }
                } else {

                    return false;
                }

            }

        }
        // after entire array has been parsed, check if there is extra
        if (parenthesesStack.isEmpty()) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) throws IOException {

        // Asks user for expression
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Please enter parentheses expression: ");
        String userInput = stdin.readLine();

        // Output message
        if (isBalanced(userInput)) {
            System.out.println("The parentheses are balanced");
        } else if (!isBalanced(userInput)) {
            System.out.println("The parentheses are not balanced");
        }

    }

}