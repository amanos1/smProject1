package src;
import java.util.Calendar;

/**
 * The Date class stores information about a single time.
 * It stores the hour and the minute.
 * @author Aaron Browne, Harshkumar Patel
 *
 */
public class Time implements Comparable<Time>{
    private int hour;
    private int minute;
    Calendar calendar = Calendar.getInstance();

    /**
     * If no argument is provided, this constructor creates a instance of time with the current time,
     * provided by Java's Calendar class.
     */
    public Time()
    {
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        minute = calendar.get(Calendar.MINUTE);
    }

    /**
     * Creates an instance of class with the hour and minute provided.
     * @param h The hour.
     * @param m The minute.
     */
    public Time(int h, int m)
    {
        hour = h;
        minute = m;
    }

    /**
     * Creates an instance of class with the hour and minute parsed from the string.
     * @param t The time string in a hh:mm format.
     */
    public Time(String t) {
    	String[] timeElements = t.split(":");
        hour = Integer.parseInt(timeElements[0]);
        minute = Integer.parseInt(timeElements[1]);
    }

    /**
     * Creates a clone of the given time.
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
     * Determines if the time is a valid time.
     * @return true if the time is valid, false if not.
     */
    public boolean isValid()
    {
        final int TOTAL_HOURS = 24;
        final int TOTAL_MINUTES = 60;

        if(hour >= TOTAL_HOURS || hour < 0)
        {
            return false;
        }else if(minute >= TOTAL_MINUTES || minute < 0)
        {
            return false;
        }

        return true;
    }

    /**
     * Checks if two times are equal.
     * @param t The time to compare the current one to.
     * @return true if the times are equal, false if not.
     */
    public boolean equals(Time t)
    {
    	return compareTo(t) == 0;
    }

    /**
     * Compares two times.
     * @param time The time to compare the current one to.
     * @return 1, 0, or -1 if the time is after, the same, or equal to the input time respectively.
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
     * @return A string representation of the time in hh:mm format.
     */
    @Override
    public String toString()
    {
        String m = "0";

        if(minute < 10) {
            m += minute;
        } else
        {
            m = "" + minute;
        }

        return hour + ":" + m;
    }
}
