package src;

public class Appointment 
{
  private Patient patient;
	private Timeslot slot;
	private Location location;
	
	public Appointment(Patient p, Timeslot t, Location l)
	{
		this.patient = p;
		this.slot = t;
		this.location = l;
		
	} 
	
	public Patient getPatient() 
	{
		Patient p = new Patient(this.patient);
		return p;
	}
	
	public Timeslot getTimeslot() 
	{
		Timeslot ts = new Timeslot(this.slot);
		return ts;
	}
	
	public Location getLocation() 
	{
		return this.location;
	}

	//For use with the printByZip function
	public int compareTo(Appointment a)
	{
		if(location.getZipCode() > a.getLocation().getZipCode()) return 1;
		if(location.getZipCode() < a.getLocation().getZipCode()) return -1;
		return slot.compareTo(a.getTimeslot());
	}
	
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

	public boolean equals(Appointment a)
	{
		return (this.patient.equals(a.getPatient()) && this.slot.equals(a.getTimeslot())&&
				this.location == a.getLocation());
	}
	
	public String toString()
	{
		return (patient.toString()+
				", Appointment detail: "+this.slot.toString()+
				", "+this.location.toString());
	}
	
	
    
}
