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
    public static final int startYear = 1990;
    public static final int endYear = 2021;




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

        day = today.get(Calendar.DAY_OF_MONTH);
        month = today.get(Calendar.MONTH)+ 1;
        year =  today.get(Calendar.YEAR);

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
        if(year < startYear || year > endYear) {
            return false;
        }

        Date futureDate = new Date();
        int newDay = futureDate.getDay();
        int newMonth = futureDate.getMonth();
        int newYear = futureDate.getYear();
        if(year == newYear){
            if(month == newMonth){
                if(day <= newDay){
                    return true;
                }else{
                    return false;
                }
            }else{
                return false;
            }
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

            case Calendar.JANUARY+ 1:
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

class MainTest{
    public static void main(String[] args) {
        /********** FUTURE DATE TESTING  **********/
         System.out.println("Future Date Testing for 03/20/2021");
         Date futureDate = new Date("03/20/2021");
         System.out.println("isValid() returns: " + futureDate.isValid());
         System.out.println("Expected result: false" + "\n");

        System.out.println("Future Date Testing for 03/20/2023");
        Date futureDate1 = new Date("03/20/2023");
        System.out.println("isValid() returns: " + futureDate.isValid());
        System.out.println("Expected result: false" + "\n");


        System.out.println("Testing for 13/1/2018");
        Date test1 = new Date("13/1/2018");
        System.out.println("isValid() returns:" + test1.isValid());
        System.out.println("Expected result: false" + "\n");

        System.out.println("Testing for 12/2/2019");
        Date test2 = new Date("12/2/2019");
        System.out.println("isValid() returns:" + test2.isValid());
        System.out.println("Expected result: true" + "\n");

        System.out.println("Testing for 02/29/2004");
        Date test3 = new Date("02/29/2004");
        System.out.println("isValid() returns:" + test3.isValid());
        System.out.println("Expected result: true" + "\n");

        System.out.println("Testing for 02/30/2004");
        Date test4 = new Date("02/30/2004");
        System.out.println("isValid() returns:" + test4.isValid());
        System.out.println("Expected result: false" + "\n");

        System.out.println("Testing for 12/32/2014");
        Date test5 = new Date("12/32/2014");
        System.out.println("isValid() returns:" + test5.isValid());
        System.out.println("Expected result: false" + "\n");

        System.out.println("Testing for 12/01/1899");
        Date test6 = new Date("12/01/1899");
        System.out.println("isValid() returns:" + test6.isValid());
        System.out.println("Expected result: false" + "\n");

        System.out.println("Testing for 2/32/2018");
        Date test7 = new Date("2/32/2018");
        System.out.println("isValid() returns:"+ test7.isValid());
        System.out.println("Expected result: false" + "\n");

        System.out.println("Testing for 02/00/2018");
        Date test8 = new Date("02/00/2018");
        System.out.println("isValid() returns:"+ test8.isValid());
        System.out.println("Expected result: false" + "\n");

        System.out.println("Testing for 02/01/2018");
        Date dayTest3 = new Date("02/01/2018");
        System.out.println("isValid() returns:"+ dayTest3.isValid());
        System.out.println("Expected result: true"+"\n");


    }

}
