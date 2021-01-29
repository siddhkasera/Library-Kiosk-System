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
        this.date = date;
    }

    //we can typecast an obj to our own class
    //use equals method
    @Override
    public boolean equals(Object obj){
        if(this.number.equals(((Book) obj).number)){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public String toString(){
        String output = "Book#" + this.number + "::" + this.name + "::"+ this.date +"::"+ this.checkedOut;
        return output;
    }

}
