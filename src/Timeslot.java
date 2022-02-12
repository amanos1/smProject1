package src;


public class Timeslot {

    private Date date;
	private Time time;
	
	//By default it's set to today's date and current time
	public Timeslot() 
	{
		this.date = new Date();
		this.time = new Time();
	}
	
	public Timeslot(Date d, Time t) 
	{
		Date date = new Date();
		Time time = new Time();
		date.setDay(d.getDay());
		date.setMonth(d.getMonth());
		date.setYear(d.getYear());
		time.setHour(t.getHour());
		time.setMinute(t.getMinute());
		this.date = date;
		this.time = time;
	}
	
	public Timeslot(int month, int day, int year, int hour, int minute) 
	{
		this.date = new Date(month, day, year);
		this.time = new Time(hour, minute);
	}

	public Timeslot(String h, String m) {
		this.date = new Date(h);
		this.time = new Time(m);
	}

	public Timeslot(Timeslot ts)
	{
		this.date = new Date(ts.date);
		this.time = new Time(ts.time);
	}
	
	public int getHour() 
	{
		int h = this.time.getHour();
		return h;
	}
	
	public int getMinute() 
	{
		int m = this.time.getMinute();
		return m;
	}
	
	public Date getDate() 
	{
		Date temp = new Date(this.date.getMonth(),this.date.getDay(),this.date.getYear());
		return temp;
	}
	
	public Time getTime() {
		Time temp  = new Time(this.time.getHour(), this.time.getMinute());
		return temp;
	}
	
	public void setHour(int h) 
	{
		this.time.setHour(h);
	}
	
	public void setMinute(int m) 
	{
		this.time.setMinute(m);
	}

	public boolean equals(Timeslot ts)
	{
		return compareTo(ts) == 0;
	}

	//this is new appointment
	public int compareTo(Timeslot ts) 
	{
		final int TIME_INTERVAL = 15;
		if((this.getDate().compareTo(ts.getDate())) == 0 )
		{
			if(this.getMinute() >= (ts.getMinute()-TIME_INTERVAL) && this.getMinute() <= (ts.getMinute()+TIME_INTERVAL)) 
			{
				return 0;
			}
		}
		return 2;
	}

	public String toString() 
	{
		return date.toString() + " " + time.toString();
	}
	
	public static void main(String[] args)
	{
		Timeslot t1;
		Timeslot t2;

		//test case 1
		t1 = new Timeslot("2/20/1984", "4:20");
		t2 = new Timeslot("2/20/1985", "4:20");
		System.out.println(t1.compareTo(t2));

		//test case 2
		t1 = new Timeslot("2/20/1984", "4:20");
		t2 = new Timeslot("2/20/1983", "4:20");
		System.out.println(t1.compareTo(t2));

		//test case 3
		t1 = new Timeslot("2/20/1984", "4:20");
		t2 = new Timeslot("3/20/1984", "4:20");
		System.out.println(t1.compareTo(t2));

		//test case 4
		t1 = new Timeslot("3/20/1984", "4:20");
		t2 = new Timeslot("2/20/1984", "4:20");
		System.out.println(t1.compareTo(t2));

		//test case 5
		t1 = new Timeslot("2/19/1984", "4:20");
		t2 = new Timeslot("2/20/1984", "4:20");
		System.out.println(t1.compareTo(t2));

		//test case 6
		t1 = new Timeslot("2/20/1984", "4:20");
		t2 = new Timeslot("2/19/1984", "4:20");
		System.out.println(t1.compareTo(t2));

		//test case 7
		t1 = new Timeslot("2/20/1984", "3:20");
		t2 = new Timeslot("2/20/1984", "4:20");
		System.out.println(t1.compareTo(t2));

		//test case 8
		t1 = new Timeslot("2/20/1984", "4:20");
		t2 = new Timeslot("2/20/1984", "3:20");
		System.out.println(t1.compareTo(t2));

		//test case 9
		t1 = new Timeslot("2/20/1984", "4:19");
		t2 = new Timeslot("2/20/1984", "4:20");
		System.out.println(t1.compareTo(t2));

		//test case 10
		t1 = new Timeslot("2/20/1984", "4:20");
		t2 = new Timeslot("2/20/1984", "4:19");
		System.out.println(t1.compareTo(t2));

		//test case 11
		t1 = new Timeslot("2/20/1984", "4:20");
		t2 = new Timeslot("2/20/1984", "4:20");
		System.out.println(t1.compareTo(t2));
	}
}
