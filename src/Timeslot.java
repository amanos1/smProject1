package src;

/**
 * Timeslot class stores Date and time.
 * Date includes month, day and year.
 * Time includes hour and minutes.
 * @author Harshkumar Patel, Aaron Browne
 */
public class Timeslot {

    private Date date;
	private Time time;
	
	/**
	 * 	Given no arguments, this default constructor builds a Timeslot.
	 * By default date is assigned to be today's date and time is given current hour and time
	 * as provided by Java's Calendar library.
	 */
	public Timeslot() 
	{
		this.date = new Date();
		this.time = new Time();
	}
	/**
	 * Given Date d and Time t, it initialize Timeslot with it's date as Date and time as Time t
	 * @param d Date object that will be assigned to Date date
	 * @param t Time object that will be assigned to Time time
	 */
	public Timeslot(Date d, Time t) 
	{
		date = new Date(d);
		time = new Time(t);
	}
	/**
	 * Given Integer value of month, day, year, hour, and minute this constructor initialize timeslot with these given values.
	 * @param month int value of month.
	 * @param day int value of day.
	 * @param year int value of year .
	 * @param hour int value of hour.
	 * @param minute int value of minute.
	 */
	public Timeslot(int month, int day, int year, int hour, int minute) 
	{
		this.date = new Date(month, day, year);
		this.time = new Time(hour, minute);
	}

	/**
	 * Given two Strings h and m for date and time, it creates a Timeslot object
	 *  with that value by using Date(String) and Time(String) constructors.
	 * @param h String value of Date in the form of mm/dd/yyyy.
	 * @param m String value of Time in the form of hh:mm.
	 */
	public Timeslot(String h, String m) {
		this.date = new Date(h);
		this.time = new Time(m);
	}

	/**
	 * Given an object of type Timeslot it creates a new Timeslot object by cloning given object.
	 * @param ts Timeslot object that you want to clone.
	 */
	public Timeslot(Timeslot ts)
	{
		this.date = new Date(ts.date);
		this.time = new Time(ts.time);
	}
	
	/**
	 * this method returns hour of the current Timeslot object.
	 * @return int value of hour of current Timeslot object.
	 */
	public int getHour() 
	{
		int h = this.time.getHour();
		return h;
	}
	
	/**
	 * this method returns minute of the current Timeslot object.
	 * @return int value of minute of current Timeslot object.
	 */
	public int getMinute() 
	{
		int m = this.time.getMinute();
		return m;
	}
	
	/**
	 * this method returns Date of the current Timeslot object
	 * @return Date object that represents the date of the current Timeslot object.
	 */
	public Date getDate() 
	{
		Date temp = new Date(this.date.getMonth(),this.date.getDay(),this.date.getYear());
		return temp;
	}
	
	/**
	 * this method returns Time of the current Timeslot Object.
	 * @return Time object that represent the time of the current Timeslot object.
	 */
	public Time getTime() {
		Time temp  = new Time(this.time.getHour(), this.time.getMinute());
		return temp;
	}
	
	/**
	 * Given a value it sets hour of current Timeslot object to that given value.
	 * @param h int value that we want to set the current Timeslot's hour to.
	 */
	public void setHour(int h) 
	{
		this.time.setHour(h);
	}
	
	/**
	 * Given a value it sets minute of current Timeslot object to that given value.
	 * @param m int value that we want to set the current Timeslot's minute to.
	 */
	public void setMinute(int m) 
	{
		this.time.setMinute(m);
	}

	/**
	 * Given an object of type Timeslot it checks if the given Timeslot is the same as the current Timeslot.
	 * @param ts Timeslot that we want to check if it is the same the current Timeslot.
	 * @return true if the current Timeslot and the given Timeslot is the same, false otherwise.
	 */
	public boolean equals(Timeslot ts)
	{
		return compareTo(ts) == 0;
	}

	/**
	 * Given an object of type Timeslot it compares it's date and time to the current Timeslot's date and time.
	 * @param ts Timeslot that you want to compare to the current Timeslot.
	 * @return 0 if the date and time of both Timeslot's is the same, -1 if Timeslot ts comes before current Timeslot object and 1 if current Timeslot comes before Timeslot ts.
	 */
	public int compareTo(Timeslot ts) 
	{
		if(date.compareTo(ts.getDate()) != 0) return date.compareTo(ts.getDate());
		return time.compareTo(ts.getTime());
	}

	/**
	 * This method represents Timeslot's date and time in String.
	 * @return String representing Timeslot in the format mm/dd/yyyy hh:mm.
	 */
	@Override
	public String toString() 
	{
		return date.toString() + " " + time.toString();
	}
	
	/**
	 * The main method is testing all the edge cases using compareTo() method.
	 * @param args
	 */
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

