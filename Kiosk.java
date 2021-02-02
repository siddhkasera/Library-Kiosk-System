import java.util.Scanner;

public class Kiosk {

    //  --- RESOLVED --  Library bookBag; //QUESTION: in order to access the methods from Library, we have to create it here right? -- this did nothing lol.

    public void run() {

        //Create Scanner and Library constructors
        Scanner in = new Scanner(System.in);
        Library bag = new Library();

        //Declare/Initialize variables
        int i = 0;
        String s = null;
        boolean hasNextLine = in.hasNext();


        //Using Scanner for Getting input from user
                                                    // -- RESOLVED -- QUESTION: Do I keep scanning until there is a Q command? How do I do this in JAVA?
        while (hasNextLine) {
            s = in.nextLine();//nextLine reads the line after you press enter
            String[] arrOfStr = s.split(","); //Tokenizing the array from the Scanner

            /*TESTING PURPOSES -- System.out.println("You entered string " + s);
            for (String a: arrOfStr)
                System.out.println(a);
             */

            String command = arrOfStr[0];

            switch (command) {
                case "A":
                    String bookName = arrOfStr[1];
                    Book addBook = new Book(bookName, null, false, null);
                    bag.add(addBook);  // -- RESOLVED -- QUESTION: Am I accessing this wrong?

                    //-- RESOLVED -- QUESTION: Is this the correct way to add a new book object to pass to my library?
                    //How do we edit the number? How to edit checkedOut values?
                    //I think I am confused on using my Book class to tie this all together
                    //Does my object addBook add itself to my array in the Library class?

                    //System.out.println(bookObj.getName()); //TESTING PURPOSES. delete later.
                    break;

                case "R":
                    String serialRemove = arrOfStr[1];
                    Book removeBook = new Book(null, serialRemove, false, null);
                    bag.remove(removeBook);
                    break;

                case "O":
                    String serialCheckOut = arrOfStr[1];
                    Book checkOutBook = new Book(null, serialCheckOut, false, null);
                    bag.checkOut(checkOutBook);
                    break;

                case "I":
                    //QUESTION: is there a way to not have repeated code in these cases?
                    String serialReturn = arrOfStr[1];
                    Book returnBook = new Book(null, serialReturn, false, null);
                    bag.returns(returnBook);
                    break;

                case "PA":
                    bag.print();
                    break;

                case "PD":
                    bag.printByDate();
                    break;

                case "PN":
                    bag.printByNumber();
                    break;

                case "Q":
                    System.out.println("Kiosk session ended");
                    System.exit(0);
                    break;

                default:
                    System.err.println("Invalid command: " + command + " expected 'A, R, O, I, PA, PD, PN, Q'.");
                    break;
            }
        }

    }
}
