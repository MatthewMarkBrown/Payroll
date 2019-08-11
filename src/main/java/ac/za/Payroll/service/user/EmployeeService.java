package ac.za.Payroll.service.user;

import ac.za.Payroll.model.user.Employee;
import ac.za.Payroll.service.IService;

import java.util.Set;

public interface EmployeeService extends IService<Employee, String> {
    Set<Employee> getAll();
}
