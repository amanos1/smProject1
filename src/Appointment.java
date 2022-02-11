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
		return 0;
	}
	
	public boolean equals(Appointment a) 
	{
		return (this.patient.equals(a.getPatient()) && this.slot.equals(a.getTimeslot())&&
				this.location.equals(a.getLocation()));
	}
	
	public String toString() 
	{
		return (patient.toString()+
				", Appointment detail: "+this.slot.toString()+
				", "+this.location.toString());
	}
	
	
    
}
