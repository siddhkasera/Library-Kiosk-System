import java.time.Month;
import java.util.Calendar;
//mentions that we cannot add other data members..does that mean we cannot add
// the parameters in the isValid function?? stupid question
public class Date {
    private int year;
    private int month;
    private int day;

    public Date(String date) { //taking mm/dd/yyyy and create a Date object


        //split the string from date variable in here
        String[] arrOfDate = date.split("/");

        String monthStr = arrOfDate[0];
        String dayStr = arrOfDate[1];
        String yearStr = arrOfDate[2];

        monthStr = monthStr.strip();

        /* TESTING PURPOSES:
        System.out.println(monthStr);
        System.out.println(dayStr);
        System.out.println(yearStr);
        */

        //assigning the day, month, year -- turning the string into integer so the Date underneath can use it
        month = Integer.parseInt(monthStr); //--RESOLVED -- QUESTION: This also creates an error NumberFormatException. Why is that happening?
        day = Integer.parseInt(arrOfDate[1]);
        year = Integer.parseInt(arrOfDate[2]);

        //TESTING PURPOSES:
        System.out.println(month);
        System.out.println(day);
        System.out.println(year);

        this.month = month;
        this.day = day;
        this.year = year;

        //use isValid function to see if date is valid
        //isValid(day, month, year);

    }

    public Date () // create object with today's date (see Calendar class)
    {
        //use the calendar class, getInstance() will give today's information
        Calendar today = Calendar.getInstance(); //gives instance of today's information

        this.day = today.DAY_OF_MONTH;
        this.month = today.MONTH;
        this.year = today.YEAR;

    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public boolean isValid() //check this
    {  //check whether the date is valid or not.
        //check the months(no of days) leap year etc
        boolean leap = false;
        if(year < 1900 || year > 2021) {
            return false;
        }

        if(year % 4 == 0) { //step 1
            if(year %100 == 0) { //step 2
                if(year % 400 == 0) { //step 3
                    leap = true; //step 4
                }else {
                    leap = false; //step 5
                }
            }else {
                leap = true; //step 4
            }
        }else {
            leap = false; // step5
        }

        //we can use our own algo here
        switch(month) {

            case 1: //we have to change this 1 to JAN or something -- rn its a magic number.. any number that is reference must have a variable or else its a magic number
                if ( day < 1 || day > 31 ) {
                    return false;
                }
                break;
            case 2:
                if(leap) {
                    if(day <1 || day > 29) {
                        return false;
                    }
                }else if(day < 1 || day > 28) {
                    return false;
                }

                break;
            case 3:
                if(day <1 || day > 31) {
                    return false;
                }
                break;
            case 4:
                if(day <1 || day > 30) {
                    return false;
                }
                break;

            case 5:
                if(day <1 || day > 31) {
                    return false;
                }
                break;

            case 6:
                if(day <1 || day > 30) {
                    return false;
                }
                break;

            case 7:
                if(day <1 || day > 31) {
                    return false;
                }
                break;

            case 8:
                if(day <1 || day > 31) {
                    return false;
                }
                break;

            case 9:
                if(day <1 || day > 30) {
                    return false;
                }
                break;

            case 10:
                if(day <1 || day > 31) {
                    return false;
                }
                break;
            case 11:
                if(day <1 || day > 30) {
                    return false;
                }
                break;
            case 12:
                if(day <1 || day > 31) {
                    return false;
                }
                break;

            default:
                return false;

        }


        return true;
    }
}



/**
 * recitation notes: 2/1/21
 * the date has two constructors
 *
 * 1) transform the strings into integers
 * 2) you assign an input
 *
 * we can use getDate() or getTime() from Calendar class
 *
 * String date may have a lot of invalid inputs
 * checking constructor if it is a valid date for input
 * you need the date for the library and book class
 *
 * the date object itself
 * professor is going to test isValid() the most because that is the only one she is choosing to check for testing
 *
 * you can use system.out.print in the testbed
 * instead of using system.out you can also use the boolean values
 *
 *StdRandom.uniform(SUITES.length)
 *
 *
 */

