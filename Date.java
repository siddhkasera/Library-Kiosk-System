import java.util.Calendar;

public class Date {
    private int year;
    private int month;
    private int day;

    public Date(String date) { //taking mm/dd/yyyy and create a Date object

        this.setDate(day, month, year);

    }

    public String setDate(int day, int month, int year){
        //Calendar.
    }

    public Date () // create object with today's date (see Calendar class)
    {
    }

    public boolean isValid()
    {
        return true;
    }
}



