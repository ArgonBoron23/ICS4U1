/*--------------------------------------------------------------------------------------*/
/*  Array41.java  - This program will...                                               */
/*                                                                                      */
/*--------------------------------------------------------------------------------------*/
/*  Author: Arjun Bhatia                                                                */
/*  Date:                                                                               */
/*--------------------------------------------------------------------------------------*/
/*  Input:                                                                              */
/*  Output:                                                                             */
/*--------------------------------------------------------------------------------------*/

import java.io.*;
import java.text.*;

public class hello
{


    //Void method for delay
    static void delay (int ms)
    {
        try
        {
            Thread.sleep (ms);
        }
        catch (InterruptedException ie)
        {
        }
    }


    //Void method to enter values into the array using the keyboard
    static void keyboardFill (int[] [] integers) throws IOException
    {
        BufferedReader stdin = new BufferedReader (new InputStreamReader (System.in));

        for (int r = 0 ; r < integers.length ; r++)
        {
            System.out.println ("you will enter numbers for the [" + r + "] row");

            for (int c = 0 ; c < integers [r].length ; c++)
            {
                System.out.print ("\tYou will enter numbers for the [" + c + "] column: ");
                integers [r] [c] = Integer.parseInt (stdin.readLine ());
            }
        }
    }


    //Void method to enter values into the array using a text file
    static void fileFill (int[] [] integers) throws IOException
    {
        BufferedReader stdin = new BufferedReader (new InputStreamReader (System.in));

        System.out.println ("Please enter the name of the file: ");
        String filename = stdin.readLine ();

        BufferedReader reader = new BufferedReader (new FileReader (filename + ".txt"));

        for (int r = 0 ; r < integers.length ; r++)
        {
            for (int c = 0 ; c < integers [r].length ; c++)
            {
                integers [r] [c] = Integer.parseInt (reader.readLine ());
            }
        }

        reader.close ();
    }


    //Void method to enter values into the array using a text file
    static void display (int[] [] integers)
    {

        System.out.println ("\t\t\t\t\tSum");
        for (int r = 0 ; r < integers.length ; r++)
        {
            System.out.println ("\n\n");
            for (int c = 0 ; c < integers [r].length ; c++)
            {
                System.out.print ("\t" + integers [r] [c]);
            }
        }

        System.out.println ("\n");

    }


    public static void main (String str[]) throws IOException
    {
        BufferedReader stdin = new BufferedReader (new InputStreamReader (System.in));
        DecimalFormat df = new DecimalFormat ("#");

        int choice;
        int height = 3, width = 4;



        //Creates an array
        int[] [] numbers = new int [height] [width];


        do
        {
            System.out.println ("Select an option");
            System.out.println ("\t[0] Exit the program \n\t[1] Fill the array using the keyboard \n\t[2] Fill the array using a text file");
            System.out.print ("Enter your selection: ");
            choice = Integer.parseInt (stdin.readLine ());

            switch (choice)
            {

                case 0:
                    System.out.println ("You have chosen to end the program.");
                    System.out.println ("Thank you for using the program");

                    delay (3000);

                    System.out.println ("Goodbye");
                    System.exit (0);

                    break;

                case 1:


                    keyboardFill (numbers);
                    display (numbers);
                    break;

                case 2:

                    fileFill (numbers);
                    display (numbers);
                    break;

                default:

                    System.out.println ("\nInvalid selection. Please pick either 1 or 2\n");

                    break;
            }
        }
        while (choice != 0);


    }
}


