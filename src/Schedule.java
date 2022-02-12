package src;

public class Schedule 
{
	   private Appointment [] appointments;
	    private int numAppts;
	    private int maxNum = 10;

	    public Schedule()
	    {
	        appointments = new Appointment[maxNum];
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
	    	maxNum += 4;
	        Appointment [] newAppointment = new Appointment[maxNum];
	        for(int i = 0; i < numAppts; i++)
	        {
	            newAppointment[i] = appointments[i];
	        }
	        appointments = newAppointment;
	    }

	    public boolean add(Appointment appt)
	    {
	        if(numAppts == 0)
	        {
	            appointments[0] = appt;
	            numAppts++;
	            return true;
	        }else
	        {
	            final int TIME_INTERVAL = 15;
	            int start = appt.getTimeslot().getMinute() - TIME_INTERVAL;
	            int end = appt.getTimeslot().getMinute() + TIME_INTERVAL;
	            Appointment check = new Appointment(appt.getPatient(),appt.getTimeslot(),appt.getLocation());

	            //if an appointment already exists return false
	            for(int i = 0; i < numAppts; i++)
	            {
	                if(appointments[i].equals(appt))
	                {
	                    return false;
	                }
	            }
	            for(int j = start; j <= end; j++)
	            {
	                check.getTimeslot().setHour(appt.getTimeslot().getHour());
	                check.getTimeslot().setMinute(j);
	                if(find(check) != -1)
	                {
	                    return false;
	                }
	            }
	            appointments[numAppts] = appt;
	            numAppts++;
	            if(numAppts == maxNum) grow();
	            return true;

	        }
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
	        if(numAppts == 0) {
	            return false;
	        }else
	        {
	            if(index == -1) {
	                return false;
	            }else {
	            	swap(index, --numAppts);
	                appointments[numAppts] = null;
	                return true;
	            }
	        }
	    }

	    public int removeAll(Patient p)
	    {
	        int totalRemoved = 0;
	        for(int i = 0; i < numAppts; i++)
	        {
	            if(appointments[i].getPatient().equals(p))
	            {
	                appointments[i] = null;
	                totalRemoved++;
	            }
	        }
	        return totalRemoved;
	    }

	    public void print()
	    {
	    	System.out.println("*list of appointments in the schedule*");
	        for(int i = 0; i < numAppts; i++)
	        {
	            System.out.println(appointments[i].toString());
	        }
	    	System.out.println("*end of schedule*");
	    }
	    
	    public boolean checkConflict(Appointment a) 
	    {
	    	for(int i = 0; i < appointments.length; i++) 
	    	{ 
	    		if(appointments[i] != null) {
	    			if(appointments[i].getTimeslot().compareTo(a.getTimeslot()) == 0 && appointments[i].getLocation().equals(a.getLocation()))  
	    			{
	    				return true;
	    			}
	    		}
	    	}
	    	return false;
	    }
	    
	    public boolean checkTimeslotConflict(Timeslot t) 
	    {
	    for(int i = 0; i < appointments.length; i++) 
	    {
	    	if(appointments[i] != null) 
	    	{
	    		if(t.compareTo(appointments[i].getTimeslot()) == 0) 
	    		{
	    			return true;
	    		}
	    	}
	    }
	    return false;
	    }

	    public void printByZip()
	    {
	        Appointment temp;

	        for(int i = 1; i < numAppts; i++) {
	            for(int j = numAppts-1; j >= i; j--) {
	                if(appointments[j-1].getLocation().getZipCode()
	                        > appointments[j].getLocation().getZipCode()) {
	                    temp = appointments[j-1];
	                    appointments[j-1] = appointments[j];
	                    appointments[j] = temp;
	                }
	            }
	        }
	        print();
	    }

	    public void printByPatient()
	    {
	    	 Appointment temp;

		        for(int i = 1; i < numAppts; i++) {
		            for(int j = numAppts-1; j >= i; j--) {
		                if(appointments[j-1].getPatient().getFirstName().compareTo(appointments[j].getPatient().getFirstName())
		                        > 0) {
		                    temp = appointments[j-1];
		                    appointments[j-1] = appointments[j];
		                    appointments[j] = temp;
		                }
		            }
		        }
		        print();
	    }
	    // removes appointments from the schedule that was scheduled before today
	    public void clearSchedule()
	    {
	        Date dateToday = new Date();
	        for(int i = 0; i < numAppts; i++)
	        {
	            if(appointments[i].getTimeslot().getDate().compareTo(dateToday) == -1) {
	                appointments[i] = null;
	                numAppts++;
	            }
	        }
	    }
}
