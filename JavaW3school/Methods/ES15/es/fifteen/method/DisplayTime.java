package es.fifteen.method;
import java.time.LocalDateTime;

public class DisplayTime {
    String[] months = {"January","February","March","April","May","June","July","August","September","October","November","December"};
    String[] days = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
    int[] monthCode = {0,3,3,6,1,4,6,2,5,0,3,5};
    LocalDateTime date;
    int month,day,year,centuryCode;
    String time;

    public DisplayTime(){
        date= LocalDateTime.now();
        month=date.getMonthValue();
        day=date.getDayOfMonth();
        year=date.getYear();
        time=date.getHour()+":"+date.getMinute()+":"+date.getSecond();
        if(year<2000)
            centuryCode=0;
        else
            centuryCode=6;
    }

    //Formula: (Year Code + Month Code + Century Code + Date Number - Leap Year Code)mod 7
    //-1 if January or February of a leap year

    private int getYearCode(){
        return ((year%100)+((year%100)/4))%7;
    }

    private boolean isLeap(){
        boolean leap;
        if(year % 4 == 0)
        {
            if( year % 100 == 0)
            {
                if ( year % 400 == 0)
                    leap = true;
                else
                    leap = false;
            }
            else
                leap = true;
        }
        else
            leap = false;

        return leap;
    }

    public String getDay(){
        String dayOfWeek;
        if(isLeap() && (month==1 || month==2)){
            dayOfWeek=days[((getYearCode()+monthCode[month-1]+centuryCode+day-1)%7)];
        }
        else
            dayOfWeek=days[((getYearCode()+monthCode[month-1]+centuryCode+day)%7)];
        return dayOfWeek;
    }

    public String displayDate(){
        return "Current date and time: "+getDay()+" "+months[month-1]+" "+day+", "+year+" "+time;
    }

}
