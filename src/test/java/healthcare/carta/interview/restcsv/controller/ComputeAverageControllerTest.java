package healthcare.carta.interview.restcsv.controller;

import healthcare.carta.interview.restcsv.service.ComputeAverage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;

import java.io.FileInputStream;
import java.nio.file.Paths;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class ComputeAverageControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    ComputeAverage computeAverage;

    @Test
    void uploadCsvFile() throws Exception {
        FileInputStream fis = new FileInputStream(Paths.get("src", "test", "resources").toFile().getAbsolutePath() + "/data.csv");
        MockMultipartFile file = new MockMultipartFile("data", fis);
        mockMvc.perform(multipart("/")
                .file(file)
                .accept(MediaType.ALL)
                .param("column", "number"))
                .andExpect(status().isOk());
    }
}