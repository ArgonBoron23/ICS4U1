import java.util.Stack;

public class InfixEvaluation {

    public int evaluate(String expression) {
        // Stack for Numbers
        Stack<Integer> numbers = new Stack<>();

        // Stack for operators
        Stack<Character> operations = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            // check if it is number
            if (Character.isDigit(c)) {
                // Entry is Digit, it could be greater than one digit number
                int num = 0;
                while (Character.isDigit(c)) {
                    num = num * 10 + (c - '0');
                    i++;
                    if (i < expression.length())
                        c = expression.charAt(i);
                    else
                        break;
                }
                i--;
                // push it into stack
                numbers.push(num); // AUTOBOXING
            } else if (c == '(') {
                // push it to operators stack
                operations.push(c); // AUTOBOXING
            }
            // Closed brace, evaluate the entire brace
            else if (c == ')') {
                while (operations.peek() != '(') { // UNBOXING
                    int output = performOperation(numbers, operations);
                    // push it back to stack
                    numbers.push(output); // AUTOBOXING
                }
                operations.pop();
            }
            // current character is operator
            else if (isOperator(c)) {
                // 1. If current operator has higher precedence than operator on top of the
                // stack,
                // the current operator can be placed in stack
                // 2. else keep popping operator from stack and perform the operation in numbers
                // stack till
                // either stack is not empty or current operator has higher precedence than
                // operator on top of the stack
                while (!operations.isEmpty() && precedence(c) <= precedence(operations.peek())) { // UNBOXING
                    int output = performOperation(numbers, operations);
                    // push it back to stack
                    numbers.push(output); // AUTOBOXING
                }
                // now push the current operator to stack
                operations.push(c); // AUTOBOXING
            }
        }
        // If here means entire expression has been processed,
        // Perform the remaining operations in stack to the numbers stack

        while (!operations.isEmpty()) {
            int output = performOperation(numbers, operations);
            // push it back to stack
            numbers.push(output); // AUTOBOXING
        }
        return numbers.pop(); // UNBOXING
    }

    static int precedence(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    public int performOperation(Stack<Integer> numbers, Stack<Character> operations) {
        int a = numbers.pop(); // UNBOXING
        int b = numbers.pop(); // UNBOXING
        char operation = operations.pop(); // UNBOXING
        switch (operation) {
            case '+':
                return a + b;
            case '-':
                return b - a;
            case '*':
                return a * b;
            case '/':
                if (a == 0)
                    throw new UnsupportedOperationException("Cannot divide by zero");
                return b / a;

            case '^':
                if (a == 0 && b == 0)
                    throw new UnsupportedOperationException("Cannot raise zero to an exponent of zero");
                return (int) Math.pow(b, a);
        }
        return 0;
    }

    public boolean isOperator(char c) {
        return (c == '+' || c == '-' || c == '/' || c == '*' || c == '^');
    }

    public static void main(String[] args) {

        String infixExpression = "2*(5*(3^2))/(4^3-49)-2";
        InfixEvaluation i = new InfixEvaluation();
        System.out.println("\nSolution: " + infixExpression + " = " + i.evaluate(infixExpression));
    }
}