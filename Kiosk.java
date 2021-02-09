/**
 This class processes the commands entered in the command line.
 @author Siddhi Kasera, Sonal Madhok
 */

import java.lang.reflect.Array;
import java.util.Scanner;

public class Kiosk {
    public static String serialNumber;

    /**
     * This method reads from the command line, parses the input and calls the respective functions.
     */
    public void run() {
        //Scanning the input
        Scanner in = new Scanner(System.in);
        Library bag = new Library();
        Date date = new Date();

        System.out.println("Library Kiosk running.");
        //Declare/Initialize variables
        String command = "";
        int i = 0;
        String s = null;
        boolean hasNextLine = in.hasNext();

        //Using Scanner for Getting input from user
        while (hasNextLine) {
            s = in.nextLine(); //nextLine reads
            String[] arrOfStr = s.split(","); //Tokenizing the array from the Scanner
            command = arrOfStr[0];

            switch (command) {
                case "A":  //handling command add
                    String bookName = arrOfStr[1];
                    String datePubStr = arrOfStr[2];
                    Book addBook = new Book(bookName, datePubStr);
                    if (addBook.getDate().isValid()) {
                        bag.add(addBook);
                        System.out.println(addBook.getName() + " added to the Library.");
                    } else {
                        System.out.println("Invalid Date!");
                    }
                    break;

                case "R":  //handling command remove
                    serialNumber = arrOfStr[1];
                    Book removeBook = new Book(serialNumber);
                    if (bag.remove(removeBook)) {
                        System.out.println("Book#" + serialNumber + " removed.");
                    } else {
                        System.out.println("Unable to remove, the library does not have this book.");
                    }
                    break;


                case "O": //handling command checkout
                    serialNumber = arrOfStr[1];
                    Book checkOutBook = new Book(serialNumber);
                    if (bag.checkOut(checkOutBook)) {
                        System.out.println("Book#" + serialNumber + " is not available.");
                    } else {
                        checkOutBook.setCheckedOut(true);
                        System.out.println("You've checked out Book#" + serialNumber + ". Enjoy!.");
                    }
                    break;

                case "I": //handling return command
                    serialNumber = arrOfStr[1];
                    Book returnBook = new Book(serialNumber);
                    if (bag.returns(returnBook)) {
                        System.out.println("Unable to return Book#" + serialNumber);
                    } else {
                        System.out.println("Book#" + serialNumber + " return has completed. Thanks!");
                    }
                    break;

                case "PA":  //printing the list of books
                    bag.print();
                    break;

                case "PD": //printing the list of books by date
                    bag.printByDate();
                    break;

                case "PN": //printing the list of books by serial number
                    bag.printByNumber();
                    break;

                case "Q": //exiting a kiosk session
                    System.out.println("Kiosk session ended");
                    System.exit(0);
                    break;

                default:
                    System.err.println("Invalid command!");
                    break;
            }
        }

    }
}