public class Library {
    private static final int CAPACITY = 4;
    private Book[] books; // array-based implementation of the bag data structure private int numBooks;
    //books = new Book[CAPACITY]; //allocating memory for 4 books ...COME BACK TO THIS!!
    private int numBooks; // the number of books currently in the bag

    public Library() { //default constructor to create an empty ba
        books = new Book[CAPACITY];
        numBooks = 0;
    }

    private int find(Book book) {

        for (int i = 0; i < numBooks; i++) {
            if (books[i].getNumber().compareTo(book.getNumber()) == 0) {
                return 1; //1 means it was found
            }
            else {
                return 0; //0 means it wasn't found
            }
        }
        return 0; //false by default
    } // helper method to find a book in the bag

    private void grow() { } // helper method to grow the capacity by 4
    
    public void add(Book book) {
       //TODO working on this now 

    }
    public boolean remove(Book book) {
        return false;
    }
    public boolean checkOut(Book book) {
        return false;
    }
    public boolean returns(Book book) {
        return false;
    }
    public void print() { } //print the list of books in the bag
    public void printByDate() { } //print the list of books by datePublished (ascending) public void printByNumber() { } //print the list of books by number (ascending)


}
