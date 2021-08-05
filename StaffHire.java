/**
 * StaffHire class is super class from this class other classes can use its methods and properties.
 
 * @author Anish Basnet 
 * @version 0.1
 */
public class StaffHire //Creating a class named StaffHire
{
    private int vacancyNumber;//These are private parameters and they can only accessed by this class 
    private String designation;
    private String jobType;
    
    public StaffHire(int vacancyNumber, String designation, String jobType){ // This is constructor to initialize value for above variables 
        this.vacancyNumber=vacancyNumber; // (this.) keyword updates with new value
        this.designation=designation;
        this.jobType=jobType;
    }
    
    public int getVacancyNumber(){//this is accessor method it returns the value that holds whenever this method is called
        return vacancyNumber;     //returns vacancyNumber
    }
    
    public void setVacancyNumber(int vacancyNumber){ // this is mutator method that sets the new value
        this.vacancyNumber=vacancyNumber;   //updates value of vancancyNumber with new one
    }
    
    public String getDesignation(){ // returns designation
        return designation;
    }
    
    public void setDesignation(String desgination){ // updates value of designation with new one
        this.designation=desgination;
    }
    
    public String getJobType(){ // returns jobType
        return jobType;
    }
    
    public void setJobType(String jobType){  //updates value of jobType with new one
        this.jobType=jobType;
    }
    
    public void displayInformation(){ // This method displays the vacancyNumber, designation and jobType
        System.out.println("Vacancy number of a staff = "+vacancyNumber);
        System.out.println("Designation of a staff = "+designation);
        System.out.println("Job type of a staff = "+jobType);
    }
    
}
