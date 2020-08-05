package healthcare.carta.interview.restcsv.service.impl;

import healthcare.carta.interview.restcsv.service.ComputeAverage;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
public class ComputeAverageImpl implements ComputeAverage {
    @Override
    public double findAverage(MultipartFile csvFile, String column) throws IOException {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(csvFile.getInputStream()))) {
            CSVParser parser = new CSVParser(fileReader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
            return parser.getRecords().stream()
                    .mapToInt(record -> Integer.parseInt(record.get(column)))
                    .average().orElse(0.0);
        }
    }
}
