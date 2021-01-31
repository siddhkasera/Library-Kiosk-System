import java.util.Scanner;
import java.util.StringTokenizer;

import java.util.Calendar;

public class Kiosk {
    Scanner in = new Scanner(System.in);
    Library bookBag;

    public void run() {

        Library bag = new Library();
        //Declare/Initialize variables
        int i = 0;
        //int capacity = 10;
        String s = null;
        String serialNum = "";


        //Using Scanner for Getting input from user

        //QUESTION: Do I keep scanning until there is a Q command? How do I do this in JAVA? -- RESOLVED

        while (in.hasNext()) { //CHECK if this is right.
            s = in.nextLine();//nextLine reads the line after you press enter
            //TESTING PURPOSES
            System.out.println("You entered string " + s);

            String[] arrOfStr = s.split(",");
            for (String a: arrOfStr)
                System.out.println(a);

            String command = arrOfStr[0];

            /*StringTokenizer st = new StringTokenizer(s, ","); //Use StringTokenizer with comma as delimiter
            String[] tokens = new String[capacity]; //Array for storing tokens

            //Place tokens from string into tokens array
            while (st.hasMoreTokens()) {
                int count = st.countTokens();
                tokens[i] = st.nextToken();
                i++;
            }

            /*
            notes from office hours:
            store the first line into buffer mechanism
            don't parse command until 2nd line is put into system
            for now assume every line is complete
            if the command line isn't complete -- output "invalid command"
            suggestion: have separate class for testcases and use in main
             */

            //Place each command into a case and handle them from there
            i = 0; //do you mean like this?
            switch (command) {
                case "A":
                    //TODO insert add(Book book) method

                    //QUESTION: Is this the correct way to add a new book object to pass to my library?
                    //How do we edit the number, checkedOut values?

                    Book addBook = new Book(arrOfStr[1], null, false, null);
                    bookBag.add(addBook);
                    System.out.println(addBook);
                    break;
                case "R":
                    //TODO insert remove(Book book) method
                    break;
                case "O":
                    //TODO insert checkOut(Book book) method
                    break;
                case "I":
                    //TODO insert returns(Book book) method
                    break;
                case "PA":
                    //TODO insert print() method
                    break;
                case "PD":
                    //TODO insert printByDate() method
                    break;
                case "PN":
                    //TODO insert printByNumber() method
                    break;
                case "Q":
                    //TODO fix error for this case. It does not print. NULLPOINTEREXCEPTION.
                    System.out.println("Kiosk session ended");
                    System.exit(0);
                    break;
                default:
                    break;
            }
            System.out.println("\n" + arrOfStr[i]); //TESTING
        }

    }
}

