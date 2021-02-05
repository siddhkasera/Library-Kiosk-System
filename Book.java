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
            return book.number.equals(this.number);

            //use the formatting in the notes. on canvas. click modules. under week #2 2.1 additional notes for project 1.-- use that
            //scroll to the bottom and write the equals method in that way.
        }
        return false;
    }

    @Override
    public String toString(){

        if (isCheckedOut()) {
            return "Book#" + this.number + "::" + this.name + "::"+ String.valueOf(datePublished.getMonth())+"/"+String.valueOf(datePublished.getDay())
                    +"/"+ String.valueOf(datePublished.getYear()) +"::"+ "is checked out.";

        }
        else {
            return "Book#" + this.number + "::" + this.name + "::"+ String.valueOf(datePublished.getMonth())+"/"+String.valueOf(datePublished.getDay())
                    +"/"+ String.valueOf(datePublished.getYear()) +"::"+ "is available.";
            }

    }

}
