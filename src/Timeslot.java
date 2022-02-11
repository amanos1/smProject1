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
		this.date.setMonth(month);
		this.date.setDay(day);
		this.date.setYear(year);
		this.time.setHour(hour);
		this.time.setMinute(minute);
		this.date = date;
		this.time = time;

	}
	
	public Timeslot(String h, String m) {
		this.date.setMonth(Integer.parseInt(h.substring(0,2)));
		this.date.setDay(Integer.parseInt(h.substring(3,5)));
		this.date.setYear(Integer.parseInt(h.substring(6)));
		this.time.setHour(Integer.parseInt(m.substring(0,2)));
		this.time.setMinute(Integer.parseInt(m.substring(3)));
		this.date = new Date(h);
		this.time = new Time(m);

		
	}
	
	public Timeslot(Timeslot ts) 
	{
		this.date = ts.date;
		this.time = ts.time;
		this.date = date;
		this.time = time;

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
		return time.equals(ts.getTime()) && date.equals(ts.getDate());
	}

	//this is new appointment
	public int compareTo(Timeslot ts) 
	{
		if(this.getDate().compareTo(ts.getDate()) == 0 && this.getTime().compareTo(ts.getTime()) == 0)
		{
			if(this.getMinute() >= ts.getMinute()-15 || this.getMinute() <= ts.getMinute()+15) 
			{
				return 0;
			}
		}
		return 2;
	}

	public String toString() 
	{
		
		return this.getDate().toString()+" "+this.getTime().toString();
		//return m+"/"+d+"/"+y+" "+time.getHour()+":"+time.getMinute();
	}
}
