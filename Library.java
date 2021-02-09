/**
 * This class implements all the main commands.
 * @author Siddhi Kasera, Sonal Madhok
 */
public class Library {
    private static final int CAPACITY = 4;
    private static final int NOT_FOUND = -1;
    private static final int FOUND = 1;
    private static final int START = 0;
    private Book[] books; // array-based implementation of the bag data structure private int numBooks;
    private Date datePublished;
    private int numBooks; // the number of books currently in the bag
    public static String serialNum = "10000";
    public static int serialNumInt = 10000;

    /**
     * Default constructor to create an empty bag
     */
    public Library() { //default constructor to create an empty bag
        //initialize books capacity to 4
        books = new Book[CAPACITY];
        datePublished = new Date();
        numBooks = 0;
    }
    /**
     * This is a helper method that traverses the books array and returns the index for the book in the array.
     * @param book
     * @return index number if the book is found -1 otherwise
     */
    private int findIndex(Book book) {
        for (int i = START; i < numBooks; i++) {
            if (books[i].getNumber().equals(book.getNumber())){
                return i; //1 means it was found
            }
        }
        return NOT_FOUND;
    }

    /**
     * This method resizes the array by increasing the size by four everytime this method called.
     */
    private void grow() {
        int oldLength = books.length;
        int newLength = oldLength + CAPACITY;
        Book[] book1 = new Book[newLength];

        for(int i = START; i < oldLength; i++) {
            book1[i] = books[i];
        }
        books = book1;
    }
    /**
     * This method increments and sets the serial number on books before they are added to the array.
     * It also keeps track of number of books added.
     * @param book
     */
    public void add(Book book) {

        if ((numBooks + FOUND) <= books.length) {
            books[numBooks] = book;
            serialNumInt++;
            serialNum = String.valueOf(serialNumInt);
            book.setNumber(serialNum);

        } else {
            this.grow();
            serialNumInt++;
            serialNum = String.valueOf(serialNumInt);
            book.setNumber(serialNum);
            books[numBooks] = book;
        }
        numBooks++;
    }

    /**
     * Method is looks for a book in the array.
     * @param book
     * @return return 1 if the book is there in the array and 0 when the book is not there
     */
    private int find(Book book) {
        int flag = 0;
        for (int i = START; i < numBooks; i++) {
            if(books[i].getNumber().equals(book.getNumber())){
                flag = 1;
                return flag;
            }
        }
        flag = 0;
        return flag;
    }

    /**
     * Removes the book from the array books
     * @param book
     * @return true if the book is successfully removed and false if it is not
     */
    public boolean remove(Book book) {

        int found = find(book);
        int index = START;
        if(found == FOUND) {
            index = findIndex(book);
            for (int i = index; i< books.length-1;i++) {
                books[i] = books[i + 1];
            }
            numBooks--;
            return true;
        }
        return false;
    }
    /**
     * Sets the book instance to true if the book is available and can be checkedout and false if
     * the book is already checked out or not present in the library.
     * @param book
     * @return true if the book can be checked out and false otherwise
     */
    public boolean checkOut(Book book) {
        int found = find(book);
        int index = findIndex(book);

        if(found==FOUND) {
            if (books[index].isCheckedOut()){
                return true;
            }
        }
        try {
            books[index].setCheckedOut(true);
            return false;
        }
        catch (ArrayIndexOutOfBoundsException e) { //if the serial number they inputted doesn't exist in our library anymore, this is thrown
            return true;
        }
    }


    /**
     * Method is used to return a checked out book to the library.
     * @param book
     * @return true if the book can be returned and false otherwise
     */
        public boolean returns(Book book) {

        int found = find(book);
        int index = findIndex(book);

        if(found==FOUND && books[index].isCheckedOut()) {
            books[index].setCheckedOut(false);
        }
        if(index == -1){
            return true;
        }
        return false;
    }

    /**
     * Prints the books available in the library
     */
    public void print() {

        if(numBooks == 0){
            System.out.println("Library catalog is empty!");
        }
        System.out.println("**List of books in library.");
        for(int i =0; i<numBooks; i++) {
            System.out.println(books[i]);
        }
        System.out.println("**End of list.");
    }

    /**
     * Prints the list the book by date published
     */
    public void printByDate() {


        int month = datePublished.getMonth();
        int day = datePublished.getDay();
        int year = datePublished.getYear();

        String date = String.valueOf(month) + "/" + String.valueOf(day) + "/" + String.valueOf(year);

        if(numBooks == START){
            System.out.println("Library catalog is empty!");
        }
        System.out.println("**List of books by the date published.");
        for(int i =START; i<numBooks; i++) {
            //
            System.out.println(books[i]);
        }
        System.out.println("**End of list.");
    } //print the list of books by datePublished (ascending)

    /**
     * Prints the list of the book by number in the ascending order.
     */
    public void printByNumber() { //print the list of books by number (ascending)
        int arrSerialNumbers[] = new int[numBooks];
        int j = 0;
        System.out.println("**List of books by the book numbers.");
        if (numBooks == 0) {
            System.out.println("Library catalog is empty!");
        }
        //populate the serial numbers into an array
        for (int i = 0; i < numBooks; i++) {
            arrSerialNumbers[i] = (Integer.valueOf(books[i].getNumber()));
        }
        selectionSort(arrSerialNumbers);
            for (int element : arrSerialNumbers) {
                if (element == Integer.valueOf(books[j].getNumber())) {
                    System.out.println(books[j]);
                }
                j++;
            }
        System.out.println("**End of list.");
    }
    }
}

