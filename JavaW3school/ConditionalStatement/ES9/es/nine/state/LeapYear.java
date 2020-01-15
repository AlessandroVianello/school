package es.nine.state;

public class LeapYear {
    public String isLeap(int year){

        if (year < 0)
            return "Please insert a year that isn't a negative one";
        else
            if (year%400 == 0)
                return year + " is a leap year";
            else
                if (year%4 == 0)
                    return year + " is a leap year";
                else
                    return year + " isn't a leap year";
    }
}
