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
            if (books[i].getNumber().equals(book.getNumber())){
                return i; //1 means it was found
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

        for(int i = START; i < oldLength; i++) {
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
            if(books[i].getNumber().equals(book.getNumber())){
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

/*

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

/*

*/
    public boolean returns(Book book) {

        int found = find(book);
        int index = findIndex(book);

        if(found==FOUND && books[index].isCheckedOut()) {
            System.out.println("Book# "+ book.getNumber()+" return has completed.Thanks!");
            books[index].setCheckedOut(false);
        }
        return false;
    }


/*

*/
    public void print() {
        System.out.println("**List of books in library.");
        if(numBooks == 0){
            System.out.println("Library catalog is empty!");
        }
        for(int i =0; i<numBooks; i++) {
            System.out.println(books[i]);
        }
        System.out.println("**End of list.");
    } //print the list of books in the bag

    public void printByDate() {

        System.out.println("**List of books by the date published.");
        int month = datePublished.getMonth();
        int day = datePublished.getDay();
        int year = datePublished.getYear();

        String date = String.valueOf(month) + "/" + String.valueOf(day) + "/" + String.valueOf(year);

            if(numBooks == START){
                System.out.println("Library catalog is empty!");
            }
            for(int i =START; i<numBooks; i++) {
                //
                System.out.println(books[i]);
            }
        System.out.println("**End of list.");
        } //print the list of books by datePublished (ascending)

/*    

*/
    public void printByNumber() { //print the list of books by number (ascending)
        System.out.println("**List of books by the book numbers.");
        if(numBooks == 0){
            System.out.println("Library catalog is empty!");
        }
        for (int i = 0; i < numBooks; i++) {
            if (Integer.parseInt(books[i].getNumber()) > Integer.parseInt(books[i + 1].getNumber())){
                books[i] = books[i + 1];
                System.out.println(books[i]);
            }
        }
        System.out.println("**End of list.");
    }
}


