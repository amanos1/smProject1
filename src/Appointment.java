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
	//NEED TO FINISH THIS METHOD
	public int compareTo(Appointment a)
	{
		if(this.getTimeslot().compareTo(this.getTimeslot()) == 0)
			{
				if(this.location.equals(ts.getLocation())) 
				{
					return 0;
				}
			}
			return 2;
	}
	
	public boolean isValidTime() 
		{
			if(this.getTimeslot().getHour() < 9 || this.getTimeslot().getHour() > 16 || (this.getTimeslot().getHour() == 16 && this.getTimeslot().getMinute() > 45)) 
			{
				return false;
			}
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
