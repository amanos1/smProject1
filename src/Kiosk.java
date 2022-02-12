package src;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Kiosk {
    private Schedule schedule;
		
	public  void run()
	{
		schedule = new Schedule();
	    String command;
	    String[] commandList;
	    Scanner scn = new Scanner(System.in);
	    
	    System.out.println("Kiosk Ready. Ready to process transactions.");
	
	    while(scn.hasNextLine())
	    {
	        command = scn.nextLine();
	        commandList = command.split(" ");
	        //System.out.print(command + " -> ");
	        if(commandList[0].equals("Q")) {break;}
	        switch(commandList[0])
	        {
		        case "C":
		        	cancel(command);
		            break;
		        case "B":
		        	book(command);
		            break;
		        case "CP":
		            removeAllAppointment(command);
		            break;
		        case "P":
		            schedule.print();
		            break;
		        case "PZ":
		            schedule.printByZip();
		            break;
		        case "PP":
		            schedule.printByPatient();
		            break;
		        default:
		        	System.out.println("Invalid command!");
	        }
	    }
	    scn.close();
	    System.out.println("Kiosk session ended.");	    
	}
	
	private void cancel(String com)
	{
	    Appointment temp = buildAppointment(com);
	    if(temp == null) return;

	    if(schedule.remove(temp))
	    {
	        System.out.println("Appointment cancelled.");
	    } else
	    {
	        System.out.println("Not cancelled, appointment does not exist.");
	    }
	}
	
	private void book(String com)
	{
	    Appointment temp1 = buildAppointment(com);
	    if(temp1 == null) return;
	    if(schedule.appointmentExists(temp1))
	    {
	    	System.out.println("Same appointment exists in the schedule.");
	    	return;
	    } if (schedule.checkTimeslotConflict(temp1))
	    {
	    	System.out.println("Time slot has been taken at this location.");
	    	return;
	    }
	    if(schedule.checkConflict(temp1)) {
	    	System.out.println("Same patient cannot book an appointment with the same date.");
	    	return;
	    }
	    schedule.add(temp1);
        schedule.clearSchedule();
        System.out.println("Appointment booked and added to the schedule.");
	}

	private boolean checkTheDates(Date dob, Date appt)
	{
	    final Date DATE_TODAY = new Date();
		if(!dob.isValid())
		{
			System.out.println("Invalid date of birth!");
			return false;
		} if(!appt.isValid())
		{
			System.out.println("Invalid appointment date!");
			return false;
		} if(dob.compareTo(DATE_TODAY) > 0)
		{
			System.out.println("Date of birth invalid -> it is a future date.");
			return false;
		} if(appt.compareTo(DATE_TODAY) < 0)
		{
			System.out.println("Appointment date invalid -> must be a future date.");
			return false;
		}
		return true;
	}

	private Appointment buildAppointment(String com)
	{   
	    StringTokenizer st = new StringTokenizer(com," ");
	    st.nextToken();
	    Date dob = new Date(st.nextToken());
	    Patient patient = new Patient(st.nextToken(),st.nextToken(),dob.toString());
	    Date appointmentDate = new Date(st.nextToken());
	    Time time = new Time(st.nextToken());

	    if(!checkTheDates(dob, appointmentDate)) return null;

	    Timeslot ts = new Timeslot(appointmentDate, time);

	    String l = st.nextToken();
	    l = l.toLowerCase();
	    Location loc;
	    if(l.equals("middlesex")) 
	    {
	        loc =  Location.Middlesex;
	    }else if(l.equals("mercer")) 
	    {
	         loc =  Location.Mercer;
	    }else if(l.equals("morris")) 
	    {
	         loc =  Location.Morris;
	    }else if(l.equals("union")) 
	    {
	         loc =  Location.Union;
	    }else if(l.equals("somerset")) 
	    {
	         loc =  Location.Somerset;
	    }else
	    {
	        System.out.println("Invalid location!");
	        return null;
	    }
	    Appointment appt = new Appointment(patient, ts, loc);
	    if(appt.isValidTime()) 
	    {
	    	return appt;
	    }

	    System.out.println("Invalid appointment time! Must enter a time between 9:00 and 16:45 with a 15-minute interval.");
	    return null;
	}

	private void removeAllAppointment(String com)
	{
	    StringTokenizer st = new StringTokenizer(com, " ");
	    st.nextToken();
	    String dob = st.nextToken();
	    Patient patient = new Patient(st.nextToken(), st.nextToken(), dob);
	    if(schedule.removeAll(patient))
	    {
	    	System.out.println("All appointments for " + patient.toString() + " have been cancelled.");
	    } else
	    {
	    	System.out.println("That patient does not seem to exist.");
	    }
	}
}
