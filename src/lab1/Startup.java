package lab1;

/**
 * In this lab your challenge is to fix the code in both classes to use
 * proper encapsulation and the four other best practices as explained by 
 * your instructor.
 *
 * @author      Jim Lombardo, WCTC Instructor
 * @version     1.01
 */
public class Startup {
    public static void main(String[] args) {
        Employee employee = new Employee("Peter","Piper","333-1234");
        
        // Send New employee's cube number as a paramater.
        employee.beginOrientation("Cube 116");

        // These methods are all moved within the Employee class.
        // This hides complexity from the end user.
        //        employee.meetDepartmentStaff();
        //        employee.meetWithHrForBenefitAndSalryInfo();
        //        employee.reviewDeptPolicies();

        // Added printlines to make sure that the method worked as expected.

        
        employee.beginOrientation("Cube 116");
//        employee.meetDepartmentStaff();
//        employee.meetWithHrForBenefitAndSalryInfo();
//        employee.reviewDeptPolicies();


        System.out.println("The employee's status is: " + employee.getStatus());
        System.out.println("The employee's name is "+employee.getFirstName()+" "
                +employee.getLastName());
        System.out.println("The employee's SSN is "+employee.getSsn());
        System.out.println("The employee's cube is "+employee.getCubeId());
    }
    
    
}
