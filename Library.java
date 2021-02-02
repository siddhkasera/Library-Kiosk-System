public class Library {
    private static final int CAPACITY = 4;
    private static final int NOT_FOUND = -1;
    private Book[] books; // array-based implementation of the bag data structure private int numBooks;
    //books = new Book[CAPACITY]; //allocating memory for 4 books ...COME BACK TO THIS!!
    private int numBooks; // the number of books currently in the bag
    public static String serialNum = "10000";
    int serialNumInt = 10000;

    public Library() { //default constructor to create an empty bag
        //initialize books capacity to 4
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
    private int  findIndex(Book book) {
        for (int i = 0; i < numBooks; i++) {
            if (books[i].getNumber().compareTo(book.getNumber()) == 0) {
                return i; //1 means it was found
            }

        }
        return NOT_FOUND;

    }
    /*
      private void sortbyDate(Book books) {
      }
      private void sortbyNumber(Book books) {
      }
      */
    private void grow() {
        //Kiosk obj = new Kiosk();
        int oldLength = books.length;
        int newLength = oldLength + CAPACITY;
        Book[] book1 = new Book[newLength];

        for(int i = 0; i <newLength; i++) {
            book1[i] = books[i];
        }
        books = book1;
    } // helper method to grow the capacity by 4

//ADD and REMOVE seem to work.
    public void add(Book book) {

        if ((numBooks + 1) <= books.length) {
            books[numBooks] = book;
            serialNumInt++;
            serialNum = String.valueOf(serialNumInt);

            //--RESOLVED -- QUESTION: how to set serial number to book? is this how it is done?
            book.setNumber(serialNum);
           //book.setDate(); //QUESTION: is this where i should do it? I don't think it'll be good to do it here.

            System.out.println(serialNum); //TESTING PURPOSES. must delete after or will lose points

        } else {
            this.grow();
            books[numBooks] = book;
        }

        System.out.println(book.getName()+" added to the Library.");

        numBooks++;


        }


    //1 2 3 4 5
    //1 2   4 5
    //1 2 4 5 0
    public boolean remove(Book book) {
        //String serialNum = "10001";
        //1. Looking for a book in Library...

        System.out.println("remove method was called");

        int found = find(book);
        int index = 0;
        if(found == 1) {
            index = findIndex(book);

            System.out.println("Book# "+ book.getNumber()+" removed.");
            books[index].setName(null);
            books[index].setNumber(null);
            books[index].setDate(null);
            numBooks--;
            //return true;
        }
        Book [] book1 = new Book[books.length];
        for(int i = index; i < books.length-1; i++) {
            book1[i] = books[i+1];
        }
        books = book1;
        //books[books.length] //check this.
        //what should the last index be changed to???

        return false;
    }

    public boolean checkOut(Book book) {
        //String serialNum = "10001";
        int found = find(book);
        System.out.println("checkout method called");

        //1. Looking for a book in Library...
        if(found==1) {
            int index = findIndex(book);
            if(book.getNumber().equals(serialNum) && (!book.isCheckedOut())) {
                //return true;
                System.out.println("You've checked out Book#"+ book.getNumber()+". Enjoy!.");
                books[index].setCheckedOut(true);
                // removedAt = i;
            }
        }
        return false;
    }

//POSSIBLE ISSUE: this isn't returning a book back to our array I think
    public boolean returns(Book book) {

        System.out.println("return method called");
        //the serial number isn't being found here

        int found = find(book);
        if(found == 1 && book.isCheckedOut()) {

            System.out.println("Book# "+ book.getNumber()+" return has completed.Thanks!");
            book.setCheckedOut(false);
            //return true;
        }
        return false;
    }

    public void print() {
        for(int i =0; i<books.length; i++) {
            System.out.println(books[i].getName());
        }
    } //print the list of books in the bag

    public void printByDate() {


    } //print the list of books by datePublished (ascending)
    public void printByNumber() { } //print the list of books by number (ascending)


}
