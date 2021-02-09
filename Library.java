import com.sun.jdi.IntegerValue;

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

    /*

     */
    public Library() { //default constructor to create an empty bag
        //initialize books capacity to 4
        books = new Book[CAPACITY];
        datePublished = new Date();
        numBooks = 0;
    }

    /*

     */
    private int findIndex(Book book) {
        for (int i = START; i < numBooks; i++) {
            if (books[i].getNumber().equals(book.getNumber())) {
                return i;
            }
        }
        return NOT_FOUND;
    }

    /*

     */
    private void grow() {
        int oldLength = books.length;
        int newLength = oldLength + CAPACITY;
        Book[] book1 = new Book[newLength];

        for (int i = START; i < oldLength; i++) {
            book1[i] = books[i];
        }
        books = book1;
    }

    /*

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

    /*

     */
    private int find(Book book) {
        int flag = 0;
        for (int i = START; i < numBooks; i++) {
            if (books[i].getNumber().equals(book.getNumber())) {
                flag = 1;
                return flag;
            }
        }
        flag = 0;
        return flag;
    }

    /*

     */
    public boolean remove(Book book) {

        int found = find(book);
        int index = START;
        if (found == FOUND) {
            index = findIndex(book);
            for (int i = index; i < books.length - 1; i++) {
                books[i] = books[i + 1];
            }
            numBooks--;
            return true;
        }
        return false;
    }

    /*

     */
    public boolean checkOut(Book book) {
        int found = find(book);
        int index = findIndex(book);

        if (found == FOUND) {
            if (books[index].isCheckedOut()) {
                return true;
            }
        }
        try {
            books[index].setCheckedOut(true);
            return false;
        } catch (ArrayIndexOutOfBoundsException e) { //if the serial number they inputted doesn't exist in our library anymore, this is thrown
            return true;
        }
    }

    /*

     */
    public boolean returns(Book book) {

        int found = find(book);
        int index = findIndex(book);

        if (found == FOUND && books[index].isCheckedOut()) {
            books[index].setCheckedOut(false);
        }
        else if (index == -1 || books[index].isCheckedOut() == false) {
            return true;
        }
        return false;
    }

    /*

     */
    public void print() {
        System.out.println("**List of books in library.");
        if (numBooks == 0) {
            System.out.println("Library catalog is empty!");
        }
        for (int i = 0; i < numBooks; i++) {
            System.out.println(books[i]);
        }
        System.out.println("**End of list.");
    } //print the list of books in the bag

    /*

     */
    public void printByDate() {
        Book[] sortDate = new Book[books.length];
        System.out.println("**List of books by the date published.");
        if (numBooks == 0) {
            System.out.println("Library catalog is empty!");
        }
        for(int i =0; i < numBooks; i++) {
            sortDate[i] = books[i];
        }
        sortByDate(sortDate);
        for (int i = 0; i < numBooks; i++) {
            System.out.println(sortDate[i]);
            }
        System.out.println("**End of list.");
    } //print the list of books by datePublished (ascending)

    /*
    helper method for printByDate
     */
    public void sortByDate(Book[] sortDate) {

        for (int i = 0; i < numBooks-1; i++) {
            int index = i;
            for (int j = i +1; j < numBooks; j++){
            if (sortDate[i+1] == null) {
                break;
            }
            if (sortDate[j].compareByDate(sortDate[index]) == -1) {
                index = j;
            }
        }
            Book olderDate = sortDate[index];
            sortDate[index] = sortDate[i];
            sortDate[i] = olderDate;
        }

}

    public void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[index]) {
                    index = j;
                }
            }
            int smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }

    }

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





