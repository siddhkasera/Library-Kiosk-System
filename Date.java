/**
 This class defines the abstract data type Date which encapsulates the data fields and
 methods of a Date.
 @author Siddhi Kasera, Sonal Madhok
 */
import java.util.Calendar;
public class Date {
    private int year;
    private int month;
    private int day;
    public static final int QUADRENNIAL = 4;
    public static final  int CENTENNIAL = 100;
    public static final int QUATERCENTENNIAL = 400;
    public static final int month31 = 31;
    public static final int month30 = 30;
    public static final int month28 = 28;
    public static final int month29 = 29;

    /**
     * Takes mm/dd/yyyy and creates a Date object
     * @param date
     */

    public Date(String date) {
        String[] arrOfDate = date.split("/"); //Split the string from date variable
        String monthStr = arrOfDate[0];
        monthStr = monthStr.strip();

        month = Integer.parseInt(monthStr);
        day = Integer.parseInt(arrOfDate[1]);
        year = Integer.parseInt(arrOfDate[2]);

        this.month = month;
        this.day = day;
        this.year = year;
    }

    /**
     * No Parameter Constructor creates an object with today's date.
     */
    public Date () {
        Calendar today = Calendar.getInstance(); //gives instance of today's date

        this.day = today.DAY_OF_MONTH;
        this.month = today.MONTH;
        this.year = today.YEAR;

    }

    /**
     * returns the day instance variable
     * @return day
     */
    public int getDay() {
        return day;
    }
    /**
     * returns the month instance variable
     * @return day
     */
    public int getMonth() {
        return month;
    }
    /**
     * returns the year instance variable
     * @return day
     */
    public int getYear() {
        return year;
    }

    /**
     * Checks if the date entered is valid.
     * @return true if the date is valid with the correct day in a particular month for a year otherwise false
     */
    public boolean isValid() {
        boolean leap = false;
        int monthIncrement = 1;
        if(year < 1900 || year > 2021) {
            return false;
        }
        //checking is a year is leap year.
        if(year % QUADRENNIAL  == 0) {
            if(year % CENTENNIAL == 0) {
                if(year % QUATERCENTENNIAL  == 0) {
                    leap = true;
                }else {
                    leap = false;
                }
            }else {
                leap = true;
            }
        }else {
            leap = false;
        }

        //to check if day number is correct for a given month.
        switch(month) {

            case Calendar.JANUARY+1:
                if ( day < 1 || day > month31 ) {
                    return false;
                }
                break;
            case Calendar.FEBRUARY+1:
                if(leap) {
                    if(day <1 || day >  month29) {
                        return false;
                    }
                }else if(day < 1 || day >  month28) {
                    return false;
                }

                break;
            case Calendar.MARCH+1:
                if(day <1 || day > month31) {
                    return false;
                }
                break;
            case Calendar.APRIL+1:
                if(day <1 || day > month30) {
                    return false;
                }
                break;

            case Calendar.MAY+1:
                if(day <1 || day > month31) {
                    return false;
                }
                break;

            case Calendar.JUNE+1:
                if(day <1 || day >  month30) {
                    return false;
                }
                break;

            case Calendar.JULY+1:
                if(day <1 || day >  month31) {
                    return false;
                }
                break;

            case Calendar.AUGUST+1:
                if(day <1 || day >  month31) {
                    return false;
                }
                break;

            case Calendar.SEPTEMBER+1:
                if(day <1 || day >  month30) {
                    return false;
                }
                break;

            case Calendar.OCTOBER+1:
                if(day <1 || day >  month31) {
                    return false;
                }
                break;

            case Calendar.NOVEMBER+1:
                if(day <1 || day >  month30) {
                    return false;
                }
                break;
            case Calendar.DECEMBER+1:
                if(day <1 || day >  month31) {
                    return false;
                }
                break;

            default:
                return false;

        }


        return true;
    }
}

