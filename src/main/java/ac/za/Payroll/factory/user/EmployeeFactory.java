package ac.za.Payroll.factory.user;

import ac.za.Payroll.model.user.Employee;
import ac.za.Payroll.util.Misc;

public class EmployeeFactory {
    public static Employee buildEmployee(String firstName, String lastName, int age){
        return new Employee.Builder().age(age).employeeFirstName(firstName).employeeLastName(lastName).employeeId(Misc.generateId()).build();
    }
}
