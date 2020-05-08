import java.io.*;
import java.util.LinkedList;

public class CalculatingProfit {

    // Method to display command list
    public static void printHelp() {
        // Prints usage instructions
        System.out.println(
                "\nCommands are as follows: \nbuy quantity price (i.e. buy 50 40)\nsell quantity price (i.e. sell 20 30)\nquit (quits the program)\nhelp (show this list)\n");
    }

    // Method to buy stock
    public static void buyStock(LinkedList<Integer> stock, int quantity, int price) {

        // Adds purchases onto queue
        for (int i = 1; i <= quantity; i++) {
            stock.add(price);
        }

        // Tells user what was purchased
        System.out.println("You have purchased " + quantity + " units at $" + price + " each");

    }

    // Method to sell stock
    public static void sellStock(LinkedList<Integer> stock, int quantity, int price, int[] totalProfit) {

        int profit = 0;

        for (int i = 1; i <= quantity; i++) {

            // Adds profit from item onto total profit
            profit += price - stock.remove();

        }

        // Adds profit made this sale to total
        totalProfit[0] += profit;

        // Tells the user how much profit they made
        if (profit < 0) {

            System.out.println("By selling these items, you LOST $" + -1 * profit);

        } else {

            System.out.println("By selling these items, you GAINED $" + profit);

        }
    }

    // Method called at the end to output the value of remaining stock
    public static int remainingStock(LinkedList<Integer> stock) {

        // Total value of remaining stock
        int remainingTotal = 0;

        // Keeps adding remaining stock onto total until list is empty
        while (!stock.isEmpty()) {
            remainingTotal += (int) stock.remove();
        }

        return remainingTotal;

    }

    public static void main(String[] args) throws IOException {

        // Creates a new linked list
        LinkedList<Integer> stock = new LinkedList<Integer>();

        // Variables
        String userInput;
        String[] command = new String[3];
        int[] profit = new int[1];
        profit[0] = 0;
        int quantity = 0, price = 0;
        boolean isValid;

        // Sets up input reader
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

        // Tells user which commands there are
        printHelp();

        do {

            // Takes user input and makes it all lowercase
            System.out.print("\nEnter your command. Type 'help' for a full list of commands: ");
            userInput = stdin.readLine().toLowerCase();

            // Splits user input into parts ([0] is command, [1] is quantity, [2] is price)
            command = userInput.split(" ");

            // Checks that the next two parts are actually ints (validation)
            try {
                quantity = Integer.parseInt(command[1]); // checks that quantity is int
                price = Integer.parseInt(command[2]); // checks that price is int
                isValid = true;

                // This only executes if the quantity and price are ints
                if (quantity <= 0 || price < 0) // now check if they are positive
                {
                    isValid = false;
                    System.out.println("Quantity and price must be positive or zero.");
                }

            } catch (Exception e) {
                isValid = false;
            }

            // If the parameters are correct
            if (isValid) {

                // Checks what command the user entered
                if (command[0].equals("help")) { // asking for help

                    printHelp();

                } else if (command[0].equals("buy")) { // buying

                    buyStock(stock, Integer.parseInt(command[1]), Integer.parseInt(command[2]));

                } else if (command[0].equals("sell")) { // selling

                    // Checks that there is enough remaining stock to sell
                    if (stock.size() >= quantity) {

                        sellStock(stock, quantity, price, profit);

                    } else {

                        System.out.println(
                                "Not enough stock remaining. Please enter a quantity less or equal to " + stock.size());

                    }

                } else { // invalid input

                    System.out.println("Invalid input. Use 'help' for a full list of commands.");

                }

            } else if (!command[0].equals("quit")) { // otherwise tell the user the inputs are invalid

                System.out.println("Invalid input. Use 'help' for a full list of commands.");

            }

        } while (!userInput.equals("quit")); // checks if the user wants to quit

        // After the user has quit, display final values
        // Tells the user how much profit they made
        if (profit[0] < 0) {

            System.out.println("\nBy selling items, you took a total loss of $" + (-1 * profit[0]));

        } else {

            System.out.println("\nBy selling items, you made a total profit of $" + profit[0]);

        }

        // Tells the user how much the value of unsold stock is
        System.out.println("The total value of unsold stock is $" + remainingStock(stock) + "\n");

    }

}