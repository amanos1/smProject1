package src;

public class Schedule 
{
	   private Appointment [] appointments;
	    private int numAppts;

	    public Schedule()
	    {
	        appointments = new Appointment[10];
	        numAppts = 0;
	    }

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

	    private void grow()
	    {
	        Appointment [] newAppointment = new Appointment[numAppts+4];
	        for(int i = 0; i < numAppts; i++)
	        {
	            newAppointment[i] = appointments[i];
	        }
	        appointments = newAppointment;
	    }

	    public boolean add(Appointment appt)
	    {
            appointments[numAppts] = appt;
            numAppts++;
            if(numAppts == appointments.length) grow();
            return true;
	    }

	    private void swap(int a, int b)
	    {
	    	Appointment temp = appointments[a];
	    	appointments[a] = appointments[b];
	    	appointments[b] = temp;
	    }

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

	    public void print()
	    {
	    	System.out.println("*list of appointments in the schedule*");
	        for(int i = 0; i < numAppts; i++)
	            System.out.println(appointments[i].toString());
	    	System.out.println("*end of schedule*");
	    }

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

	    // removes appointments from the schedule that was scheduled before today
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
