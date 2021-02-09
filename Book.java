/**
 This class defines the abstract data type Book which encapsulates the data fields and
 methods of a book.
 @author Siddhi Kasera, Sonal Madhok
 **/
public class Book{
    private String number;
    private String name;
    private boolean checkedOut;
    private Date datePublished;

    /**
     *  A four parameter Book constructor that initializes an Book object when it is created.
     * @param name attribute for a book object
     * @param number attribute for a book object
     * @param checkedOut attribute for a book object
     * @param datePublished attribute for a book object
     */
    public Book(String name, String number, boolean checkedOut, Date datePublished){
        this.setName(name);
        this.setNumber(number);
        this.setCheckedOut(checkedOut);
        this.setDate(datePublished);
    }

    /** A two parameter constructor that initializes an Book object.
     * @param name attribute for a book object
     * @param date attribute for a book object
     */
    public Book(String name, String date) {
        this.name = name;
        checkedOut = false;
        datePublished = new Date(date);
    }

    /**
     * A one parameter constructor that intializes an Book object.
     * @param serial number attribute for a book object
     */
    public Book(String serial){
        number=serial;
        name = null;
        checkedOut = false;
        datePublished = null;
    }
    /**
     * Returns the name instance variable
     * @return name attribute for a Book object
     */
    public String getName(){
        return this.name;

    }
    /**
     * Returns the number instance variable
     * @return number attribute of a Book object
     */
    public String getNumber(){
        return this.number;
    }
    /**
     * Returns the checkedOut instance variable
     * @return checkedOut attribute of Book object
     */
    public boolean isCheckedOut(){
        return this.checkedOut;
    }
    /**
     * Returns the datePublished instance variable
     *@return datePublished  attribute of Book object
     */
    public Date getDate(){
        return this.datePublished;
    }
    /**
     * Sets the name instance variable
     * @param name attribute is set for a given object
     */
    public void setName(String name){
        this.name = name;
    }
    /**
     * Sets the number instance variable
     * @param number attribute is set for a given book object
     */
    public void setNumber(String number){
        this.number = number;
    }
    /**
     * Sets the checkedOut instance variable
     * @param checkedOut attricute is set for a given book object
     */
    public void setCheckedOut(boolean checkedOut){
        this.checkedOut = checkedOut;
    }
    /**
     * Sets the date instance variable
     * @param  date attribute is set for a given book object
     */
    public void setDate(Date date){
        this.datePublished = date;
    }

    /**
     * Returns true if this book number is equal to the argument book number.
     * @param obj the other book
     * @return {@code true} if this book has the same number as {@code obj};
     * {@code false} otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Book) {
            Book book = (Book) obj;
            return this.number.equals(book.number);
        }
        return false;
    }

    /**
     * Returns a string representation of this book.
     * @return a string representation of this book.
     */
    @Override
    public String toString(){

        if (isCheckedOut()) {
            String number = this.number;
            String name = this.name;
            String month = String.valueOf(datePublished.getMonth()); //stores month of a date as a string
            String day = String.valueOf(datePublished.getDay());//stores day of a date as a string
            String year= String.valueOf(datePublished.getYear());//stores year of a date as a string


            return "Book#" + number + "::" + name + "::"+ month+"/"+ day
                    +"/"+ year +"::"+ "is checked out.";

        }
        else {
            return "Book#" + this.number + "::" + this.name + "::"+ String.valueOf(datePublished.getMonth())+"/"+String.valueOf(datePublished.getDay())
                    +"/"+ String.valueOf(datePublished.getYear()) +"::"+ "is available.";
        }

    }

}