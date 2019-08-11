package ac.za.Payroll.repository.user;

import ac.za.Payroll.model.user.Employee;
import ac.za.Payroll.repository.IRepository;

import java.util.Set;

public interface EmployeeRepository extends IRepository<Employee, String> {
    Set<Employee> getAll();
}
