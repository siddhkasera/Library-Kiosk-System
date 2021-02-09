//this is our ADT

public class Book{
    private String number;
    private String name;
    private boolean checkedOut;
    private Date datePublished;

    //constructors....
    public Book(String name, String number, boolean checkedOut, Date datePublished){
        this.setName(name);
        this.setNumber(number);
        this.setCheckedOut(checkedOut);
        this.setDate(datePublished);
    }

    public Book(String name, String date) {
        this.name = name;
        checkedOut = false;
        datePublished = new Date(date);
    }

    public Book(String serial){
        number=serial;
        name = null;
        checkedOut = false;
        datePublished = null;
    }


    public String getName(){
        return this.name;

    }
    public String getNumber(){
        return this.number;
    }

    public boolean isCheckedOut(){
        return this.checkedOut;
    }

    public Date getDate(){
        return this.datePublished;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setNumber(String number){
        this.number = number;
    }
    public void setCheckedOut(boolean checkedOut){
        this.checkedOut = checkedOut;
    }
    public void setDate(Date date){
        this.datePublished = date;
    }

    //we can typecast an obj to our own class
    //use equals method
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Book) {
            Book book = (Book) obj;
            return this.number.equals(book.number);
        }
        return false;
    }

    public int compareByDate(Book book) {

        //-1 is less than
        // 0 is equal
        //1 is greater than
        //-2 means it didn't hit any case

        if (datePublished.getYear() < book.datePublished.getYear()) {
            return -1;
        } else if (datePublished.getYear() == book.datePublished.getYear()) {
            if (datePublished.getMonth() < book.datePublished.getMonth()) {
                return -1;
            } else if (datePublished.getMonth() == book.datePublished.getMonth()) {
                if (datePublished.getDay() < book.datePublished.getDay()) {
                    return -1;
                } else if (datePublished.getDay() == book.datePublished.getDay()) {
                    return 0; //this date is equal to the date being compared
                } else if (datePublished.getDay() > book.datePublished.getDay()) {
                    return 1;
                }

            } else if (datePublished.getMonth() > book.datePublished.getMonth()) {
                return 1;
            }

        }
        else if (datePublished.getYear() > book.datePublished.getYear()){
            return 1;
        }
        return -2;
    }


    @Override
    public String toString(){

        if (isCheckedOut()) {
            String number = this.number;
            String name = this.name;
            String month = String.valueOf(datePublished.getMonth());
            String day = String.valueOf(datePublished.getDay());
            String year= String.valueOf(datePublished.getYear());

            return "Book#" + number + "::" + name + "::"+ month+"/"+ day
                    +"/"+ year +"::"+ "is checked out.";
        }
        else {
            return "Book#" + this.number + "::" + this.name + "::"+ String.valueOf(datePublished.getMonth())+"/"+String.valueOf(datePublished.getDay())
                    +"/"+ String.valueOf(datePublished.getYear()) +"::"+ "is available.";
        }
    }
}
