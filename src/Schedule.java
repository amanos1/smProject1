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
        for(int i = 0; i < appointments.length; i++)
        {
            if(appt.equals(appointments[i]))
            {
                return i;
            }
        }
        return -1;
    }

    private void grow()
    {
        Appointment [] newAppointment = new Appointment[numAppts+4];
        for(int i = 0; i < appointments.length; i++)
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
            for(int i = 0; i <=appointments.length; i++)
            {
                if(appointments[i].equals(appt)) {
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
            return true;

        }
    }

    public boolean remove(Appointment appt)
    {
        int index;
        if(numAppts == 0) {
            return false;
        }else
        {
            if(find(appt) == -1) {
                return false;
            }else {
                index = find(appt);
                appointments[index] = null;
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
        for(int i = 0; i < numAppts; i++)
        {
            System.out.println(appointments[i].toString());
        }
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
