import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class EvaluatePostfix {

	// returns true if parameter c is one of: +, -, *, /
	public static boolean isOperator(char c) {
		if (c == '+' || c == '-' || c == '*' || c == '/') {
			return true;
		}

		return false;
	}

	// returns true if parameter c is in the range from '0' to '9'.
	// note that in ASCII, '0' comes before '1'
	public static boolean isOperand(char c) {

		if (c >= '0' && c <= '9') {
			return true;
		}

		return false;
	}

	// perform the operation with infix notation: <operand1> <operator> <operand2>
	// for example, performOperation('-','5','2') will perform "5 - 2" and return 3.
	public static Double performOperation(char operator, Double operand1, Double operand2) {

		double op1 = operand1.doubleValue(), op2 = operand2.doubleValue();

		if (operator == '+') {
			return op1 + op2;
		} else if (operator == '-') {
			return op1 - op2;
		} else if (operator == '*') {
			return op1 * op2;
		} else if (operator == '/') {
			return op1 / op2;
		}
		return null;
	}

	// main method
	public static void main(String[] args) throws IOException {

		// ask user for a postfix expression
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Please enter your postfix expression: ");
		String userInput = stdin.readLine();

		// convert the userInput string to a char[] array
		char[] charArray = userInput.toCharArray();

		// create a Stack with generic type Double to hold operands and intermediate
		// calculations
		Stack<Double> myStack = new Stack<Double>();

		// ADD CODE BELOW THIS LINE TO PERFORM THE OPERATIONS AS DESCRIBED IN VIDEO.
		// BY THE END OF THE CODE, THE STACK SHOULD ONLY HAVE ONE DOUBLE OBJECT IN IT

		double op1, op2, result;

		for (int i = 0; i <= charArray.length - 1; i++) {

			if (isOperand(charArray[i])) {

				myStack.push((double)Character.getNumericValue(charArray[i]));

			} else if (isOperator(charArray[i])) {

				op2 = myStack.pop();
				op1 = myStack.pop();
				result = performOperation(charArray[i], op1, op2);
				myStack.push(result);
			}

		}

		// output the finalAnswer to the user
		System.out.println("The expression evaluates to: " + myStack.pop());

	}

}
