package ac.za.Payroll.controllerTest.demography;

import ac.za.Payroll.factory.demography.GenderFactory;
import ac.za.Payroll.model.demography.Gender;
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
public class GenderControllerTest{
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/gender";

    @Test
    public void testGetAllGenders() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Ignore
    public void testGetGenderById() {
        Gender gender = restTemplate.getForObject(baseURL + "/gender/1", Gender.class);
        System.out.println(gender.getGenderName());
        assertNotNull(gender);
    }

    @Ignore
    public void testCreateGender() {
        Gender gender = GenderFactory.buildGender("Asian");

        ResponseEntity<Gender> postResponse = restTemplate.postForEntity(baseURL + "/create", gender, Gender.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdateGender() {
        int id = 1;
        Gender gender = restTemplate.getForObject(baseURL + "/gender/" + id, Gender.class);

        restTemplate.put(baseURL + "/genders/" + id, gender);
        Gender updatedGender = restTemplate.getForObject(baseURL + "/Gender/" + id, Gender.class);
        assertNotNull(updatedGender);
    }

    @Ignore
    public void testDeleteGender() {
        int id = 2;
        Gender gender = restTemplate.getForObject(baseURL + "/genders/" + id, Gender.class);
        assertNotNull(gender);
        restTemplate.delete(baseURL + "/genders/" + id);
        try {
            gender = restTemplate.getForObject(baseURL + "/genders/" + id, Gender.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}
