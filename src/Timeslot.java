package src;


public class Timeslot {

    private Date date;
    private Time time;

    //By default it's set to today's date and current time
    public Timeslot()
    {
        date = new Date();
        time = new Time();
    }

    public Timeslot(Date d, Time t)
    {
    	date = new Date(d);
    	time = new Time(t.getHour(), t.getMinute());
    }

    public Timeslot(int month, int day, int year, int hour, int minute)
    {
        date.setMonth(month);
        date.setDay(day);
        date.setYear(year);
        time.setHour(hour);
        time.setMinute(minute);
    }

    public Timeslot(String h, String m) {
        date.setMonth(Integer.parseInt(h.substring(0,2)));
        date.setDay(Integer.parseInt(h.substring(3,5)));
        date.setYear(Integer.parseInt(h.substring(6)));
        time.setHour(Integer.parseInt(m.substring(0,2)));
        time.setMinute(Integer.parseInt(m.substring(3)));

    }

    public Timeslot(Timeslot ts)
    {
        date = ts.date;
        time = ts.time;
    }

    public int getHour()
    {
        int h = time.getHour();
        return h;
    }

    public int getMinute()
    {
        int m = time.getMinute();
        return m;
    }

    public Date getDate()
    {
        Date temp = new Date(date.getMonth(), date.getDay(), date.getYear());
        return temp;
    }

    public void setHour(int h)
    {
        time.setHour(h);
    }

    public void setMinute(int m)
    {
        time.setMinute(m);
    }
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
        return date.toString()+" "+time.toString();
    }
}
