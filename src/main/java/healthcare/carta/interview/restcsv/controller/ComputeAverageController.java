package healthcare.carta.interview.restcsv.controller;

import healthcare.carta.interview.restcsv.dto.ResponseMessage;
import healthcare.carta.interview.restcsv.service.ComputeAverage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class ComputeAverageController {
    @Autowired
    private ComputeAverage computeAverage;

    @PostMapping("/")
    public ResponseEntity<ResponseMessage> uploadCsvFile(
            @RequestParam("data") MultipartFile csvFile,
            @RequestParam("column") String column) throws IOException {

        double average = computeAverage.findAverage(csvFile, column);

        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(String.valueOf(average)));
    }
}
