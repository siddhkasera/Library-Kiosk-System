import java.lang.reflect.Array;
import java.util.Scanner;

public class Kiosk {
    public static String serialNumber;


    public void run() {

        //Create Scanner and Library constructors
        Scanner in = new Scanner(System.in);
        Library bag = new Library();
        Date date = new Date();


        //Declare/Initialize variables
        String command = "";
        int i = 0;
        String s = null;
        boolean hasNextLine = in.hasNext();

        //Using Scanner for Getting input from user
        while (hasNextLine) {
            s = in.nextLine(); //nextLine reads the line after you press enter
            String[] arrOfStr = s.split(","); //Tokenizing the array from the Scanner
            command = arrOfStr[0];

            switch (command) {
                case "A":

                    String bookName = arrOfStr[1];
                    String datePubStr = arrOfStr[2];
                    Book addBook = new Book(bookName, datePubStr);

                    //if (addBook.getDate().isValid()) { //--UNCOMMENT THIS TO CHECK IF VALID WORKS AND IF IT DOES, LEAVE UNCOMMENTED
                        bag.add(addBook);
                        //System.out.println(book.getName() + " added to the Library."); //--UNCOMMENT THIS ONCE LIBRARY IS DONE
                    /*  }
                    else {
                        System.out.println("Invalid Date!");
                    }
                     */

                    break;

                    /*  Office hours notes:
                        two books shouldn't have same serial number
                        look up the serial number in the library in the case

                        write helper method to look up book to be removed
                        will return the book object in the array that will be removed
                        ^^ can do this from looking up the serial number
                     */

                case "R":
                    serialNumber = arrOfStr[1];
                    Book book = new Book(serialNumber);
                    if(bag.remove(book)){

                        System.out.println("Book#" + serialNumber + " removed.");
                        }
                    else {
                        System.out.println("Unable to remove, the library does not have this book.");
                    }
                    break;


                case "O":
                    serialNumber = arrOfStr[1];
                    Book book1 = new Book(serialNumber);

                    if(bag.checkOut(book1)){
                        //book1.setCheckedOut(true);
                        System.out.println("Book#" + serialNumber + " is not available.");
                    }
                    else {
                        book1.setCheckedOut(true);
                        //bag.checkOut(book1);
                        System.out.println("You've checked out Book#"+ serialNumber + ". Enjoy!.");
                    }
                    break;

                case "I":
                    serialNumber = arrOfStr[1];
                    Book book2 = new Book(serialNumber);
                    if(bag.returns(book2)){
                        System.out.println("Unable to return Book#" + serialNumber);
                    }
                    else {
                        System.out.println("Book#" + serialNumber + " return has completed. Thanks!");
                    }
                    break;

                case "PA":
                    bag.print();
                    break;

                case "PD":
                    bag.printByDate();
                    break;

                /*case "PN":
                    bag.printByNumber();
                    break;
                */
                case "Q":
                    System.out.println("Kiosk session ended");
                    System.exit(0);
                    break;

                default:
                    System.err.println("Invalid command: " + command + ". Expected commands: 'A, R, O, I, PA, PD, PN, Q'.");
                    break;
            }
        }

    }
}


            /* Notes: StringTokenizer st = new StringTokenizer(s, ","); //Use StringTokenizer with comma as delimiter

            String[] tokens = new String[capacity]; //Array for storing tokens

            //Place tokens from string into tokens array
            while (st.hasMoreTokens()) {
                int count = st.countTokens();
                tokens[i] = st.nextToken();
                i++;
            }

            /*
            notes from office hours 1/29/21:
            store the first line into buffer mechanism
            don't parse command until 2nd line is put into system
            for now assume every line is complete
            if the command line isn't complete -- output "invalid command"
            suggestion: have separate class for testcases and use in main


//Place each command into a case and handle them from there
//i = 0; //do you mean like this?

*/
