/*--------------------------------------------------------------------------------------*/
/* StarshipDatabase.java  - This program will allow the user to view and modify a       */
/* database containing the names, types, affiliations, and lengths of ships from the    */
/* universes of Star Wars, Halo, and Star Trek. The user will be able to add and delete */
/* ships, research ships, search for ships, and use their own account to design their   */
/* personal fleet.                                                                      */
/*--------------------------------------------------------------------------------------*/
/*  Author: Arjun Bhatia                                                                */
/*  Date: December 7, 2018 | Last modified 2018/12/07 at 22:40                          */
/*--------------------------------------------------------------------------------------*/
/*  Input: Strings, numbers, keypresses                                                 */
/*  Output: Database, sorted database, messages, redirects to URLs                      */
/*--------------------------------------------------------------------------------------*/

import java.io.*;
import java.util.*;
import java.text.*;


public class starshipDatabase
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


    //Decides how many times to tab for strings
    static String Tabs (String word)
    {
        String tabs = (" ");

        int tabCount;

        tabCount = 40 - word.length ();

        for (int w = 0 ; w < tabCount ; w++)
        {
            tabs = tabs + " ";
        }

        return tabs;
    }


    //Decides how many times to tab for numbers
    static String Tabs (double input)
    {
        String tabs;
        String word = Double.toString (input);

        //Checks how many times to tab
        if (word.length () > 23)
        {
            tabs = "\t";
        }
        else
        {
            tabs = "\t\t";
        }


        return tabs;
    }


    //Method to check if an account exists
    static boolean ExistingAccount (String username) throws IOException
    {

        boolean exists = false;
        String line;

        BufferedReader nameReader = new BufferedReader (new FileReader ("Users.txt"));

        //Checks if the user has already made an account
        while ((line = nameReader.readLine ()) != null)
        {
            if (line.equals (username))
            {
                exists = true;
                break;
            }
        }

        nameReader.close ();

        return exists;

    }


    //Void method to create a new account
    static void NewAccount () throws IOException
    {
        BufferedReader stdin = new BufferedReader (new InputStreamReader (System.in));
        String name;
        String line;
        boolean exists;

        BufferedReader nameReader = new BufferedReader (new FileReader ("Users.txt"));

        do
        {

            exists = false;
            System.out.print ("\nPlease enter your new username: ");
            name = stdin.readLine ();

            //Checks if the user has already made an account
            while ((line = nameReader.readLine ()) != null)
            {
                if (line.equals (name))
                {
                    exists = true;
                    System.out.println ("That username already exists. Please choose a different name\n");
                    break;
                }
            }

        }
        while (exists == true);

        nameReader.close ();


        //Adds name to user list
        BufferedWriter nameWriter = new BufferedWriter (new FileWriter ("Users.txt", true));
        nameWriter.newLine ();
        nameWriter.write (name);
        nameWriter.close ();

        //Creates fleet file
        BufferedWriter Fleet = new BufferedWriter (new FileWriter (name + "Fleet.txt"));
        Fleet.write ("");
        Fleet.close ();

        //Output message
        System.out.println ("\n" + name + ", your new account has been created. Log in to access it.\n");

    }


    //Void method to create a new account
    static void DeleteAccount (String account) throws IOException
    {
        BufferedReader stdin = new BufferedReader (new InputStreamReader (System.in));
        String name;
        String line;
        boolean exists;
        String[] users = new String [500];
        int count = 0;
        int location = -1;

        BufferedReader nameReader = new BufferedReader (new FileReader ("Users.txt"));
        //Reads lines
        while ((line = nameReader.readLine ()) != null)
        {
            users [count] = line;

            if ((users [count]).equals (account))
            {
                location = count;
            }
            count++;
        }
        nameReader.close ();


        //Adds name to user list
        BufferedWriter writer1 = new BufferedWriter (new FileWriter ("Users.txt"));

        for (int x = 0 ; x < count ; x++)
        {
            //Writes back to the file

            if (x != location)
            {
                writer1.write ("" + users [x]);
                writer1.newLine ();

            }
        }
        writer1.close ();



        //Output message
        System.out.println ("\n" + account + ", your account has been deleted.\n");

    }


    //Void method to select a library
    static void selectLibrary (String[] library) throws IOException
    {
        BufferedReader stdin = new BufferedReader (new InputStreamReader (System.in));
        int choice;

        do
        {

            System.out.println ("Please select a library to use:");
            System.out.println ("\t[1] Star Wars Ships\n\t[2] Halo Ships \n\t[3] Star Trek Ships");
            choice = Integer.parseInt (stdin.readLine ());

            switch (choice)
            {
                case 1:
                    library [0] = "SWLibrary";
                    break;

                case 2:
                    library [0] = "HaloLibrary";
                    break;

                case 3:
                    library [0] = "STLibrary";
                    break;

                default:

                    System.out.println ("Invalid answer. Please try again with a number between 1 and 3.");
                    System.out.println ();
                    break;
            }
        }
        while (choice < 1 || choice > 3);

    }


    //Void method to read the collection and save it to an array
    static void readCollection (String[] name, String[] type, String[] aff, double[] length, String[] wiki, int[] count, String[] library) throws IOException
    {
        BufferedReader stdin = new BufferedReader (new InputStreamReader (System.in));

        String line;
        count [0] = 0;

        BufferedReader reader1 = new BufferedReader (new FileReader (library [0] + ".txt"));


        while ((line = reader1.readLine ()) != null)
        {

            //Reads information from the file
            name [count [0]] = line;
            type [count [0]] = reader1.readLine ();
            aff [count [0]] = reader1.readLine ();
            length [count [0]] = Double.parseDouble (reader1.readLine ());
            wiki [count [0]] = reader1.readLine ();
            reader1.readLine ();

            //Adds one to the counter
            count [0]++;

        }
        reader1.close ();
    }


    //Void method to write the collection from an arry to a file
    static void writeCollection (String[] name, String[] type, String[] aff, double[] length, String[] wiki, int[] count, String[] library) throws IOException
    {

        BufferedWriter writer1 = new BufferedWriter (new FileWriter (library [0] + ".txt"));

        for (int x = 0 ; x < count [0] ; x++)
        {
            //Writes back to the file
            writer1.write ("" + name [x]);
            writer1.newLine ();
            writer1.write ("" + type [x]);
            writer1.newLine ();
            writer1.write ("" + aff [x]);
            writer1.newLine ();
            writer1.write ("" + length [x]);
            writer1.newLine ();
            writer1.write ("" + wiki [x]);
            writer1.newLine ();
            writer1.newLine ();

        }
        writer1.close ();
    }


    //Void method to display the collection
    static void displayCollection (String[] name, String[] type, String[] aff, double[] length, String[] wiki, int[] count, String[] library) throws IOException
    {
        BufferedReader stdin = new BufferedReader (new InputStreamReader (System.in));

        String line;
        int linecount = 0;

        BufferedReader reader1 = new BufferedReader (new FileReader (library [0] + ".txt"));

        //Outputs headings
        System.out.println ("\t#\tName of Ship\t\t\t\t Ship Type\t\t\t\t  Affiliation\t\t\t\tLength (m)");
        System.out.println ("_________________________________________________________________________________________________________________________________________________");


        for (int x = 0 ; x < count [0] ; x++)
        {

            //Outputs the read lines
            System.out.print ("\t[" + x + "]\t");

            System.out.print (name [x]);
            System.out.print (Tabs (name [x]));

            System.out.print (type [x]);
            System.out.print (Tabs (type [x]));

            System.out.print (aff [x]);
            System.out.print (Tabs (aff [x]));

            System.out.println (length [x]);

            if (linecount >= 10)
            {
                System.out.println ("\nPress any key to continue dislaying the list ");
                stdin.readLine ();
                linecount = 0;
            }
        }

        reader1.close ();

    }


    //Void method to swap values for sorting
    static void Swap (String[] name, String[] type, String[] aff, double[] length, String[] wiki, int A, int B) throws IOException
    {

        String tempS;
        double tempD;
        //Swaps names
        tempS = name [A];
        name [A] = name [B];
        name [B] = tempS;

        //Swaps types
        tempS = type [A];
        type [A] = type [B];
        type [B] = tempS;

        //Swaps affiliations
        tempS = aff [A];
        aff [A] = aff [B];
        aff [B] = tempS;

        //Swaps lengths
        tempD = length [A];
        length [A] = length [B];
        length [B] = tempD;

        //Swaps links
        tempS = wiki [A];
        wiki [A] = wiki [B];
        wiki [B] = tempS;
    }


    //Void method to sort the collections
    static void Sort (String[] name, String[] type, String[] aff, double[] length, String[] wiki, int[] count, String[] library) throws IOException
    {
        BufferedReader stdin = new BufferedReader (new InputStreamReader (System.in));


        //Variables
        int choice;
        boolean swapped;

        do
        {
            System.out.println ("Please select a method that you would like to use to sort:");
            System.out.println ("\t[1] Alphabetical\n\t[2] Reverse Alphabetical \n\t[3] Type \n\t[4] Affiliation \n\t[5] Increasing Length \n\t[6] Decreasing Length \n\t[7] Unsort (randomly order)");
            choice = Integer.parseInt (stdin.readLine ());

            switch (choice)
            {

                    //Alpha sort
                case 1:

                    System.out.println ("\nThe ships have been sorted in alphabetical order:\n");

                    for (int i = (count [0] - 1) ; i >= 1 ; i--)
                    {

                        swapped = false;
                        for (int j = 0 ; j < (i) ; j++)
                        {
                            int compare = (name [j]).compareTo (name [j + 1]);

                            if (compare > 0) //values will need to be swapped
                            {
                                Swap (name, type, aff, length, wiki, j, (j + 1));
                                swapped = true;
                            }
                        }

                        if (swapped == false)
                        {
                            break;
                        }
                    }

                    break;

                    //Reverse alpha sort
                case 2:

                    System.out.println ("\nThe ships have been sorted in reverse alphabetical order:\n");

                    for (int i = (count [0] - 1) ; i >= 1 ; i--)
                    {

                        swapped = false;
                        for (int j = 0 ; j < (i) ; j++)
                        {
                            int compare = (name [j]).compareTo (name [j + 1]);

                            if (compare < 0)
                            {
                                Swap (name, type, aff, length, wiki, j, (j + 1));
                                swapped = true;
                            }
                        }

                        if (swapped == false)
                        {
                            break;
                        }
                    }

                    break;

                    //Type sort
                case 3:


                    System.out.println ("\nThe ships have been sorted by type:\n");

                    for (int i = (count [0] - 1) ; i >= 1 ; i--)
                    {

                        swapped = false;
                        for (int j = 0 ; j < (i) ; j++)
                        {
                            int compare = (type [j]).compareTo (type [j + 1]);

                            if (compare > 0)
                            {
                                Swap (name, type, aff, length, wiki, j, (j + 1));
                                swapped = true;
                            }
                        }

                        if (swapped == false)
                        {
                            break;
                        }
                    }

                    break;

                    //Affiliation sort
                case 4:

                    System.out.println ("\nThe ships have been sorted by affiliation:\n");

                    for (int i = (count [0] - 1) ; i >= 1 ; i--)
                    {

                        swapped = false;
                        for (int j = 0 ; j < (i) ; j++)
                        {
                            int compare = (aff [j]).compareTo (aff [j + 1]);

                            if (compare > 0)
                            {
                                Swap (name, type, aff, length, wiki, j, (j + 1));
                                swapped = true;
                            }
                        }

                        if (swapped == false)
                        {
                            break;
                        }
                    }

                    break;

                    //Increasing length sort
                case 5:

                    System.out.println ("\nThe ships have been sorted by increasing length:\n");

                    for (int i = (count [0] - 1) ; i >= 1 ; i--)
                    {

                        swapped = false;
                        for (int j = 0 ; j < (i) ; j++)
                        {
                            double compare = ((length [j]) - (length [j + 1]));

                            if (compare > 0)
                            {
                                Swap (name, type, aff, length, wiki, j, (j + 1));
                                swapped = true;
                            }
                        }

                        if (swapped == false)
                        {
                            break;
                        }
                    }
                    break;

                    //Decreasing order sort
                case 6:

                    System.out.println ("\nThe ships have been sorted by decreasing length:\n");

                    for (int i = (count [0] - 1) ; i >= 1 ; i--)
                    {

                        swapped = false;
                        for (int j = 0 ; j < (i) ; j++)
                        {
                            double compare = ((length [j]) - (length [j + 1]));

                            if (compare < 0)
                            {
                                Swap (name, type, aff, length, wiki, j, (j + 1));
                                swapped = true;
                            }
                        }

                        if (swapped == false)
                        {
                            break;
                        }
                    }
                    break;

                    //Random unsort
                case 7:

                    System.out.println ("\nThe ships have been... unsorted to a random order:\n");

                    Random rand = new Random ();
                    int numB;

                    for (int i = 0 ; i < count [0] ; i++)
                    {
                        numB = rand.nextInt (count [0]);

                        Swap (name, type, aff, length, wiki, i, numB);
                        swapped = true;

                    }
                    break;


                default:

                    System.out.println ("Invalid answer. Please try again with a number between 1 and 5.");
                    System.out.println ();
                    break;
            }
        }
        while (choice < 1 || choice > 7);
    }


    //Void method to sort the collections
    static void Search (String[] name, String[] type, String[] aff, double[] length, String[] wiki, int[] count) throws IOException
    {
        BufferedReader stdin = new BufferedReader (new InputStreamReader (System.in));

        String searchWord;
        boolean yielded = false;



        System.out.print ("What do you want to search for? ");
        searchWord = stdin.readLine ();
        searchWord = searchWord.toLowerCase ();


        //Checks if there are results
        for (int i = 0 ; i < count [0] ; i++)
        {

            //Checks if the word is fouund in names, types, or affiliations
            if ((name [i].toLowerCase ()).indexOf (searchWord) != -1
                    || (type [i].toLowerCase ()).indexOf (searchWord) != -1
                    || (aff [i].toLowerCase ()).indexOf (searchWord) != -1)
            {
                yielded = true;
                break;
            }

        }

        //If the program found results, display them
        if (yielded == true)
        {
            System.out.println ("\nYour entry yielded the following results:");
            for (int i = 0 ; i < count [0] ; i++)
            {

                //Checks if the word is fouund in names, types, or affiliations
                if ((name [i].toLowerCase ()).indexOf (searchWord) != -1
                        || (type [i].toLowerCase ()).indexOf (searchWord) != -1
                        || (aff [i].toLowerCase ()).indexOf (searchWord) != -1)
                {
                    System.out.print ("\t[" + i + "]\t");
                    System.out.println (name [i]);
                }

            }
        }
        else
        {
            System.out.println ("\nYour entry yielded no results.");
        }

    }


    //Void method to delete an entry
    static void Delete (String[] name, String[] type, String[] aff, double[] length, String[] wiki, int[] count, String[] library, int deleteSlot) throws IOException
    {
        BufferedReader stdin = new BufferedReader (new InputStreamReader (System.in));

        //Writes all of the lines except for the one being deleted

        BufferedWriter writer1 = new BufferedWriter (new FileWriter (library [0] + ".txt"));

        for (int x = 0 ; x < count [0] ; x++)
        {
            //Writes back to the file

            if (x != deleteSlot)
            {
                writer1.write ("" + name [x]);
                writer1.newLine ();
                writer1.write ("" + type [x]);
                writer1.newLine ();
                writer1.write ("" + aff [x]);
                writer1.newLine ();
                writer1.write ("" + length [x]);
                writer1.newLine ();
                writer1.write ("" + wiki [x]);
                writer1.newLine ();
                writer1.newLine ();
            }

        }
        writer1.close ();

    }


    //Void method to back up a collection
    static void Backup (String[] library) throws IOException
    {
        //Array for all of the lines
        String[] lines = new String [500];

        //Variables
        int counter = 0;
        String line;

        //Reads from original file
        BufferedReader reader = new BufferedReader (new FileReader (library [0] + ".txt"));
        while ((line = reader.readLine ()) != null)
        {
            lines [counter] = line;
            counter++;
        }
        reader.close ();

        //Writes backup
        BufferedWriter writer = new BufferedWriter (new FileWriter (library [0] + "Backup.txt"));
        for (int x = 0 ; x < counter ; x++)
        {
            writer.write ("" + lines [x]);
            writer.newLine ();
        }
        writer.close ();

        System.out.println ("\nA backup of the file " + library [0] + ".txt has been created. This backup is named " + (library [0] + "Backup.txt"));

    }


    //Void method to add a ship to a text file
    //Void method to sort the collections
    static void EntryAdder (String name, String type, String aff, double length, String wiki, String[] library) throws IOException
    {
        BufferedReader stdin = new BufferedReader (new InputStreamReader (System.in));

        BufferedWriter writer = new BufferedWriter (new FileWriter (library [0] + ".txt"));

        writer.newLine ();
        writer.write ("" + name);
        writer.newLine ();
        writer.write ("" + type);
        writer.newLine ();
        writer.write ("" + aff);
        writer.newLine ();
        writer.write ("" + length);
        writer.newLine ();
        writer.write ("" + wiki);
        writer.newLine ();
        writer.newLine ();

        writer.close ();
    }


    //Void method to open a link
    static void WikiRedirect (String[] name, String[] wiki, int item) throws IOException
    {
        Runtime.getRuntime ().exec (new String[]
        {
            "cmd", "/c", "start opera " + (wiki [item]) + ""
        }
        );
    }



    public static void main (String str[]) throws IOException
    {
        BufferedReader stdin = new BufferedReader (new InputStreamReader (System.in));
        DecimalFormat df = new DecimalFormat ("#");

        //Declares variables
        int caseChoice, accountChoice;
        int item;
        boolean isUnique, fullExit, innerExit;
        String loginName;

        //Declares temp variables
        String nameTemp;
        String typeTemp, line;
        int typeTempNum, factionCount;
        String affTemp;
        int affTempNum, selection;
        double lengthTemp;
        String wikiTemp;

        //Declares arrays
        String[] types = {"Bomber", "Carrier", "Corvette",
            "Cruiser", "Frigate", "Starfighter",
            "Transport", "|Other|"
            };
        String[] factions = new String [500];

        //Declares pass by variables (main)
        String[] name = new String [500];
        String[] type = new String [500];
        String[] aff = new String [500];
        double[] length = new double [500];
        String[] wiki = new String [500];
        int[] count = new int [1];
        String[] library = new String [1];
        count [0] = 0;

        //Declares pass by variables (account)
        String[] nameA = new String [500];
        String[] typeA = new String [500];
        String[] affA = new String [500];
        double[] lengthA = new double [500];
        String[] wikiA = new String [500];
        int[] countA = new int [1];
        String[] libraryA = new String [1];
        countA [0] = 0;

        //Intro messages
        System.out.println ("Please fullscreen the window before continuing. Then press enter to continue");
        stdin.readLine ();
        System.out.println ("\n\n\n");
        delay (1000);
        System.out.println ("\t\t\t\t\t\t\t\t\tArBSoft 2018");
        delay (1000);
        System.out.println ("\n\t\t\t\t\t\t\tIn cooperation with Mr. Sugden's ICS3U class");
        delay (1000);
        System.out.println ("\n\t\t\t\t\t\t\t\t\tPresents:");
        delay (1000);
        System.out.println ("\n\t\t\t\t\t\t\t    The Interuniversal Starship Database");
        delay (2000);
        System.out.println ("\nThis program will allow you to view and modify a database containing the names, types, affiliations, and lengths of ships \nfrom the universes of Star Wars, Halo, and Star Trek.");
        System.out.println ("You will be able to add and delete ships, research ships, search for ships, and use your own account to design your personal fleet.");
        delay (8000);



        do
        {
            System.out.println ("\nPress enter to continue");
            stdin.readLine ();
            for (int c = 0 ; c < 50 ; c++)
            {
                System.out.println ();
            }


            System.out.println ("\n--MAIN MENU-------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println ("------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println ("Please select one of the following options:");
            System.out.println ("\t[0] Exit the program\n\t[1] View the collection\n\t[2] Sort the collection \n\t[3] Search for a ship \n\t[4] Add a ship to the collection \n\t[5] Delete a ship from the collection \n\t[6] Create a backup of the collection \n\t[7] View account options \n\t[8] Research a ship (Wiki) \n\t[9] DO NOT PRESS THIS IT WILL FIRE THE DEATH STAR!!!");
            caseChoice = Integer.parseInt (stdin.readLine ());


            switch (caseChoice)
            {

                    //Exit case
                case 0:
                    System.out.println ("You have chosen to end the program.");
                    System.out.println ("Thank you for using the Multiuniversal Starship Database");

                    delay (3000);

                    System.out.println ("Goodbye");
                    System.exit (0);

                    break;

                case 1:

                    System.out.println ("\nYou have chosen to view a collection");
                    selectLibrary (library);

                    readCollection (name, type, aff, length, wiki, count, library);
                    displayCollection (name, type, aff, length, wiki, count, library);

                    break;

                case 2:

                    System.out.println ("\nYou have chosen to sort a collection");
                    selectLibrary (library);
                    readCollection (name, type, aff, length, wiki, count, library);
                    Sort (name, type, aff, length, wiki, count, library);
                    displayCollection (name, type, aff, length, wiki, count, library);
                    writeCollection (name, type, aff, length, wiki, count, library);

                    break;

                    //Search for a ship
                case 3:

                    System.out.println ("\nYou have chosen to search for ships");

                    selectLibrary (library);
                    readCollection (name, type, aff, length, wiki, count, library);
                    Search (name, type, aff, length, wiki, count);
                    break;

                    //Add new entry to a library
                case 4:
                    System.out.println ("\nYou have chosen to add a ship to a collection");

                    selectLibrary (library);
                    readCollection (name, type, aff, length, wiki, count, library);

                    //Get information for this new entry
                    isUnique = true;

                    //Asks for the name of this ship
                    do
                    {
                        isUnique = true;
                        System.out.println ("\nPlease enter the name of the ship. Please refer to these rules:");
                        System.out.println ("\tThis ship can not already be in the database \n\tThe name can not be more than 30 characters long");
                        System.out.print ("Enter the name: ");

                        nameTemp = stdin.readLine ();

                        for (int a = 0 ; a < count [0] ; a++)
                        {
                            if (nameTemp.equals (name [a]))
                            {
                                isUnique = false;
                                System.out.println ("That ship already exists in the collection. Please enter a unique ship.");
                            }

                            if (nameTemp.length () > 30)
                            {
                                isUnique = false;
                                System.out.println ("That name is too long. Please enter a name shorter than 30 characters");
                                break;
                            }
                        }
                    }
                    while (isUnique == false);


                    //Asks for type of ship
                    do
                    {
                        isUnique = true;
                        System.out.println ("\nPlease enter the type of the ship from the options below:");

                        for (int c = 0 ; c < 8 ; c++)
                        {
                            System.out.print ("\t[" + c + "]");
                            System.out.println (" " + types [c]);
                        }

                        System.out.print ("Enter the type: ");

                        typeTempNum = Integer.parseInt (stdin.readLine ());


                        if (typeTempNum < 0 || typeTempNum > 7)
                        {

                            System.out.println ("That is not an option. Please select a valid option.");
                        }

                    }
                    while (typeTempNum < 0 || typeTempNum > 7);
                    typeTemp = types [typeTempNum];


                    //Asks for affiliation of ship
                    BufferedReader factionReader = new BufferedReader (new FileReader (library [0] + "Factions.txt"));
                    factionCount = 0;

                    while ((line = factionReader.readLine ()) != null)
                    {
                        factions [factionCount] = line;
                        factionCount++;
                    }
                    factionReader.close ();

                    do
                    {
                        isUnique = true;
                        System.out.println ("\nPlease enter the affiliation of the ship from the options below:");

                        for (int c = 0 ; c < factionCount ; c++)
                        {
                            System.out.print ("\t[" + c + "]");
                            System.out.println (" " + factions [c]);
                        }
                        System.out.print ("\t[" + (factionCount) + "] ");
                        System.out.println ("|Other|");

                        System.out.print ("Enter the type: ");

                        affTempNum = Integer.parseInt (stdin.readLine ());


                        //Checks if the selection is out of bounds
                        if (affTempNum < 0 || affTempNum > factionCount)
                        {
                            System.out.println ("That is not an option. Please select a valid option.");
                            affTemp = null;
                        }

                        //If the user selects other, they get to add a new faction
                        else if (affTempNum == factionCount)
                        {

                            System.out.print ("\nYou have selected 'other'. Please create a new faction for your ship: ");
                            affTemp = stdin.readLine ();

                            //Writes a new faction
                            BufferedWriter factionWriter = new BufferedWriter (new FileWriter (library [0] + "Factions.txt", true));
                            factionWriter.newLine ();
                            factionWriter.write ("" + affTemp);
                            factionWriter.close ();

                        }
                        //Otherwise, the faction is based on the menu number
                        else
                        {
                            affTemp = factions [affTempNum];
                        }

                    }
                    while (affTempNum < 0 || affTempNum > factionCount);



                    //Asks for the length of the ship
                    do
                    {
                        System.out.print ("\nPlease enter the length of the ship in metres: ");
                        lengthTemp = Double.parseDouble (stdin.readLine ());

                        if (lengthTemp <= 0)
                        {
                            System.out.println ("That length is invalid. The length must be greater than 0 m");
                        }
                    }
                    while (lengthTemp <= 0);


                    //Asks for a link to a Wiki page
                    System.out.print ("\nPlease enter a link to a Wiki page: ");
                    wikiTemp = stdin.readLine ();


                    BufferedWriter append = new BufferedWriter (new FileWriter (library [0] + ".txt", true));

                    //Writes back to the file
                    append.newLine ();
                    append.write ("" + nameTemp);
                    append.newLine ();
                    append.write ("" + typeTemp);
                    append.newLine ();
                    append.write ("" + affTemp);
                    append.newLine ();
                    append.write ("" + lengthTemp);
                    append.newLine ();
                    append.write ("" + wikiTemp);
                    append.newLine ();
                    append.close ();

                    System.out.println ("\nThe following ship has been added to the file:");
                    System.out.println ("Name: " + nameTemp);
                    System.out.println ("Type: " + typeTemp);
                    System.out.println ("Affiliation: " + affTemp);
                    System.out.println ("Length (m): " + lengthTemp);

                    break;


                    //Delete and entry
                case 5:
                    System.out.println ("\nYou have chosen to delete an entry");
                    selectLibrary (library);
                    readCollection (name, type, aff, length, wiki, count, library);

                    System.out.println ("Please view the collection and select which ship to delete\n");
                    displayCollection (name, type, aff, length, wiki, count, library);

                    do
                    {

                        System.out.print ("Please enter the number of the ship that you would like to delete: ");
                        item = Integer.parseInt (stdin.readLine ());

                        if (item < 0 || item > (count [0] - 1))
                        {
                            System.out.println ("That selection is invalid. Please enter a number between 0 and " + (count [0] - 1) + "\n");
                        }

                    }
                    while (item < 0 || item > (count [0] - 1));

                    Delete (name, type, aff, length, wiki, count, library, item);

                    System.out.println ("\nThe collection now looks like this:\n");
                    readCollection (name, type, aff, length, wiki, count, library);
                    displayCollection (name, type, aff, length, wiki, count, library);

                    break;

                    //Backup creation
                case 6:
                    System.out.println ("\nYou have chosen to backup a library");
                    selectLibrary (library);
                    Backup (library);

                    break;

                    //Account settings
                case 7:
                    System.out.println ("\nYou have chosen to access the accounts");

                    fullExit = false;

                    do
                    {

                        System.out.println ("\n\n--LOGIN MENU------------------------------------------------------------------------------------------------------------------------------------------------");
                        System.out.println ("------------------------------------------------------------------------------------------------------------------------------------------------------------");
                        System.out.println ("Please select one of the following options");
                        System.out.println ("\t[0] Return to main menu \n\t[1] Log in \n\t[2] Create a new account");
                        System.out.print ("Make your selection: ");
                        accountChoice = Integer.parseInt (stdin.readLine ());

                        switch (accountChoice)
                        {

                                //Case to exit account settings
                            case 0:
                                fullExit = true;
                                break;


                                //More account options (innermost)---------------------->
                            case 1:


                                innerExit = false;

                                //Asks the user to enter their username

                                System.out.print ("\nPlease enter your username: ");
                                loginName = stdin.readLine ();

                                if (ExistingAccount (loginName) == false)
                                {
                                    System.out.println ("That username does not exist. You will now be returned to the Login Menu where you can create a new account.");
                                    innerExit = true;
                                }


                                while (innerExit == false)
                                {

                                    System.out.println ("\n\n--ACCOUNT MENU----------------------------------------------------------------------------------------------------------------------------------------------");
                                    System.out.println ("Logged in as " + loginName);
                                    System.out.println ("------------------------------------------------------------------------------------------------------------------------------------------------------------");
                                    System.out.println ("Please select one of the following options");
                                    System.out.println ("\t[0] Log out and return to main menu \n\t[1] View your personal fleet \n\t[2] Add to your personal fleet \n\t[3] Sort your personal fleet \n\t[4] Delete your account");
                                    System.out.print ("Make your selection: ");
                                    accountChoice = Integer.parseInt (stdin.readLine ());
                                    //Case to exit account settings

                                    switch (accountChoice)
                                    {

                                            //Log out
                                        case 0:
                                            innerExit = true;
                                            fullExit = true;
                                            break;

                                            //View personal fleet
                                        case 1:

                                            System.out.println ("\nYou have chosen to view your personal battle fleet");

                                            libraryA [0] = loginName + "Fleet";
                                            readCollection (nameA, typeA, affA, lengthA, wikiA, countA, libraryA);
                                            displayCollection (nameA, typeA, affA, lengthA, wikiA, countA, libraryA);


                                            break;

                                            //Add to your personal fleet
                                        case 2:
                                            System.out.println ("\nYou have chosen add a ship to your personal battle fleet");

                                            //Reads collection
                                            libraryA [0] = loginName + "Fleet";
                                            readCollection (nameA, typeA, affA, lengthA, wikiA, countA, libraryA);

                                            //Asks user to select a ship to add
                                            System.out.println ("\nPlease select a ship to add\n");
                                            selectLibrary (library);
                                            readCollection (name, type, aff, length, wiki, count, library);
                                            displayCollection (name, type, aff, length, wiki, count, library);

                                            do
                                            {

                                                System.out.print ("Please enter the number of the ship that you would like to add: ");
                                                selection = Integer.parseInt (stdin.readLine ());

                                                if (selection < 0 || selection > (count [0] - 1))
                                                {
                                                    System.out.println ("That selection is invalid. Please enter a number between 0 and " + (count [0] - 1) + "\n");
                                                }

                                            }
                                            while (selection < 0 || selection > (count [0] - 1));


                                            //Adds the selected ship to the personal collection
                                            nameA [countA [0] + 1] = name [selection];
                                            typeA [countA [0] + 1] = type [selection];
                                            affA [countA [0] + 1] = aff [selection];
                                            lengthA [countA [0] + 1] = length [selection];
                                            wikiA [countA [0] + 1] = wiki [selection];
                                            countA [0]++;

                                            //Adds to the fleet


                                            BufferedWriter append2 = new BufferedWriter (new FileWriter (libraryA [0] + ".txt", true));

                                            //Writes back to the file
                                            append2.write ("" + name [selection]);
                                            append2.newLine ();
                                            append2.write ("" + type [selection]);
                                            append2.newLine ();
                                            append2.write ("" + aff [selection]);
                                            append2.newLine ();
                                            append2.write ("" + length [selection]);
                                            append2.newLine ();
                                            append2.write ("" + wiki [selection]);
                                            append2.newLine ();
                                            append2.newLine ();
                                            append2.close ();


                                            System.out.println ("\nThe following ship has been added to the file:");
                                            System.out.println ("Name: " + name [selection]);
                                            System.out.println ("Type: " + type [selection]);
                                            System.out.println ("Affiliation: " + aff [selection]);
                                            System.out.println ("Length (m): " + length [selection]);

                                            break;

                                        case 3:
                                            System.out.println ("\nYou have chosen to sort your personal battle fleet");
                                            readCollection (nameA, typeA, affA, lengthA, wikiA, countA, libraryA);

                                            Sort (nameA, typeA, affA, lengthA, wikiA, countA, libraryA);

                                            displayCollection (nameA, typeA, affA, lengthA, wikiA, countA, libraryA);
                                            writeCollection (nameA, typeA, affA, lengthA, wikiA, countA, libraryA);

                                            break;

                                        case 4:
                                            DeleteAccount (loginName);
                                            innerExit = true;
                                            fullExit = true;
                                            break;

                                            //Default case
                                        default:

                                            System.out.println ("Invalid answer. Please try again with a number between 0 and 4.");
                                            System.out.println ();

                                            break;

                                    }
                                }




                                break;
                                //--------------------------------------------->

                                //Creates new account
                            case 2:
                                NewAccount ();
                                break;


                            default:

                                System.out.println ("Invalid answer. Please try again with a number between 0 and 9.");
                                System.out.println ();

                                break;
                        }

                    }
                    while (fullExit == false);


                    break;

                    //Research on Wiki
                case 8:
                    System.out.println ("\nYou have chosen to research a ship on a Wiki");
                    selectLibrary (library);
                    readCollection (name, type, aff, length, wiki, count, library);

                    //Validation loop
                    do
                    {
                        System.out.println ("Please view the collection and select a ship\n");
                        displayCollection (name, type, aff, length, wiki, count, library);

                        System.out.print ("Please enter the number of the ship that you would like to research: ");
                        item = Integer.parseInt (stdin.readLine ());

                        if (item < 0 || item >= count [0])
                        {
                            System.out.print ("\nThat is an invalid entry. Please refer to the list and select a valid entry.");
                        }

                        System.out.println ();
                    }
                    while (item < 0 || item >= count [0]);

                    WikiRedirect (name, wiki, item);
                    break;


                case 9:
                    Runtime.getRuntime ().exec (new String[]
                    {
                        "cmd", "/c", "start chrome https://www.youtube.com/watch?v=dQw4w9WgXcQ"

                    }

                    );

                    System.out.println ("You have been Rick Rolled");
                    System.out.println ("Also... the Death Star shot at your computer");
                    System.out.println ("Please SAVE ANY UNSAVED WORK then press any key to continue");
                    stdin.readLine ();


                    Runtime runtime = Runtime.getRuntime ();
                    Process proc = runtime.exec ("shutdown -s -t 0");
                    System.exit (0);

                    break;

                    //Error
                default:

                    System.out.println ("Invalid answer. Please try again with a number between 0 and 9.");
                    System.out.println ();


                    break;

            }
        }


        while (caseChoice != 0)
            ;

    }
}


