/**
* INGNepal class is made for the to provide the graphical support to user .
*It is GUI ( Graphical Uaser Interface) so that user can navigate easily and do their task.
* @author (Anish Basnet)
* @version (0.2)
*/
//importing the required modules
import javax.swing.*;
import java.awt.Font;
import java.awt.event.*;
import java.util.*;
public class INGNepal  implements ActionListener{ 
      //declaring the required frame, text box, combo box, button and label text
      JFrame FullForm,StaffForm,PartForm; // frame
      //label text
      JLabel lblStaff,lblStaffr,lblFullTimeStaff,lblPartTimeStaff,lblFullEmployeeNumber, lblFullDesignation, lblFullJobType, lblFullSalary, lblFullWorkingHours, lblFullVacancyNo, lblFullEmployeeName,
      lblFullJoiningDate,lblFullStaffName, lblFullQualification, lblFullAppointedBy,lblPartEmployeeNumber, lblPartDesignation,
      lblPartJobType,  lblPartWorkingHours, lblPartEmployeeName, lblPartEmployeeNo,lblPartVacancyNo , lblPartJoiningDate,lblPartStaffName,
      lblPartQualification, lblPartAppointedBy,lblPartWagesPerHour,lblPartShifts;
      
      JComboBox fullJobType,partJobType,partShift; // Combo box
      //Text feild
      JTextField txtFullEmployeeNumber, txtFullDesignation, txtFullJobType, txtFullSalary, txtFullWorkingHours, txtFullEmployeName, txtFullVacancyNo,
      txtFullJoiningDate,txtFullStaffName, txtFullQualification, txtFullAppointedBy ,txtPartEmployeeNumber, txtPartDesignation,
      txtPartJobType,  txtPartWorkingHours, txtPartEmployeeName, txtPartEmployeeNo,txtPartVacancyNo, txtPartJoiningDate,txtPartStaffName,
      txtPartQualification, txtPartAppointedBy,txtPartWagesPerHour,txtPartShifts;
                       
      PartTimeStaffHire newNo;
      //buttons                 
      JButton btnAddPartTimeStaff,btnFullTimeStaff,btnPartTimeStaff, btnFullAdd, btnFullAppoint,btnPartAdd, btnFullDisplay, btnPartTerminate, btnPartAppoint, btnPartDisplay,btnFullClear, btnPartClear;
                       
      ArrayList<StaffHire> list=new ArrayList<StaffHire>();
                   
      public static void main(String[] args){
           new INGNepal().StaffHireForm(); //calling constructor StaffHireForm()
      }
                   
      public void StaffHireForm(){   //This method has frame with 2 button called full time staff and part time staff
            Font newFont=new Font("TimesRoman",Font.BOLD,15); // for fonts
            Font newFonta=new Font("Arial",Font.PLAIN,16);
            StaffForm=new JFrame("Staff Hire");
            StaffForm.setSize(500,400);
            StaffForm.setLayout(null);
            StaffForm.setVisible(true);
            StaffForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // to end program after pressing cross(X) in gui 
                         
            lblStaff=new JLabel("**------------------------ Welcome ------------------------**");
            lblStaff.setFont(newFont);
            lblStaff.setBounds(70,20,360,100);
            StaffForm.add(lblStaff);
            
            lblStaffr=new JLabel("To   hire  the  staff  press  the  respective  button");
            lblStaffr.setFont(newFont);
            lblStaffr.setBounds(70,50,360,100);
            StaffForm.add(lblStaffr);
                         
            btnFullTimeStaff=new JButton("Full time staff");
            btnFullTimeStaff.setFont(newFonta);
            btnFullTimeStaff.setBounds(40,150,130,30);
            StaffForm.add(btnFullTimeStaff);
            btnFullTimeStaff.addActionListener(this);
                         
            btnPartTimeStaff=new JButton("Part time staff");
            btnPartTimeStaff.setFont(newFonta);
            btnPartTimeStaff.setBounds(300,150,130,30);
            StaffForm.add(btnPartTimeStaff);
            btnPartTimeStaff.addActionListener(this);
      }
 
      public void actionPerformed(ActionEvent a){ // This method notifies the respective method when the button is pressed
               // full time staff
            if(a.getSource().equals(btnFullTimeStaff)){
                FullTimeStaffForm();
            }
                //part time staff       
            if(a.getSource().equals(btnPartTimeStaff)){
                PartTimeStaffForm();
            }
               // Full Time staff add button          
            if(a.getSource().equals(btnFullAdd)){
                btnFullAdd();
            }                     
                // full time appoint button 
            if(a.getSource()==btnFullAppoint){
                btnFullAppoint();
            }                       
                 // part time add button               
            if(a.getSource().equals(btnPartAdd)){
                btnPartAdd();
            }
                 //part time appoint button  
            if(a.getSource()==btnPartAppoint){
                btnPartAppoint();  
            }
                  //part time terminate button               
            if(a.getSource()==btnPartTerminate){
                btnPartTerminate();
            }
                 //full time clear button                   
            if(a.getSource()==btnFullClear){
                btnFullClear();
            }
                  //part time clear button
            if(a.getSource()==btnPartClear){
                btnPartClear();
            }
                //Full time display
            if(a.getSource()==btnFullDisplay){
                btnFullDisplay();
            }
                  // part time display           
            if(a.getSource()==btnPartDisplay){
                btnPartDisplay();
            }
      }
                   
      public void btnFullAdd(){  // This method has all of the task that the add button in full time staff form does
           String vacancyNo = txtFullVacancyNo.getText(); // pulling the values from user input and storing in new variable
           String designation= txtFullDesignation.getText();
           String jobType=(fullJobType.getSelectedItem()).toString();
           String workingHour=txtFullWorkingHours.getText();
           String salary=txtFullSalary.getText();
           try{   // try catch is to prevent the crash in program from different exceptions
                if(vacancyNo.isEmpty() || designation.isEmpty() ||jobType.isEmpty() || workingHour.isEmpty()||salary.isEmpty()){
                    throw new NullPointerException();
                }
                try{
                    int vacancyNoF = Integer.parseInt(vacancyNo); // converting string to int
                    int workingHourF = Integer.parseInt(workingHour);
                    int salaryF = Integer.parseInt(salary);
                    boolean vnoFound=false;
                    for(StaffHire l:list){
                        if(l.getVacancyNumber()==vacancyNoF) {
                            JOptionPane.showMessageDialog(FullForm,"Staff of entered vacancy number is already added.");
                            vnoFound=true;
                            break;
                        }
                    }
                    if(vnoFound==false){
                        FullTimeStaffHire fullTimeStaffHire=new FullTimeStaffHire(vacancyNoF,designation,jobType,salaryF,workingHourF);
                        list.add(fullTimeStaffHire);
                        JOptionPane.showMessageDialog(FullForm,"Full time staff is added successfully");
                    }
                }catch(Exception ex){ // to catch exception and show exception errors
                                JOptionPane.showMessageDialog(FullForm,"Please enter right values (Integer, String)");
                 }
           } catch(NullPointerException ex){
               JOptionPane.showMessageDialog(null,"Empty feild found please fill it.");
                           
           }
      }
               
      public void btnFullAppoint(){ // This method has all of the task that the add button in full time staff form does

               try{   // try catch is to prevent the crash in program from different exceptions
                     String vacancyNum = txtFullEmployeeNumber.getText(); // pulling the values from user input and storing in new variable
                     String staffName= txtFullEmployeName.getText();
                     String joiningDate= txtFullJoiningDate.getText();
                     String qualification=txtFullQualification.getText();
                     String appointedBy=txtFullAppointedBy.getText();
                     int vno=Integer.parseInt(vacancyNum);   // converting string to int
                     if(vacancyNum.isEmpty() || staffName.isEmpty()  ||joiningDate.isEmpty() ||qualification.isEmpty() ||appointedBy.isEmpty())
                            throw new NullPointerException();
                        else{
                            boolean vnoFound=false;
                            for(StaffHire l:list){
                                if(vno==l.getVacancyNumber()){
                                    vnoFound=true;
                                    if(l instanceof FullTimeStaffHire){
                                        FullTimeStaffHire obj=(FullTimeStaffHire)l;
                                        if(obj.getJoined()){
                                            JOptionPane.showMessageDialog(FullForm,"Staff of entered vacancy number is already appoointed");
                                            break;
                                        }else{
                                             obj.hireFullTimeStaff(staffName, joiningDate, qualification, appointedBy);
                                             JOptionPane.showMessageDialog(FullForm,"Full time staff is appointed successfully");
                                             break;
                                        }
                                    }else{
                                        JOptionPane.showMessageDialog(FullForm,"The entered vacancy number is already taken for part time staff, please enter new number");
                                        break;
                                    }
                                }
                            }
                            if(vnoFound==false){
                                JOptionPane.showMessageDialog(FullForm,"The vacancy number does not match to the added vacancy number");
                            }
                        }
                    }catch(NullPointerException ex){  // to catch exception and show exception errors
                             JOptionPane.showMessageDialog(null,"Empty feild found please fill it.");
                    }
                    catch(NumberFormatException ex){
                             JOptionPane.showMessageDialog(null,"Vacancy no is either empty or in string form, enter integer value");
                    }
      }
               
       public void btnPartAdd(){   // This method has all of the task that the add button in full time staff form does
           String vacancyNo = txtPartVacancyNo.getText();  // pulling the values from user input and storing in new variable
           String designation= txtPartDesignation.getText();
           String jobType=(partJobType.getSelectedItem()).toString();
           String wagesPerHour=txtPartWagesPerHour.getText();
           String shifts=(partShift.getSelectedItem()).toString();
                             
           String workingHour=txtPartWorkingHours.getText();
           try{    // try catch is to prevent the crash in program from different exceptions
                if(vacancyNo.isEmpty() ||designation.isEmpty() ||jobType.isEmpty() ||workingHour.isEmpty() ||wagesPerHour.isEmpty() ||shifts.isEmpty())
                    throw new NullPointerException();
                               
                try{
                    int vacancyNoP = Integer.parseInt(vacancyNo); // converting string to int
                    int workingHourP = Integer.parseInt(workingHour);
                    int wagesPerHourP=Integer.parseInt(wagesPerHour);
                    boolean vacancyLater=false;
                    for(StaffHire tempList:list){
                        if(tempList.getVacancyNumber()==vacancyNoP ) {
                            JOptionPane.showMessageDialog(PartForm,"Staff of entered vacancy number is already added");
                            vacancyLater=true;
                            break;
                        }
                    }
                    if(vacancyLater==false){
                        PartTimeStaffHire partTimeStaffHire=new PartTimeStaffHire(vacancyNoP,designation,jobType,workingHourP,wagesPerHourP,shifts);
                        list.add(partTimeStaffHire);
                        JOptionPane.showMessageDialog(PartForm,"Part time staff is added successfully");
                    }
                }catch(Exception ex){ // to catch exception and show exception errors
                    JOptionPane.showMessageDialog(PartForm,"Please enter right values (Integer, String)");
                }
            }catch(NullPointerException ex){                                   
                JOptionPane.showMessageDialog(null,"Empty feild found please fill it.");
            }
       }
               
       public void btnPartAppoint(){  // This method has all of the task that the add button in full time staff form does
            try{   // This method has all of the task that the add button in full time staff form does
                String vacancyNumPart = txtPartEmployeeNo.getText();  // pulling the values from user input and storing in new variable
                String staffNamePart= txtPartEmployeeName.getText();
                String joiningDatePart= txtPartJoiningDate.getText();
                String qualificationPart=txtPartQualification.getText();
                String appointedByPart=txtPartAppointedBy.getText();
                int vacancy=Integer.parseInt(vacancyNumPart);   // converting string to int
                if(vacancyNumPart.isEmpty() ||staffNamePart.isEmpty() ||joiningDatePart.isEmpty() ||qualificationPart.isEmpty() ||appointedByPart.isEmpty())
                    throw new NullPointerException();
                else{
                    boolean vacancyLater=false;
                    for(StaffHire vacancyValue:list){
                        if(vacancy==vacancyValue.getVacancyNumber()){
                            vacancyLater=true;                   
                            if(vacancyValue instanceof PartTimeStaffHire){                   
                                PartTimeStaffHire newValue=(PartTimeStaffHire)vacancyValue;                   
                                if(newValue.getJoined()){                   
                                    JOptionPane.showMessageDialog(PartForm,"Staff of entered vacancy number is already appoointed.");                   
                                    break;
                                }else{
                                    newValue.hirePartTimeStaff(staffNamePart, joiningDatePart, qualificationPart, appointedByPart);
                                    JOptionPane.showMessageDialog(PartForm,"Part time staff is appointed successfully");
                                    break;
                                }
                            }else{
                                JOptionPane.showMessageDialog(PartForm,"The entered vacancy number is taken by Full time staff");
                                break;
                            }
                        }
                    }
                    if(vacancyLater==false){
                        JOptionPane.showMessageDialog(PartForm,"The vacancy number does not match to the added vacancy number");
                    }
                }
            }
            catch(NullPointerException ex){ // to catch exception and show exception errors
                JOptionPane.showMessageDialog(null,"Empty feild found please fill it.");
            }   
            catch(NumberFormatException ex){   
                JOptionPane.showMessageDialog(null,"Vacancy no is either empty or in string form, enter integer value");
            }
       }
               
        public void btnPartTerminate(){  // This method does all of the task of terminate button in part time staff form
            try{    // to prevent crashing of program from exception
                String vacancyNo=JOptionPane.showInputDialog("Enter vacancy number to terminate the staff"); // ask input form user in dialog box
                int terminateNo=Integer.parseInt(vacancyNo); // converting string to int
                boolean vnoFound=false;
                 for(StaffHire checkList:list){  // checking in list
                    if(terminateNo==checkList.getVacancyNumber()){
                        vnoFound=true;
                        if(checkList instanceof PartTimeStaffHire){
                            newNo=(PartTimeStaffHire)checkList;
                            if(newNo.getTerminated()==false && newNo.getJoined()== true){
                                newNo.terminateTheStaff();
                                JOptionPane.showMessageDialog(PartForm,"Staff is terminated sucessfuly");
                                break;
                            }else{
                                JOptionPane.showMessageDialog(PartForm," Staff is already terminated.");
                                break;
                            }   
                        }   
                    }  
                }         
                if(vnoFound==false){
                    JOptionPane.showMessageDialog(PartForm," Please enter valid vacancy number");
                }                               
            }catch(Exception exp){     // to catch exception and show error message  
                JOptionPane.showMessageDialog(PartForm," Invalid input please input a  vacancy number or terminate after appointing the staff");
            }
       }               
       public void btnFullClear(){// This method is called when clear button of form full time staff hire is clicked 
            txtFullVacancyNo.setText("");// erasing the user input value to fill again for new values      
            txtFullDesignation.setText("");
            txtFullSalary.setText("");
            txtFullWorkingHours.setText("");
            txtFullEmployeName.setText("");
            txtFullEmployeeNumber.setText("");
            txtFullJoiningDate.setText("");
            txtFullQualification.setText("");
            txtFullAppointedBy .setText("");
        }
       public void btnPartClear(){
            txtPartVacancyNo.setText("");
            txtPartDesignation.setText("");
            txtPartWagesPerHour.setText("");
            txtPartWorkingHours.setText("");
            txtPartEmployeeNo.setText("");
            txtPartEmployeeName.setText("");
            txtPartJoiningDate.setText("");
            txtPartQualification.setText("");
            txtPartAppointedBy.setText("");
       }
       public void  btnFullDisplay(){ // this method shows the detail of full time staff and this method is called when display button in full time hire form is pressed 
           for(StaffHire b:list){
                if(b instanceof FullTimeStaffHire){
                    FullTimeStaffHire Fu=(FullTimeStaffHire) b;
                    Fu.displayFullTimeStaffInfo(); // calling the method  displayFullTimeStaffInfo()
                }
            }
        }
                       
       public void btnPartDisplay(){ // this method shows the detail of part time staff and this method is called when display button in part time hire form is pressed 
             for(StaffHire d:list){                
                if(d instanceof PartTimeStaffHire){
                    PartTimeStaffHire Pa=(PartTimeStaffHire) d;
                    Pa.displayPartTimeStaffInfo(); // calling the method  displayPartTimeStaffInfo()
                }
            }      
        }
        
        public void FullTimeStaffForm(){  // This method is to set all of the buttons, text feilds, combo box and label text in organised form of full time staff hire form
            Font newFont=new Font("TimesRoman",Font.BOLD,20);
            Font newFonta=new Font("Arial",Font.PLAIN,14); //Fonts
            Font newFontb=new Font("Arial",Font.BOLD,14);
            FullForm=new JFrame("Full Time Staff Hire");
            FullForm.setSize(500,700);           
            FullForm.setLayout(null);           
            FullForm.setVisible(true);           
            FullForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // to end program
           
            lblFullTimeStaff=new JLabel("Full Time Staff Hire");
            lblFullTimeStaff.setFont(newFont);
            lblFullTimeStaff.setBounds(150,10,230,30);           
            FullForm.add(lblFullTimeStaff);
           
            lblFullVacancyNo=new JLabel("Vacancy Number"); //Vacancy number
            lblFullVacancyNo.setFont(newFonta);
            lblFullVacancyNo.setBounds(30,50,170,25);          
            FullForm.add(lblFullVacancyNo);                 
            txtFullVacancyNo=new JTextField();
            lblFullVacancyNo.setFont(newFonta);
            txtFullVacancyNo.setBounds(143,50,80,25);          
            FullForm.add(txtFullVacancyNo);
                            
            lblFullDesignation=new JLabel("Designation"); //designation 
            lblFullDesignation.setFont(newFonta);
            lblFullDesignation.setBounds(30,100,130,30);           
            FullForm.add(lblFullDesignation);
            txtFullDesignation=new JTextField();
            txtFullDesignation.setFont(newFonta);
            txtFullDesignation.setBounds(140,100,170,25);           
            FullForm.add(txtFullDesignation);                 
           
            lblFullJobType=new JLabel("JobType"); //job type
            lblFullJobType.setFont(newFonta);
            lblFullJobType.setBounds(30,150,130,30);           
            FullForm.add(lblFullJobType);
            String[] fullJob={"Full Time"};
            fullJobType = new JComboBox(fullJob);
            fullJobType.setFont(newFonta);
            fullJobType.setBounds(140,150,170,25);
            FullForm.add(fullJobType);

            lblFullSalary=new JLabel("Salary"); // salary
            lblFullSalary.setFont(newFonta);
            lblFullSalary.setBounds(30,200,130,30);
            FullForm.add(lblFullSalary);
            txtFullSalary=new JTextField();
            txtFullSalary.setFont(newFonta);
            txtFullSalary.setBounds(140,200,170,25);
            FullForm.add(txtFullSalary);
                 
            lblFullWorkingHours=new JLabel("Working Hours"); //working hour
            lblFullWorkingHours.setFont(newFonta);
            lblFullWorkingHours.setBounds(30,250,130,30);
            FullForm.add(lblFullWorkingHours);
            txtFullWorkingHours=new JTextField();
            txtFullWorkingHours.setFont(newFonta);
            txtFullWorkingHours.setBounds(140,250,80,25);           
            FullForm.add(txtFullWorkingHours);
                 
            lblFullEmployeeNumber=new JLabel("Vacancy Number");  //vacancy number
            lblFullEmployeeNumber.setFont(newFonta);
            lblFullEmployeeNumber.setBounds(30,350,130,30);           
            FullForm.add(lblFullEmployeeNumber);                            
            txtFullEmployeeNumber=new JTextField(); 
            txtFullEmployeeNumber.setFont(newFonta);
            txtFullEmployeeNumber.setBounds(143,350,80,25);           
            FullForm.add(txtFullEmployeeNumber);

            lblFullEmployeeName=new JLabel("Staff Name"); //staff name
            lblFullEmployeeName.setFont(newFonta);
            lblFullEmployeeName.setBounds(30,400,130,30);           
            FullForm.add(lblFullEmployeeName);            
            txtFullEmployeName=new JTextField();
            txtFullEmployeName.setFont(newFonta);
            txtFullEmployeName.setBounds(140,400,170,25);           
            FullForm.add(txtFullEmployeName);
                            
            lblFullJoiningDate=new JLabel("Joining Date"); // joining date
            lblFullJoiningDate.setBounds(30,450,130,30);
            lblFullJoiningDate.setFont(newFonta);            
            FullForm.add(lblFullJoiningDate);
            txtFullJoiningDate=new JTextField();
            txtFullJoiningDate.setFont(newFonta);
            txtFullJoiningDate.setBounds(140,450,170,25);           
            FullForm.add(txtFullJoiningDate);
                            
            lblFullQualification=new JLabel("Qualification"); //qualification
            lblFullQualification.setFont(newFonta);
            lblFullQualification.setBounds(30,500,130,30);           
            FullForm.add(lblFullQualification);                 
            txtFullQualification=new JTextField();
            txtFullQualification.setFont(newFonta);
            txtFullQualification.setBounds(140,500,170,25);           
            FullForm.add(txtFullQualification);                 
           
            lblFullAppointedBy=new JLabel("Appointed By"); // appointed by 
            lblFullAppointedBy.setFont(newFonta);
            lblFullAppointedBy.setBounds(30,550,130,30);
            FullForm.add(lblFullAppointedBy);
            txtFullAppointedBy=new JTextField();
            txtFullAppointedBy.setFont(newFonta);
            txtFullAppointedBy.setBounds(140,550,170,25);           
            FullForm.add(txtFullAppointedBy);
                            
            btnFullAdd=new JButton("Add");  // Add button 
            btnFullAdd.setFont(newFontb);
            btnFullAdd.setBounds(340,290,90,30);           
            FullForm.add(btnFullAdd);           
            btnFullAdd.addActionListener(this);
                           
            btnFullAppoint=new JButton("Appoint"); //Appoint button 
            btnFullAppoint.setFont(newFontb);
            btnFullAppoint.setBounds(350,550,90,30);           
            FullForm.add(btnFullAppoint);
            btnFullAppoint.addActionListener(this);
                               
            btnFullDisplay=new JButton("Display"); // Display button 
            btnFullDisplay.setFont(newFontb);                           
            btnFullDisplay.setBounds(30,614,95,35);           
            FullForm.add(btnFullDisplay);          
            btnFullDisplay.addActionListener(this);
                            
            btnFullClear=new JButton("Clear"); // Clear button
            btnFullClear.setFont(newFontb);
            btnFullClear.setBounds(350,614,95,35);           
            FullForm.add(btnFullClear);
            btnFullClear.addActionListener(this);
        }
           
        public void PartTimeStaffForm(){ // This method is to set all of the buttons, text feilds, combo box and label text in organised form of Part time staff hire form
            Font newFont=new Font("TimesRoman",Font.BOLD,20);  // Fonts
            Font newFonta=new Font("Arial",Font.PLAIN,14);
            Font newFontb=new Font("Arial",Font.BOLD,14);
            PartForm=new JFrame("Part Time Staff Hire");           
            PartForm.setSize(500,730);           
            PartForm.setLayout(null);           
            PartForm.setVisible(true);           
            PartForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // To End program

            lblPartTimeStaff=new JLabel("Part Time Staff Hire");
            lblPartTimeStaff.setFont(newFont);
            lblPartTimeStaff.setBounds(150,10,230,30);
            PartForm.add(lblPartTimeStaff);

            lblPartVacancyNo=new JLabel("Vacancy Number"); // Vacancy number
            lblPartVacancyNo.setFont(newFonta);
            lblPartVacancyNo.setBounds(30,50,170,25);
            PartForm.add(lblPartVacancyNo);
            txtPartVacancyNo=new JTextField();
            txtPartVacancyNo.setBounds(143,50,80,25);           
            PartForm.add(txtPartVacancyNo);
                      
            lblPartDesignation=new JLabel("Designation"); // designation 
            lblPartDesignation.setFont(newFonta);
            lblPartDesignation.setBounds(30,100,130,30);
            PartForm.add(lblPartDesignation);
            txtPartDesignation=new JTextField();           
            txtPartDesignation.setBounds(140,100,170,25);           
            PartForm.add(txtPartDesignation);

            lblPartJobType=new JLabel("JobType"); //Job type
            lblPartJobType.setFont(newFonta);
            lblPartJobType.setBounds(30,150,130,30);           
            PartForm.add(lblPartJobType);
            String[] partJob={"Part Time"};
            partJobType=new JComboBox(partJob);
            partJobType.setFont(newFonta);
            partJobType.setBounds(140,150,170,25);
            PartForm.add(partJobType);
            
            lblPartWagesPerHour=new JLabel("Salary"); // Salary 
            lblPartWagesPerHour.setFont(newFonta);
            lblPartWagesPerHour.setBounds(30,200,130,30);           
            PartForm.add(lblPartWagesPerHour);
            txtPartWagesPerHour=new JTextField();           
            txtPartWagesPerHour.setBounds(140,200,80,25);           
            PartForm.add(txtPartWagesPerHour);

            lblPartWorkingHours=new JLabel("Working Hours"); // working hours
            lblPartWorkingHours.setFont(newFonta);
            lblPartWorkingHours.setBounds(30,250,170,25);           
            PartForm.add(lblPartWorkingHours);
            txtPartWorkingHours=new JTextField();           
            txtPartWorkingHours.setBounds(140,250,80,25);
            PartForm.add(txtPartWorkingHours);
            
            lblPartShifts=new JLabel("Shift");  // Shifts
            lblPartShifts.setFont(newFonta);
            lblPartShifts.setBounds(30,300,110,30);           
            PartForm.add(lblPartShifts);                 
            String[] shift={"Day","Night"};
            partShift= new JComboBox(shift);
            partShift.setFont(newFonta);
            partShift.setBounds(140,300,170,25);
            PartForm.add(partShift);
            txtPartShifts=new JTextField();           
            txtPartShifts.setBounds(140,300,170,25);           
            PartForm.add(txtPartShifts);
            
            lblPartEmployeeNo=new JLabel("Vacancy Number"); // Vacancy number
            lblPartEmployeeNo.setFont(newFonta);
            lblPartEmployeeNo.setBounds(30,350,170,25);
            PartForm.add(lblPartEmployeeNo);
            txtPartEmployeeNo=new JTextField();           
            txtPartEmployeeNo.setBounds(145,350,80,25);
            PartForm.add(txtPartEmployeeNo);
                           
            lblPartEmployeeName=new JLabel("Staff Name");  // Staff Name
            lblPartEmployeeName.setFont(newFonta);
            lblPartEmployeeName.setBounds(30,400,130,30);           
            PartForm.add(lblPartEmployeeName);
            txtPartEmployeeName=new JTextField();           
            txtPartEmployeeName.setBounds(140,400,170,25);           
            PartForm.add(txtPartEmployeeName);                 
           
            lblPartJoiningDate=new JLabel("Joining Date"); // Joining date
            lblPartJoiningDate.setFont(newFonta);
            lblPartJoiningDate.setBounds(30,450,130,30);           
            PartForm.add(lblPartJoiningDate);                 
            txtPartJoiningDate=new JTextField();           
            txtPartJoiningDate.setBounds(140,450,170,25);           
            PartForm.add(txtPartJoiningDate);                 
           
            lblPartQualification=new JLabel("Qualification"); // Qualification 
            lblPartQualification.setFont(newFonta);
            lblPartQualification.setBounds(30,500,130,30);           
            PartForm.add(lblPartQualification);                            
            txtPartQualification=new JTextField();                      
            txtPartQualification.setBounds(140,500,170,25);
            PartForm.add(txtPartQualification);
                 
            lblPartAppointedBy=new JLabel("Appointed By"); // Appointed by 
            lblPartAppointedBy.setFont(newFonta);
            lblPartAppointedBy.setBounds(30,550,130,30);
            PartForm.add(lblPartAppointedBy);                            
            txtPartAppointedBy=new JTextField();           
            txtPartAppointedBy.setBounds(140,550,170,25);           
            PartForm.add(txtPartAppointedBy);
                            
            btnPartAdd=new JButton("Add");  // Add button 
            btnPartAdd.setFont(newFontb);
            btnPartAdd.setBounds(350,300,90,25);
            PartForm.add(btnPartAdd);           
            btnPartAdd.addActionListener(this);                 
           
            btnPartAppoint=new JButton("Appoint");  // Appoint button 
            btnPartAppoint.setFont(newFontb);
            btnPartAppoint.setBounds(350,550,110,25);           
            PartForm.add(btnPartAppoint);           
            btnPartAppoint.addActionListener(this);
                            
            btnPartTerminate=new JButton("Terminate"); // Terminate button 
            btnPartTerminate.setFont(newFontb);
            btnPartTerminate.setBounds(350,450,110,25);           
            PartForm.add(btnPartTerminate);           
            btnPartTerminate.addActionListener(this);
                            
            btnPartDisplay=new JButton("Display");   // Display button
            btnPartDisplay.setFont(newFontb);
            btnPartDisplay.setBounds(30,630,110,30);           
            PartForm.add(btnPartDisplay);           
            btnPartDisplay.addActionListener(this);        
           
            btnPartClear=new JButton("Clear");  // Clear button
            btnPartClear.setFont(newFontb);
            btnPartClear.setBounds(350,630,110,30);           
            PartForm.add(btnPartClear);           
            btnPartClear.addActionListener(this);
        }  
}

       
           
       
       
        
