package src;

public class Patient {

    private String fname;
    private String lname;
    private Date dob;

    public Patient()
    {
        dob = new Date();
    }

    public Patient(Patient p)
    {
        fname = p.getFirstName();
        lname = p.getLastName();
        dob = p.getDOB();
    }

    public Patient(String f, String l, String d)
    {
        fname = f;
        lname = l;
        dob = new Date(d);
    }
    public String getFirstName()
    {
        String f = fname;
        return f;
    }

    public String getLastName()
    {
        String l = lname;
        return l;
    }

    public Date getDOB()
    {
        return dob;
    }
    public boolean equals(Patient patient)
    {
        return (this.fname.equals(patient.getFirstName()) &&
                (this.lname.equals(patient.getLastName()) &&
                        dob.equals(patient.getDOB())));
    }

    public String toString()
    {
        return (fname+" "+lname+", DOB: "+dob);
    }

    //public int compareTo(Patient patient) {
    //    if(this.equals(patient))
    //    {
    //        return 0;
    //    }else if()
    //}
}
