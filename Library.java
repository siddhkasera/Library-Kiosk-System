public class Library {
    private static final int CAPACITY = 4;
    private static final int NOT_FOUND = -1;
    private Book[] books; // array-based implementation of the bag data structure private int numBooks;
    //books = new Book[CAPACITY]; //allocating memory for 4 books ...COME BACK TO THIS!!
    private int numBooks; // the number of books currently in the bag
    public static String serialNum = "10000";
    int serialNumInt = 10000;
    boolean bool1 = true;
    boolean bool2 = false;
    public Library() { //default constructor to create an empty bag
        //initialize books capacity to 4
        books = new Book[CAPACITY];
        numBooks = 0;
    }


    private int  findIndex(Book book) {
        System.out.println("in the find index method");
        for (int i = 0; i < numBooks; i++) {
            if (books[i].getNumber().equals(book.getNumber())){
                return i; //1 means it was found
            }

        }
        return NOT_FOUND;

    }
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

            //--RESOLVED -- QUESTION: how to set serial number to book? is this how it is done?
            book.setNumber(serialNum);
            //book.setDate(); //QUESTION: is this where i should do it? I don't think it'll be good to do it here.

            System.out.println("the serial num is:" + serialNum); //TESTING PURPOSES. must delete after or will lose points

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
        for(int i =0; i<books.length;i++){
            System.out.println(books[i]);
        }


    }
    private int find(Book book) {
        System.out.println("in the find method");
        int flag =0;
        // System.out.println("the removing book number is:"+ book.getNumber());
        for (int i = 0; i < numBooks; i++) {
            System.out.println("inside the for loop of find method");
            //
            //System.out.println(books[1].getNumber());
           /* System.out.println("I is:"+ i);
            String cmp1 = books[i].getNumber();
            System.out.println("BOOK1 IS:" + cmp1);
            String cmp2 = book.getNumber();
            System.out.println("BOOK2 IS:" + cmp2);
*/
            if(books[i].equals(book)){
                //System.out.println("Books found"+ books[i].getName());
                flag = 1;
                //return 1; //1 means it was found
            }
            else { //remove this else later!!!
                System.out.println("book not found");
            }
        }
        if(flag ==1){
            return 1;
        }
        return 0; //false by default

    } // helper method to find a book in the bag


    public boolean remove(Book book) {

        System.out.println("remove method was called");

        int found = find(book);
        int index = 0;
        if(found == 1) {
            System.out.println("inside the if found loop in remove");
            index = findIndex(book);

            System.out.println("Book# "+ book.getNumber()+" removed.");
            for(int i = index; i< books.length-1;i++) { //deleting the elements
                books[i] = books[i + 1];
            }
            numBooks--;
            return true;
        }
        //remove this later
        for(int j =0; j < numBooks;j++){
            System.out.println("the new book array is:"+ books[j].getName());
        }

        return false;
    }

    public boolean checkOut(Book book) {
        //String serialNum = "10001";
        int found = find(book);
        System.out.println("checkout method called");

        //1. Looking for a book in Library...
        if(found==1) {
            System.out.println("inside after found is 1");
            int index = findIndex(book);
            if (!book.isCheckedOut()){
                System.out.println("inside after checked out is checked!!");
                System.out.println("You've checked out Book#"+ book.getNumber()+". Enjoy!.");
                book.setCheckedOut(bool1);
                return true;
            }
        }else{
            System.out.println("Book#"+ book.getNumber()+ "not available");
        }
        return false;
    }

    //POSSIBLE ISSUE: this isn't returning a book back to our array I think
    public boolean returns(Book book) {

        System.out.println("return method called");
        //the serial number isn't being found here

        int found = find(book);

        if(found==1 && book.isCheckedOut()) {

            System.out.println("Book# "+ book.getNumber()+" return has completed.Thanks!");
            book.setCheckedOut(false);
            //return true;
        }
        return false;
    }

    public void print() {
        if(numBooks == 0){
            System.out.println("Library catalog is empty!");
        }
        for(int i =0; i<numBooks; i++) {
            System.out.println(books[i].getName());
        }
    } //print the list of books in the bag

    public void printByDate() {


    } //print the list of books by datePublished (ascending)
    /*
    public void printByNumber() { //print the list of books by number (ascending)
        if(numBooks == 0){
            System.out.println("Library catalog is empty!");


        }
        for (int i = 0; i < numBooks; i++) {
            if (Integer.parseInt(books[i].getNumber()) > Integer.parseInt(books[i + 1].getNumber())){
                books[i] = books[i + 1];
                System.out.println(books[i].getName());
            }
        }
    }
    */

}