package campaign;

import campaign.model.Campaign;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.io.File;
import java.io.IOException;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Application integration api test.
 */
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableConfigurationProperties
@TestPropertySource(locations = "/application-test.properties")
@Sql({"/schema.sql", "/data init campaign.sql"})
class ApplicationIntegrationApiTest {

    private static final Logger LOG = LoggerFactory.getLogger(ApplicationIntegrationApiTest.class);

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    /**
     * Test get.
     */
    @Test
    public void testGet()
    {
        LOG.debug("testGet");
        var result = this.restTemplate
                .getForObject("http://localhost:" + port + "/api/campaigns/ec3b15b5-d075-4430-b447-c3d2661c64a0", Campaign.class);
        assertNotNull(result);

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

    /**
     * Test upload.
     *
     * @throws IOException the io exception
     */
    @Test
    public void testUpload() throws IOException {
        LOG.debug("testUpload");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("file", getTestFile());

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

        ResponseEntity<Campaign> result = restTemplate.postForEntity("/api/campaign/upload_scenarios",
                requestEntity, Campaign.class);

        assertNotNull(result);
    }

    private static Resource getTestFile() throws IOException {
        String _path = "src/test/resources";

        File file = new File(_path);
        String absolutePath = file.getAbsolutePath();

        var absolutePathTestFile = absolutePath + "/convertcsv.csv";

        // Converting the file into a byte array
        // using Files.readAllBytes() method
        File testFile = new File(absolutePathTestFile);
        return new FileSystemResource(testFile);
    }
}