public class PartTimeStaffHire extends StaffHire{ //extends keywords means it is the sub class of StaffHire class
    private int workingHour; //These are private parameters can be accessed by this class 
    private int wagesPerHour;
    private String staffName;
    private String joiningDate;
    private String qualification;
    private String appointedBy;
    private String shifts;
    private boolean joined;
    private boolean terminated;
            
   public PartTimeStaffHire (int vacancyNumber,String designation,String jobType,int workingHour,int wagesPerHour,String shifts){ //this is constructor to initialize values
       super(vacancyNumber, designation, jobType); //superclass constructor with three parameters
       this.workingHour = workingHour;
       this.wagesPerHour = wagesPerHour;
       this.shifts = shifts;
       this.staffName = "";// setting its value as empty
       this.joiningDate = "";
       this.qualification = "";
       this.appointedBy = "";
       this.joined = false;
       this.terminated = false;
   }
        
   public int getWorkingHour(){ //these are accesor method that returns the values whenever it is called
       return workingHour;        //returns the value of workingHour
   }
   
   public int getWagesPerHour(){ //returns the value of wagesPerHour
       return wagesPerHour;
   }
   
   public String getShifts(){ //returns the value of wagesPerHour
       return shifts;
   }
   
   public String getStaffName(){ //returns the value StaffName
       return staffName;
                    
   }
        
   public String getJoiningDate(){ //returns the value of joiningDate
       return joiningDate;
                  
   }
        
   public String getQualification(){ //returns the value of qualification
       return qualification;
   }
        
   public String getAppointedBy(){ //returns the value of appointedBy
       return appointedBy;
   }
        
   public boolean getJoined(){ //returns the value of joined
       return joined;
   }
        
   public boolean getTerminated(){ //returns the value of terminated
       return terminated;
   }
        
   public void setShift(String shifts){ // this is method to display message and change the value of shifts if the value of joined is false  
       if (this.joined) {
           System.out.println("------------------------------------------------------");
                System.out.println("");
           System.out.println(" Staff is already hired");
           System.out.println("------------------------------------------------------");
           System.out.println("");
       }else{
           this.shifts=shifts;                     
       }
   }
        
   public void hirePartTimeStaff(String staffName, String joiningDate, String qualification, String appointedBy){ //this is a method to display information and set the values of joiningDate,qualification, appointedBy, joined and terminated if the joined value is false
       if(this.joined){
           System.out.println("");
           System.out.println("------------------------------------------------------");
           System.out.println("Staff is already hired");
           System.out.println("Staff Name="+this.staffName);
           System.out.println("Join Date="+this.joiningDate);
           System.out.println("------------------------------------------------------");
           System.out.println("");
       }else{
           this.staffName=staffName;
           this.joiningDate=joiningDate;
           this.qualification=qualification;
           this.appointedBy=appointedBy;
           this.joined=true;
           this.terminated=false;
           System.out.println("");
           System.out.println("------------------------------------------------------");
           System.out.println(" Part time Staff is succesfully hired");
           System.out.println("------------------------------------------------------");
           System.out.println("");
       }               
   }
        
   public void terminateTheStaff(){ // this method checks the value of terminated if it is then displays message else sets empty value staffName, joiningDate,qualification and changes joined to false and terminated to true 
       if(this.terminated){
           System.out.println("");
           System.out.println("------------------------------------------------------");
           System.out.println("The staff is already terminated");
           System.out.println("------------------------------------------------------");
           System.out.println("");
       }else{
           this.staffName="";
           this.joiningDate="";
           this.qualification="";
           this.appointedBy="";
           this.joined=false;
           this.terminated=true;
       }
   }
        
   public void displayPartTimeStaffInfo(){ //method to display information of part time staff if joined is false 
       int incomePerDay;
       incomePerDay=getWagesPerHour()*getWorkingHour(); // calcutaion to get income per day
       System.out.println("------------------------------------------------------");
       super.displayInformation(); //calling method displayInformatioin form parent class to display vacancy number, designation and job type
            if (this.joined){
                System.out.println("");
                System.out.println("------------------------------------------------------");
                System.out.println("-------------- Part time staff detail -----------------");
                System.out.println("------------------------------------------------------");
                System.out.println("Name of staff = "+getStaffName());
                System.out.println("Working shift = "+getShifts());
                System.out.println("Wages per Hour  = "+getWagesPerHour());
                System.out.println("Working Hour of = "+getWorkingHour());
                System.out.println("Staff was joined in : "+getJoiningDate());
                System.out.println("Qualification  = "+getQualification());
                System.out.println("Staff was appointed by = "+getAppointedBy());
                System.out.println("Income per day  = "+incomePerDay);
                System.out.println("------------------------------------------------------");
                System.out.println("");
            }
    }
    
}
