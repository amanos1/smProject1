package src;
import java.util.Calendar;

public class Date implements Comparable<Date>{

    private int year;
    private int month;
    private int day;
    Calendar calendar = Calendar.getInstance();

    public Date(String date)
    {
        month = Integer.parseInt(date.substring(0,2));
        day = Integer.parseInt(date.substring(3,5));
        year = Integer.parseInt(date.substring(6));
    }

    public Date(Date d) {
        month = d.getMonth();
        day = d.getDay();
        year = d.getYear();
    }

    public Date(int m, int d, int y)
    {
        month = m;
        day = d;
        year = y;
    }

    public Date()
    {
        month  = calendar.get(Calendar.MONTH);
        year = calendar.get(Calendar.YEAR);
        day = calendar.get(Calendar.DATE);
    }

    public int getDay()
    {
        int d = day;
        return d;
    }

    public int getMonth()
    {
        int m = month;
        return m;
    }

    public int getYear()
    {
        int y = year;
        return y;
    }

    public void setDay(int d)
    {
        this.day = d;
    }

    public void setMonth(int m)
    {
        month = m;;
    }


    public void setYear(int y)
    {
        year = y;
    }


    public boolean isValid()
    {
        final int TOTAL_MONTH = 12;
        final int MIN_MONTH = 1;
        final int TOTAL_MONTH_DAYS = 31;
        boolean leapYear = isLeapYear(this.year);

        if(this.month > TOTAL_MONTH || this.month < MIN_MONTH) {
            return false;
        }else if((this.month <= Month.JUN && this.month % 2 != 0) ||
                (this.month >= Month.AUG && this.month % 2 == 0)) //MONTHS WITH 31 DAYS
        {
            if(this.day > TOTAL_MONTH_DAYS)
            {
                return false;
            }
        }else if(!leapYear && this.month == Month.FEB)
        {
            if(this.day>TOTAL_MONTH_DAYS-3)
            {
                return false;
            }else
            {
                return true;
            }
        }else if((this.month <= Month.JUN && this.month % 2 == 0) ||
                (this.month >= Month.SEP && this.month %2 != 0)) //MONTHS WITH 28 DAYS
        {
            if(this.day > TOTAL_MONTH_DAYS-1)
            {
                return false;
            }
        }
        return true;
    }

    public boolean isLeapYear(int y)
    {
        final int QUADRENNIAL = 4;
        final int CENTENNIAL = 100;
        final int QUATERCENTENNIAL = 400;
        if(y % QUADRENNIAL == 0)
        {
            if(y % CENTENNIAL == 0)
            {
                if(y % QUATERCENTENNIAL == 0)
                {
                    return true;
                }else
                {
                    return false;
                }
            }else
            {
                return true;
            }
        }else
        {
            return false;
        }

    }

    public boolean equals(Date date)
    {
        if(date instanceof Date)
        {
            if(this.day == date.day && this.month == date.month &&
                    this.year == date.year)
            {
                return true;
            }else
            {
                return false;
            }
        }else {
            return false;
        }
    }

    public int compareTo(Date date)
    {
        if(this.equals(date)) {
            return 0;
        }
        if(this.year == date.year)
        {
            if(this.month == date.month)
            {
                if(this.day == date.day)
                {
                    return 0;
                }else if(this.day > date.day)
                {
                    return 1;
                }else
                {
                    return -1;
                }
            }else if(this.month == date.month)
            {
                return 0;
            }else if(this.month > date.month) {
                return 1;
            }else {
                return 1;
            }
        } else if(this.year == date.year)
        {
            return 0;
        }else if(this.year > date.year)
        {
            return 1;
        }else
        {
            return -1;
        }
    }

    public String toString()
    {
        String m = "0" ,d = "0" ,y = "";
        if(month < 10)
        {
            m += month;
        }else
        {
            m = ""+month;
        }
        if(day < 10) {
            d += day;
        }else
        {
            d = ""+day;
        }
        y = ""+year;
        return m+"/"+d+"/"+y;
    }

}
