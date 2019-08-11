package ac.za.Payroll.controllerTest.demography;

import ac.za.Payroll.factory.demography.RaceFactory;
import ac.za.Payroll.model.demography.Race;
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
public class RaceControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/race";

    @Test
    public void testGetAllRaces() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Ignore
    public void testGetRaceById() {
        Race race = restTemplate.getForObject(baseURL + "/race/1", Race.class);
        System.out.println(race.getRaceName());
        assertNotNull(race);
    }

    @Ignore
    public void testCreateRace() {
        Race race = RaceFactory.buildRace("Asian");

        ResponseEntity<Race> postResponse = restTemplate.postForEntity(baseURL + "/create", race, Race.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdateRace() {
        int id = 1;
        Race race = restTemplate.getForObject(baseURL + "/race/" + id, Race.class);

        restTemplate.put(baseURL + "/races/" + id, race);
        Race updatedRace = restTemplate.getForObject(baseURL + "/Race/" + id, Race.class);
        assertNotNull(updatedRace);
    }

    @Ignore
    public void testDeleteRace() {
        int id = 2;
        Race race = restTemplate.getForObject(baseURL + "/races/" + id, Race.class);
        assertNotNull(race);
        restTemplate.delete(baseURL + "/races/" + id);
        try {
            race = restTemplate.getForObject(baseURL + "/races/" + id, Race.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}