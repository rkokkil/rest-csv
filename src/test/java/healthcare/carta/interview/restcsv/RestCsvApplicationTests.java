package healthcare.carta.interview.restcsv;

import healthcare.carta.interview.restcsv.controller.ComputeAverageController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class RestCsvApplicationTests {

    @Autowired
    ComputeAverageController computeAverageController;

    @Test
    void contextLoads() {
        assertNotNull(computeAverageController);
    }

}
