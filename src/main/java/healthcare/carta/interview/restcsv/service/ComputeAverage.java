package healthcare.carta.interview.restcsv.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ComputeAverage {
    double findAverage(MultipartFile csvFile, String column) throws IOException;
}
