package src;
import java.util.Calendar;

public class Date implements Comparable<Date>{

   private int year;
	private int month;
	private int day;
	Calendar calendar = Calendar.getInstance();
	
	public Date() 
	{
		this.month  = calendar.get(Calendar.MONTH);
		this.year = calendar.get(Calendar.YEAR);
		this.day = calendar.get(Calendar.DATE);
	}

    public Date(String date)
    {
    	String[] dateElements = date.split("/");
        month = Integer.parseInt(dateElements[0]);
        day = Integer.parseInt(dateElements[1]);
        year = Integer.parseInt(dateElements[2]);
    }

	public Date(Date d) {
		this.month = d.getMonth();
		this.day = d.getDay();
		this.year = d.getYear();
	}

	public Date(int m, int d, int y) 
	{
		this.month = m;
		this.day = d;
		this.year = y;
	}

	public int getDay() 
	{
		int d = this.day;
		return d;
	}

	public int getMonth() 
	{
		int m = this.month;
		return m;
	}

	public int getYear() 
	{
		int y = this.year;
		return y;
	}

	public void setDay(int d) 
	{
		this.day = d;
	}

	public void setMonth(int m) 
	{
	    this.month = m;
	}

	public void setYear(int y) 
	{
		this.year = y;
	}

	public boolean isValid()
	{
		final int TOTAL_MONTH = 12;
		final int MIN_MONTH = 1;
		final int TOTAL_FEB_DAYS = 28;
		final int TOTAL_FEB_LEAP_DAYS = 29;
		final int TOTAL_AJSN_DAYS = 30;
		final int TOTAL_MONTH_DAYS = 31;
		boolean leapYear = isLeapYear(year);
		Calendar today = Calendar.getInstance();

		if(year < 1900 || year > today.get(Calendar.YEAR)) return false;

		if(month > TOTAL_MONTH || month < MIN_MONTH) return false;

		if(day < 1) return false;
		if(month == Month.FEB)
		{
			if(leapYear)
			{
				if(day > TOTAL_FEB_LEAP_DAYS) return false;
			} else
			{
				if(day > TOTAL_FEB_DAYS) return false;
			}
		} else if(month == Month.APR || month  == Month.JUN || month == Month.SEP || month == Month.NOV) //MONTHS WITH 30 DAYS
		{
			if(day > TOTAL_AJSN_DAYS) return false;
		} else  //MONTHS WITH 31 DAYS
		{
			if(this.day > TOTAL_MONTH_DAYS) return false;
		}

		return true;
	}

	private boolean isLeapYear(int y) 
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
		return compareTo(date) == 0;
	}

	public int compareTo(Date date)
	{
		if(year > date.getYear()) return 1;
		else if(year < date.getYear()) return -1;
		if(month > date.getMonth()) return 1;
		else if(month < date.getMonth()) return -1;
		if(day > date.getDay()) return 1;
		else if(day < date.getDay()) return -1;
		return 0;
	}

	public String toString()
	{
		return month + "/" + day + "/" + year;
	}

	public static void main(String[] args)
	{
		Date d;

		//test case 1
		d = new Date("5/22/1883");
		System.out.println(d.isValid());

		//test case 2
		d = new Date("16/3/1984");
		System.out.println(d.isValid());

		//test case 3
		d = new Date("0/15/2002");
		System.out.println(d.isValid());

		//test case 4
		d = new Date("2/29/1993");
		System.out.println(d.isValid());

		//test case 5
		d = new Date("2/-1/1993");
		System.out.println(d.isValid());

		//test case 6
		d = new Date("2/31/1984");
		System.out.println(d.isValid());

		//test case 7
		d = new Date("6/31/2000");
		System.out.println(d.isValid());

		//test case 8
		d = new Date("6/0/2000");
		System.out.println(d.isValid());

		//test case 9
		d = new Date("12/500/1994");
		System.out.println(d.isValid());

		//test case 10
		d = new Date("12/0/1994");
		System.out.println(d.isValid());

		//test case 11
		d = new Date("3/3/2019");
		System.out.println(d.isValid());
	}
}
