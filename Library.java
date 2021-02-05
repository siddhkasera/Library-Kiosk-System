public class Library {
    private static final int CAPACITY = 4;
    private static final int NOT_FOUND = -1;
    private static final int FOUND = 1;
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

    private int findIndex(Book book) {
        System.out.println("in the find index method");
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

        for(int i = 0; i <oldLength; i++) {
            book1[i] = books[i];
        }
        books = book1;
    } // helper method to grow the capacity by 4

    //ADD and REMOVE seem to work.
    public void add(Book book) {

        System.out.println("in the add method");
        if ((numBooks + 1) <= books.length) {
            books[numBooks] = book;
            serialNumInt++;
            serialNum = String.valueOf(serialNumInt);
            book.setNumber(serialNum);

            System.out.println("the serial num is:" + serialNum); //TESTING PURPOSES. must delete all system.out in this class after or will lose points

        } else {
            this.grow();
            serialNumInt++;
            serialNum = String.valueOf(serialNumInt);
            book.setNumber(serialNum);
            books[numBooks] = book;
        }

        System.out.println(book.getName() + " added to the Library.");
        System.out.println("the length of the books is:" + books.length);

        numBooks++;
        for(int i =0; i < books.length;i++){
            System.out.println(books[i]);
        }

    }
    private int find(Book book) {
        System.out.println("in the find method");
        //int flag =0;
        // System.out.println("the removing book number is:"+ book.getNumber());
        for (int i = 0; i < numBooks; i++) {
            System.out.println("inside the for loop of find method");
            //
            //System.out.println(books[1].getNumber());
            System.out.println("I is:"+ i);
            String cmp1 = books[i].getNumber();
            System.out.println("BOOK1 IS:" + cmp1);
            String cmp2 = book.getNumber();
            System.out.println("BOOK2 IS:" + cmp2);

            //QUESTION: Not sure why we keep getting NullPointerException. What is going on?
            if (books[i].getNumber().equals(book.getNumber())){
                System.out.println("Books found"+ books[i].getName());
                //flag = 1;
                return 1; //1 means it was found
            }
            else {
                System.out.println("book not found");
                return 0; //0 means it wasn't found
            }
        }
        return 0; //false by default

    } // helper method to find a book in the bag

    //1 2 3 4 5
    //1 2   4 5
    //1 2 4 5 0
    public boolean remove(Book book) {

        System.out.println("remove method was called");

        int found = find(book);
        System.out.println(found);

        // System.out.println("after finding the book in remove");
        int index = 0;

        if(found == FOUND) {
            System.out.println("inside the if found loop in remove");
            index = findIndex(book);

            if (index == NOT_FOUND) {
                return true;
            }
            books[index].setName(null);
            books[index].setNumber(null);
            books[index].setDate(null);
            numBooks--;
            return true;
        }

        else {
            Book[] book1 = new Book[books.length];
            for (int i = index; i < books.length - 1; i++) {
                book1[i] = books[i + 1];
            }
            books = book1;
            //books[books.length] //check this.
            //what should the last index be changed to???

            return false;
        }
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
                System.out.println("You've checked out Book#"+ book.getNumber()+". Enjoy!."); //delete this after library class is done
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
            System.out.println("Book# "+ book.getNumber()+" return has completed. Thanks!");
            book.setCheckedOut(false);
            //return true;
        }
        return true;
    }

    public void print() {
        for(int i =0; i<books.length; i++) {
            System.out.println(books[i].getName());
        }
    } //print the list of books in the bag

    public void printByDate() {


    } //print the list of books by datePublished (ascending)
    public void printByNumber() {

    } //print the list of books by number (ascending)


}
