package src;
import java.util.Calendar;

/**
 * The Time class object stores information about a single time.
 * This includes the hour and the minute.
 * Can determine if the time is a valid one.
 * @author Aaron Browne, Harshkumar Patel
 */
public class Time implements Comparable<Time>{
    private int hour;
    private int minute;
    Calendar calendar = Calendar.getInstance();

    /**
     * When no arguments are provided, this constructor will create an instance of time
     * with the current time, as provided by Java's Calendar class.
     */
    public Time()
    {
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        minute = calendar.get(Calendar.MINUTE);
    }

    /**
     * Creates an instance of time with the hour and minute provided.
     * @param h The hour.
     * @param m The minute.
     */
    public Time(int h, int m)
    {
        hour = h;
        minute = m;
    }

	/**
	 * When given a string, this constructor parses the string and creates an instance of date with it.
	 * @param t The time string in hh:mm format.
	 */
    public Time(String t)
    {
    	String[] timeElements = t.split(":");
        hour = Integer.parseInt(timeElements[0]);
        minute = Integer.parseInt(timeElements[1]);
    }

    /**
     * Creates a clone of the time provided.
     * @param t The time to clone.
     */
    public Time(Time t)
    {
        minute = t.getMinute();
        hour = t.getHour();
    }

    /**
     * Returns the minute.
     * @return The minute.
     */
    public int getMinute()
    {
        int m = minute;
        return m;
    }

    /**
     * Returns the hour.
     * @return The hour.
     */
    public int getHour()
    {
        int h = hour;
        return h;
    }

    /**
     * Changes the hour.
     * @param h The new hour.
     */
    public void setHour(int h)
    {
        hour = h;
    }

    /**
     * Changes the minute.
     * @param m The new minute.
     */
    public void setMinute(int m)
    {
        minute = m;
    }

    /**
     * Determines if the time is a valid one.
     * @return true if the time is valid, false if not.
     */
    public boolean isValid()
    {
        final int TOTAL_HOURS = 24;
        final int TOTAL_MINUTES = 60;

        if(hour >= TOTAL_HOURS)
        {
            return false;
        } else if(minute >= TOTAL_MINUTES)
        {
            return false;
        }
        return true;
    }

    /**
     * Determines if two times are equal.
     * @param t The time to compare against.
     * @return true if the times are equal, false if not.
     */
    public boolean equals(Time t)
    {
    	return compareTo(t) == 0;
    }

    /**
     * Compares two times.
     * @param time The time to compare against.
     * @return 1 if the current time is after the given one, -1 is the opposite is true, and 0 if the times are equal.
     */
    @Override
    public int compareTo(Time time)
    {
    	if(hour > time.getHour()) return 1;
    	else if(hour < time.getHour()) return -1;
    	if(minute > time.getMinute()) return 1;
    	else if(minute < time.getMinute()) return -1;
    	return 0;
    }

    /**
     * Returns a string representation of the time.
     * @return A string representation of the time.
     */
    @Override
    public String toString()
    {
        String m = "0";

        if(minute < 10) {
            m += minute;
        }else
        {
            m = "" + minute;
        }

        return hour + ":" + m;
    }
}
