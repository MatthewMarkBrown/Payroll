package ac.za.Payroll.service.user;

import ac.za.Payroll.model.demography.Gender;
import ac.za.Payroll.model.demography.Race;
import ac.za.Payroll.model.user.Employee;

public interface CreateEmployeeService {
    Employee saveEmp(String id, String firstName, String lastName, int age, String Gender, String race);

    Gender getGender(String id);

    Race getRace(String id);
}
