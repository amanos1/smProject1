package src;

/**
 * The Appointment class stores information about a single appointment.
 * It keeps track of the patient, time slot, and location of the appointment.
 * @author Aaron Browne, Harshkumar Patel
 */
public class Appointment 
{
	private Patient patient;
	private Timeslot slot;
	private Location location;

	/**
	 * Creates an instance of the Appointment class when given a patient, time slot, and location.
	 * @param p Patient the appointment is for.
	 * @param t Timeslot of the appointment.
	 * @param l Location of the appointment.
	 */
	public Appointment(Patient p, Timeslot t, Location l)
	{
		this.patient = p;
		this.slot = t;
		this.location = l;
	} 

	/**
	 * Returns the Patient Object.
	 * @return the Patient Object.
	 */
	public Patient getPatient() 
	{
		Patient p = new Patient(this.patient);
		return p;
	}

	/**
	 * Returns the Timeslot object.
	 * @return the Timeslot object.
	 */
	public Timeslot getTimeslot() 
	{
		Timeslot ts = new Timeslot(this.slot);
		return ts;
	}

	/**
	 * Returns the location enum.
	 * @return the location enum.
	 */
	public Location getLocation()
	{
		return this.location;
	}

	/**
	 * Checks to see if the appointment is at a time allowed by the system.
	 * The appointment cannot be before 9:00 or after 16:45 and must be a 15 minute interval.
	 * @return true if the appointment time is valid, false if not.
	 */
	public boolean isValidTime()
	{
		final int TIME_INTERVAL = 15;
		final int MIN_HOUR = 9;
		final int MAX_HOUR = 16;
		final int MAX_MIN = 45;

		if(slot.getHour() < MIN_HOUR || slot.getHour() > MAX_HOUR
				|| (slot.getHour() == MAX_HOUR && slot.getMinute() > MAX_MIN))
		{
			return false;
		}

		if(slot.getMinute() % TIME_INTERVAL != 0) return false;

		return true;
	}

	/**
	 * Compares appointments to each other first by the zip codes and then by time slot. For use with the printByZip function.
	 * @param a The appointment to compare the current one to.
	 * @return 1 if the zip value is greater or the time slot occurs after the time of the appointment being compared to. -1 if the inverse is true and 0 if the appointments have to same location and time.
	 */
	public int compareTo(Appointment a)
	{
		if(location.getZipCode() > a.getLocation().getZipCode()) return 1;
		if(location.getZipCode() < a.getLocation().getZipCode()) return -1;
		return slot.compareTo(a.getTimeslot());
	}

	/**
	 * Checks to see if two appointments are equal.
	 * @param obj The appointment we are comparing the current one to.
	 * @return True if the appointments have the same patient, time, and location, false if they don't.
	 */
	@Override
	public boolean equals(Object obj)
	{
		return toString().equals(obj.toString());
	}

	/**
	 * Returns a string representation of the appointment.
	 * @return a string representation of the appointment.
	 */
	@Override
	public String toString()
	{
		return patient.toString() + ", Appointment detail: " + this.slot.toString()
				+ ", " + this.location.toString();
	}
}
