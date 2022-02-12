package src;

public class Patient {
	/**
	 * The Patient class stores information about the patient.
	 * It stores patient's first name, last name and date of birth.
	 * @author Harshkumar Patel,  Aaron Browne
	 */
    private String fname;
    private String lname;
    private Date dob;
    /**
	 * Creates an instance of the Patient class, given no parameters.
	 * first name and last name is set to null and date of birth is set to today's date.
	 */
    public Patient()
    {
        dob = new Date();
    }
    /**
	 * Creates an instance of the Patient class when given a object of type Patient
	 * @param p Patient the appointment is for.
	 */
    public Patient(Patient p)
    {
        fname = p.getFirstName();
        lname = p.getLastName();
        dob = p.getDOB();
    }
    
    /**
	 * Creates an instance of the Patient class given patient first name, last name and date of birth.
	 * @param f String first name.
	 * @param l String last name.
	 * @param d String date of birth.
	 */
    public Patient(String f, String l, String d)
    {
        fname = f;
        lname = l;
        dob = new Date(d);
    }
    
    /**
	 * Returns patient's first name.
	 * @return the String object.
	 */
    public String getFirstName()
    {
        String f = fname;
        return f;
    }
    
    /**
   	 * Returns patient's last name.
   	 * @return the String object.
   	 */
    public String getLastName()
    {
        String l = lname;
        return l;
    }

    /**
   	 * Returns patient's date of birth.
   	 * @return the Date object.
   	 */
    public Date getDOB()
    {
        return dob;
    }

    /**
   	 * Checks to see if the patient are the same.
   	 * @param The patient we are comparing the current one to.
   	 * @return True if two patient have same first name, last name, and date of birth, false otherwise.
   	 */
    @Override
    public boolean equals(Object obj)
    {
    	Patient patient = (Patient)obj;         
        return (this.fname.equals(patient.getFirstName()) &&
                (this.lname.equals(patient.getLastName()) &&
                        dob.equals(patient.getDOB())));
    }
    
    /**
	 * Returns a string representation of the patient.
	 * @return a string representation of the patient.
	 */
	@Override
    public String toString()
    {
        return (fname+" "+lname+", DOB: "+dob);
    }
    
	/**
	 * Compares patients to each other first by the last name and then by first name. If the first name and last name is same, date of birth is compared.
	 * For use with the printByPatient function.
	 * @param a The patient to compare the current one to.
	 * @return int value if last name's or first name's are not same, it returns -1,0,-1 based on compareTo() method of Date class.
	 */
    public int compareTo(Patient patient)
    {
    	if(lname.compareTo(patient.getLastName()) != 0) return lname.compareTo(patient.getLastName());
    	if(fname.compareTo(patient.getFirstName()) != 0) return fname.compareTo(patient.getFirstName());
    	return dob.compareTo(patient.getDOB());
    }
}
