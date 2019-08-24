package ac.za.Payroll.factoryTest.user;

import ac.za.Payroll.factory.user.EmployeeFactory;
import ac.za.Payroll.model.user.Employee;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EmployeeFactoryTest {
    private String testFirstName;
    private String testLastName;
    private int testAge;

    @Before
    public void setUp() throws Exception {
        this.testFirstName = "testName";
        this.testLastName = "testName";
        this.testAge = 20;
    }

    @Test
    public void buildEmployee() {
        Employee course = EmployeeFactory.buildEmployee(this.testFirstName, this.testLastName, this.testAge);
        Assert.assertNotNull(course.getEmployeeId());
        Assert.assertNotNull(course);
    }
}
