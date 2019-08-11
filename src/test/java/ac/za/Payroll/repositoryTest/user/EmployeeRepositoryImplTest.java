package ac.za.Payroll.repositoryTest.user;

import ac.za.Payroll.factory.user.EmployeeFactory;
import ac.za.Payroll.model.user.Employee;
import ac.za.Payroll.repository.user.EmployeeRepository;
import ac.za.Payroll.repository.user.impl.EmployeeRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeRepositoryImplTest {

    private EmployeeRepository repository;
    private Employee employee;

    private Employee getSavedEmployee() {
        Set<Employee> savedEmployees = this.repository.getAll();
        return savedEmployees.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = EmployeeRepositoryImpl.getRepository();
        this.employee = EmployeeFactory.buildEmployee("TestName", "TestSurname", 78);
    }

    @Test
    public void a_create() {
        Employee created = this.repository.create(this.employee);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.employee);
    }

    @Test
    public void b_read() {
        Employee savedEmployee = getSavedEmployee();
        System.out.println("In read, employeeId = "+ savedEmployee.getEmployeeId());
        Employee read = this.repository.read(savedEmployee.getEmployeeId());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedEmployee, read);
    }

    @Test
    public void e_delete() {
        Employee savedEmployee = getSavedEmployee();
        this.repository.delete(savedEmployee.getEmployeeId());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newname = "TestName";
        Employee employee = new Employee.Builder().copy(getSavedEmployee()).employeeFirstName(newname).build();
        System.out.println("In update, about_to_updated = " + employee);
        Employee updated = this.repository.update(employee);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newname, updated.getEmployeeFirstName());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Employee> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}
