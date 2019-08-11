package ac.za.Payroll.controllerTest.user;

import ac.za.Payroll.factory.user.EmployeeFactory;
import ac.za.Payroll.model.user.Employee;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class EmployeeControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/employee";

    @Test
    public void testGetAllEmployees() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Ignore
    public void testGetEmployeeById() {
        Employee employee = restTemplate.getForObject(baseURL + "/employee/1", Employee.class);
        System.out.println(employee.getEmployeeFirstName());
        assertNotNull(employee);
    }

    @Ignore
    public void testCreateEmployee() {
        Employee employee = EmployeeFactory.buildEmployee("John"," Doh",29);

        ResponseEntity<Employee> postResponse = restTemplate.postForEntity(baseURL + "/create", employee, Employee.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdateEmployee() {
        int id = 1;
        Employee employee = restTemplate.getForObject(baseURL + "/employee/" + id, Employee.class);

        restTemplate.put(baseURL + "/employees/" + id, employee);
        Employee updatedEmployee = restTemplate.getForObject(baseURL + "/Employee/" + id, Employee.class);
        assertNotNull(updatedEmployee);
    }

    @Ignore
    public void testDeleteEmployee() {
        int id = 2;
        Employee employee = restTemplate.getForObject(baseURL + "/employees/" + id, Employee.class);
        assertNotNull(employee);
        restTemplate.delete(baseURL + "/employees/" + id);
        try {
            employee = restTemplate.getForObject(baseURL + "/employees/" + id, Employee.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}
