public class FullTimeStaffHire extends StaffHire //extends keywords means it is the sub class of StaffHire class
{
    private int salary; //These are private parameters can be accessed by only this class 
    private int workingHour;
    private String staffName;
    private String joiningDate;
    private String qualification;
    private String appointedBy;
    private boolean joined;
    
    public FullTimeStaffHire(int vacancyNumber, String designation, String jobType, int salary, int workingHour){ //this is constructor to initialize values
        super(vacancyNumber, designation, jobType);  //super class constructor with three parameters
        this.workingHour = workingHour;
        this.salary=salary;
        this.staffName = ""; // setting its value as empty
        this.joiningDate = "";
        this.qualification = "";
        this.appointedBy = "";
        this.joined=false;
    }
    
    public int getWorkingHour(){ //these are accesor method that returns the values whenever it is called
        return workingHour; // returns value of workingHour
    }
    
    public int getSalary(){ //returns value of salary
        return salary;
    }
    
    public String getStaffName(){ //returns value of staffName
        return staffName;
    }
    
    public String getJoiningDate(){ //returns joiningDate
        return joiningDate;
              
    }
    
    public String getQualification(){ //returns value of qualification
        return qualification;
    }
    
    public String getAppointedBy(){ //returns value of appointedBy
        return appointedBy;
    }
    
    public boolean getJoined(){ //returns value of joined
        return joined;
    }
    
   
    
    public void setSalary(int salary){ //method to set new value to salary if joined value is false
        if (this.joined) {
            System.out.println(" The staff is already appointed.");
        }else{
            this.salary=salary;
        }
    }
    
    public void setWorkingHour(int workingHour){ //method to set new value of workingHour
        this.workingHour=workingHour;
    }
    
    public void hireFullTimeStaff(String staffName, String joiningDate, String qualification, String appointedBy){ //method to initialize value if value of joined value is false
        if (this.joined){
            System.out.println("");
            System.out.println("------------------------------------------------------");
            System.out.println("Staff is already appointed");
            System.out.println("Staff Name = "+staffName);
            System.out.println("Staff had joined an organisation from = "+this.joiningDate);
            System.out.println("------------------------------------------------------");
            System.out.println("");
        }else{
            this.staffName=staffName;
            this.joiningDate=joiningDate;
            this.qualification=qualification;
            this.appointedBy=appointedBy;
            this.joined=true; //setting value of joined true
        }
    }
    
    public void displayFullTimeStaffInfo(){ //method to display information of FullTimeStaff information
       System.out.println("");
       System.out.println("------------------------------------------------------");
       super.displayInformation();// calling displayInformation method from StaffHire parent class 
            if(this.joined){
                System.out.println("------------------------------------------------------");
                System.out.println("--------------Full time staff detail -----------------");
                System.out.println("------------------------------------------------------");
                System.out.println("Staff name  = "+getStaffName());
                System.out.println("Sallary of a staff = "+getSalary());
                System.out.println("working hour = "+getWorkingHour());
                System.out.println("Staff was joined in: "+getJoiningDate());
                System.out.println("Qualification = "+getQualification());
                System.out.println("Staff was appointed by = "+getAppointedBy());
                System.out.println("------------------------------------------------------");
                System.out.println("");
        }
    }
                
}
