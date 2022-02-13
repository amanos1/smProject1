package src;

/**
 * The Schedule class stores information about appointments.
 * It stores every information about all appointments and also total number of appointments booked.
 * @author Harshkumar Patel, Aaron Browne
 */
public class Schedule 
{
	   private Appointment [] appointments;
	    private int numAppts;
        
	    /**
		 * Creates an instance of the Schedule class.
		 * The appointments is set to an empty array of size 10 and numAppts to 0.
		 */
	    public Schedule()
	    {
	        appointments = new Appointment[10];
	        numAppts = 0;
	    }
        
	    /**
		 * Checks if given appointment is present in appointments.
		 * @param appt Appointment that is checked for presence in appointments.
		 * @return int index of the appointment if it is present in appointments, -1 is NOT_FOUND.
		 */
	    private int find(Appointment appt) {
	        for(int i = 0; i < numAppts; i++)
	        {
	            if(appt.equals(appointments[i]))
	            {
	                return i;
	            }
	        }
	        return -1;
	    }
	    
	    /**
	     * Checks if given appointment already exists in the schedule.
	     * @param a Appointment that needs to be checked.
	     * @return true if Appointment a exists in schedule
	     */
	    public boolean appointmentExists(Appointment a) 
	    {
	    	if(find(a) != -1) 
	    	{
	    		return true;
	    	}else 
	    	{
	    		return false;
	    	}
	    	
	    }

	    /**
	     * Increases the size of the array appointments by 4.
	     * The appointments stay the same.
	     */
	    private void grow()
	    {
	        Appointment [] newAppointment = new Appointment[numAppts+4];
	        for(int i = 0; i < numAppts; i++)
	        {
	            newAppointment[i] = appointments[i];
	        }
	        appointments = newAppointment;
	    }

	    /**
	     * It adds appt Appointment to schedule and if the array of appointments is full, it increases the size of array by 4 using grow().
	     * @param appt Appointment that we want to add to the schedule.
	     * @return true if the appointment is added to the schedule, false otherwise.
	     */
	    public boolean add(Appointment appt)
	    {
            appointments[numAppts] = appt;
            numAppts++;
            if(numAppts == appointments.length) grow();
            return true;
	    }

	    /**
	     * Given index of two appointments in the appointments array, it swaps the appointments of those given indexes.
	     * @param a the index of one of the elements that we want to swap.
	     * @param b the index of the other element that we want to swap.
	     */
	    private void swap(int a, int b)
	    {
	    	Appointment temp = appointments[a];
	    	appointments[a] = appointments[b];
	    	appointments[b] = temp;
	    }

	    /**
	     * Given a Appointment appt, it removes that particular appointment from the schedule
	     * @param appt Appointment that we want to remove.
	     * @return true if Appointment appt is removed from the schedule, false otherwise.
	     */
	    public boolean remove(Appointment appt)
	    {
	        int index = find(appt);
            if(index == -1) {
                return false;
            }else {
            	for(int i = index; i < numAppts-2; i++)
            		swap(i, i+1);
                appointments[--numAppts] = null;
                return true;
            }
	    }

	    /**
	     * Given a Patient p, it removes all appointments that has the same Patient as Patient p.
	     * If an appointment is removed, all the remaining appointments below that is shifted up accordingly.
	     * @param p the Patient whose all appointments we want to be removed.
	     * @return true if a appointment is removed, false otherwise.
	     */
	    public boolean removeAll(Patient p)
	    {
	        boolean removed = false;
	        for(int i = 0; i < numAppts; i++)
	        {
	            if(appointments[i].getPatient().equals(p))
	            {
	            	for(int j = i; j < numAppts-1; j++)
	            		swap(j, j+1);
	            	i--;
	            	appointments[--numAppts] = null;
	                removed = true;
	            }
	        }
	        return removed;
	    }

	    /**
	     * Prints all the appointments that is in the schedule in the current order.
	     */
	    public void print()
	    {
	    	System.out.println("*list of appointments in the schedule*");
	        for(int i = 0; i < numAppts; i++)
	            System.out.println(appointments[i].toString());
	    	System.out.println("*end of schedule*");
	    }

	    /**
	     * Given Appointment a it checks if the patient of the Appointment a, already has an appointment with same timeslot but at a different location.
	     * @param a the Appointment that we want to check location conflict for.
	     * @return true if the patient of Appointment a already has an appointment with that timeslot at the different location, and false otherwise.
	     */
	    public boolean checkConflict(Appointment a) 
	    {
	    	for(int i = 0; i < numAppts; i++) 
	    	{ 
    			if(appointments[i].getTimeslot().compareTo(a.getTimeslot()) == 0 && appointments[i].getPatient().equals(a.getPatient()))  
    			{
    				return true;
    			}
	    	}
	    	return false;
	    }
	    
	    /**
	     * Given Appointment t it checks if timeslot and location of that appointment is already taken by an existing appointment.
	     * @param t that we can want to check the time and location conflict for.
	     * @return true if timeslot and location of Appointment t is already taken by an existing appointment, and false otherwise.
	     */
	    public boolean checkTimeslotConflict(Appointment t)
	    {
		    for(int i = 0; i < numAppts; i++) 
		    {
	    		if(t.getTimeslot().compareTo(appointments[i].getTimeslot()) == 0 && t.getLocation() == appointments[i].getLocation())
	    		{
	    			return true;
	    		}
		    }
		    return false;
	    }

	    /**
	     * Sorts the appointments array and orders the appointment by zip code.
	     */
	    public void printByZip()
	    {
	        for(int i = 1; i < numAppts; i++)
	        {
	            for(int j = numAppts-1; j >= i; j--)
	            {
	                if(appointments[j-1].compareTo(appointments[j]) > 0)
	                {
	                	swap(j, j-1);
	                }
	            }
	        }
	    	System.out.println("*list of appointments by zip and time slot.*");
	        for(int i = 0; i < numAppts; i++)
	            System.out.println(appointments[i].toString());
	    	System.out.println("*end of schedule*");
	    }

	    /**
	     * Sorts the appointments array and orders the appointment by patient's first name, last name, and date of birth.
	     */
	    public void printByPatient()
	    {
	        for(int i = 1; i < numAppts; i++)
	        {
	            for(int j = numAppts-1; j >= i; j--)
	            {
	                if(appointments[j-1].getPatient().compareTo(appointments[j].getPatient()) > 0)
	                {
	                	swap(j, j-1);
	                }
	            }
	        }
	    	System.out.println("*list of appointments by patient.*");
	        for(int i = 0; i < numAppts; i++)
	            System.out.println(appointments[i].toString());
	    	System.out.println("*end of schedule*");
	    }

	    /**
	     * removes all Appointments that was scheduled before today's date.
	     */
	    public void clearSchedule()
	    {
	        Date dateToday = new Date();
	        for(int i = 0; i < numAppts; i++)
	        {
	            if(appointments[i].getTimeslot().getDate().compareTo(dateToday) == -1)
	            {
	                appointments[i] = null;
	                numAppts++;
	            }
	        }
	    }
}
