package src;

public class Appointment 
{
    private Patient patient;
    private Timeslot slot;
    private Location location;
    
    public Appointment(Patient p, Timeslot t, Location l)
    {
        patient = p;
        slot = t;
        location = l;
    } 
    
    public Patient getPatient() 
    {
        Patient p = new Patient(patient);
        return p;
    }
    
    public Timeslot getTimeslot() 
    {
        Timeslot ts = new Timeslot(slot);
        return ts;
    }
    
    public Location getLocation() 
    {
        return location;
    }
    
    public int compareTo(Appointment a) 
    {
        return 0;
    }
    
    public boolean equals(Appointment a) 
    {
        return (patient.equals(a.getPatient()) && slot.equals(a.getTimeslot())&&
                location.equals(a.getLocation()));
    }
    
    public String toString() 
    {
        return (patient.toString()+
                ", Appointment detail: "+slot.toString()+
                ", "+location.toString());
    }
    
    
}
