package campaign;

import campaign.model.Campaign;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.*;

//У данного теста не подтягивается application-test.properties из папки test
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableConfigurationProperties
@TestPropertySource(locations = "/application-test.properties")
@Sql({"/schema.sql"})
class ApplicationIntegrationApiTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGet()
    {
        var result = this.restTemplate
                .getForObject("http://localhost:" + port + "/api/campaigns/ec3b15b5-d075-4430-b447-c3d2661c64a0", Campaign.class);
        assertNull(result);

    }

//    @Test
//    public void testPost() {
//        /*
//        Employee employee = new Employee("Lokesh", "Gupta", "howtodoinjava@gmail.com");
//        ResponseEntity<String> responseEntity = this.restTemplate
//                .postForEntity("http://localhost:" + port + "/employees", employee, String.class);
//        assertEquals(201, responseEntity.getStatusCodeValue());
//        */
//    }
//
//    @Test
//    public void testPatch() {
//        /*
//        Employee employee = new Employee("Lokesh", "Gupta", "howtodoinjava@gmail.com");
//        ResponseEntity<String> responseEntity = this.restTemplate
//                .postForEntity("http://localhost:" + port + "/employees", employee, String.class);
//        assertEquals(201, responseEntity.getStatusCodeValue());
//        */
//    }
}