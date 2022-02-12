package src;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Kiosk {
    private Schedule schedule;

	
public  void run()
{
	schedule = new Schedule();
    int input = 0;
    String command;
    String[] commandList;
    Scanner scn = new Scanner(System.in);
    
    System.out.println("Kiosk Ready. Ready to process transactions.");

    while(scn.hasNextLine())
    {
        command = scn.nextLine();
        commandList = command.split(" ");
        if(commandList[0].equals("Q")) {break;}
        switch(commandList[0]) {
        case "C":
        	cancel(command);
            break;
        case "B":
        	book(command);
            break;
        case "CP":
            Patient p = removeAllAppointment(command);
            System.out.println("Appoitments removed: " + schedule.removeAll(p));
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
    System.out.println("Kiosk session ended.");	    
}

private void cancel(String com)
{
    Appointment temp = buildAppointment(com);
    if(schedule.remove(temp)) 
    {
        System.out.println("Appointment cancelled.");
    }else {
        System.out.println("Not cancelled, appointment does not exist.");
    }
}

private void book(String com)
{
    Appointment temp1 = buildAppointment(com);
    if(temp1 == null) return;
    if(schedule.checkConflict(temp1) == false || schedule.appointmentExists(temp1) || !(schedule.checkTimeslotConflict(temp1.getTimeslot()))) {
    if(schedule.add(temp1) ) 
    {
        schedule.clearSchedule();
        System.out.println("Appointment booked and added to the schedule.");
    }else {
        System.out.println("Invalid Command");
    }
    }else 
    {
    	System.out.println("Time Conflict");
    }
}


public static Appointment buildAppointment(String com)
{   
    StringTokenizer st = new StringTokenizer(com," ");
    st.nextToken();
    final Date DATE_TODAY = new Date();
    Date dob = new Date(st.nextToken());
    Patient patient = new Patient(st.nextToken(),st.nextToken(),dob.toString());
    Date appointmentDate = new Date(st.nextToken());
    Time time = new Time(st.nextToken());
    if(!dob.isValid() || !appointmentDate.isValid()) 
    {
        System.out.println("Invalid Date of Birth or Date of Appointment");
        return null;
    }else if (dob.compareTo(DATE_TODAY) >= 0 || appointmentDate.compareTo(DATE_TODAY) <= 0) 
    {
        System.out.println("Invalid Date of Birth or Date of Appointment");
        return null;
    }
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
    }else {
        System.out.println("Invalid location!");
        return null;
    }
    Appointment appt = new Appointment(patient, ts, loc);
    if(appt.isValidTime()) 
    {
    return appt;
    }else {
    	 System.out.println("Appointment Time must be between 9:00 and 16:45");
         return null;
    }
}

public static Patient removeAllAppointment(String com)
{
    StringTokenizer st = new StringTokenizer(com," ");
    st.nextToken();
    final Date DATE_TODAY = new Date();
    Date dob = new Date(st.nextToken());
    if(dob.compareTo(DATE_TODAY) >= 0) 
    {
        System.out.println("Invalid Date of Birth or Date of Appointment");
        return null;
    }
    Patient patient = new Patient(st.nextToken(), st.nextToken(), dob.toString());
    return patient;
}

}


