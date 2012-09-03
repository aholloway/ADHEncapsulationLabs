package lab1;

import java.util.Date;

/**
 * In this lab your challenge is to fix the code in both classes to use
 * proper encapsulation and the four other best practices as explained by 
 * your instructor.
 *
 * @author      Jim Lombardo, WCTC Instructor
 * @version     1.01
 */
public class Employee {
    //data should be hidden.  Data should have getters and setters
    private String firstName;
    private String lastName;
    private String ssn;
    //birthDate is not used initially but will now have a getter and setter method.
    private Date birthDate;
    private boolean metWithHr;
    private boolean metDeptStaff;
    private boolean reviewedDeptPolicies;
    private boolean movedIn;
    private String cubeId;

    // I'm creating a constructor that takes some of the properties as arguments
    public Employee(String fName, String lName, String ssn) {
        //needs validation
        firstName=fName;
        lastName=lName;
        this.ssn=ssn;

    }
    
    //Getters amd setters for firstName, lastName, ssn, and birthDate, and cubeId
    //Setters need validation.
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    
    public String getCubeId() {
        return cubeId;
    }
 
    //setCubeId is included so that the employee can move to a new cube without
    //going through the hiring process :)
    public void setCubeId(String cubeId) {
        this.cubeId = cubeId;
    }
    
    
    // this method pulls the four methods of orientation into a single method.
    public void beginOrientation(String cubeId){
        //need validation of Cube ID string
        
        //call private methods in the correct order.  
        //complexity is hidden from the end user.
        this.meetWithHrForBenefitAndSalryInfo();
        this.meetDepartmentStaff();
        this.reviewDeptPolicies();
        this.moveIntoCubicle(cubeId);
        
    }
    
    //four methods should be private and are now called by the beginOrientation method
    // Assume this must be performed first
    private void meetWithHrForBenefitAndSalryInfo() {
        metWithHr = true;
    }

    // Assume this is must be performed second
    private void meetDepartmentStaff() {
        if(metWithHr) {
            metDeptStaff = true;
        } else {
            throw new IllegalStateException("Sorry, you cannot meet with "
                    + "department staff until you have met with HR.");
        }
    }

    // Assume this must be performed third
    private void reviewDeptPolicies() {
        if(metWithHr && metDeptStaff) {
            reviewedDeptPolicies = true;
        } else {
            throw new IllegalStateException("Sorry, you cannot review "
                    + " department policies until you have first met with HR "
                    + "and then with department staff.");
        }
    }

    // Assume this must be performed 4th
    private void moveIntoCubicle(String cubeId) {
        if(metWithHr && metDeptStaff && reviewedDeptPolicies) {
            this.cubeId = cubeId; //could also use the setter method.
            this.movedIn = true;
        } else {
            throw new IllegalStateException("Sorry, you cannot move in to a "
                    + "cubicle until you have first met with HR "
                    + "and then with department staff, and then reviewed"
                    + "department policies.");
        }

    }

    public String getStatus() {
        if(metWithHr && metDeptStaff
           && reviewedDeptPolicies && movedIn) {
            return "Orientation is complete";
        } else {
            return "Orientation in progress...";
        }
    }
}
