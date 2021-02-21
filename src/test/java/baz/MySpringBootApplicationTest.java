package baz;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.web.server.LocalManagementPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.apache.camel.test.junit5.TestSupport.assertStringContains;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MySpringBootApplicationTest {

    @LocalManagementPort
    private String managementPort;

    @Autowired
    private TestRestTemplate restTemplate;

    private ResponseEntity<String> getForHealthGroup(String healthGroup) {
        return restTemplate.getForEntity("http://localhost:" + managementPort + "/actuator/health/" + healthGroup,
                String.class);
    }

    @Test
    void testLivenessReadiness() {
        ResponseEntity<String> liveness = getForHealthGroup("liveness");
        ResponseEntity<String> readiness = getForHealthGroup("readiness");

        assertEquals(HttpStatus.OK, liveness.getStatusCode());
        assertEquals(HttpStatus.OK, readiness.getStatusCode());

        assertNotNull(liveness.getBody());
        assertNotNull(readiness.getBody());

        assertStringContains(liveness.getBody(), "livenessState");
        assertStringContains(liveness.getBody(), "diskSpace");
        assertStringContains(liveness.getBody(), "camelHealth");
        assertStringContains(readiness.getBody(), "readinessState");
    }
}
