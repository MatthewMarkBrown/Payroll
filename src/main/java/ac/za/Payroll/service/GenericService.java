package ac.za.Payroll.service;

import ac.za.Payroll.factory.user.EmployeeFactory;
import ac.za.Payroll.model.demography.Gender;
import ac.za.Payroll.model.user.Employee;
import ac.za.Payroll.service.demography.GenderService;
import ac.za.Payroll.service.user.EmployeeService;
import ac.za.Payroll.service.user.impl.EmployeeServiceImpl;

public class GenericService {

    public Employee createEmployee(String firstName, String lastName, String gender){
        Employee employee = EmployeeFactory.buildEmployee(firstName, lastName);
        Gender g = GenderService.getGender(gender);

        EmployeeGender eg = EmployeeGenderFactory.buildEmployeeGender(employee.getEmployeeNumber(), g.getId());

        EmployeeServiceImpl.getEmployeeService().create(employee);
        EmployeeGenderService.getEmployeeGenderService().create(eg);
    }

}
