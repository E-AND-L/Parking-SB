package com.eandl.parking.controllers;

import com.eandl.parking.models.Record;
import com.eandl.parking.services.dto.RecordDto;
import com.eandl.parking.services.implement.RecordServiceImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("records")
public class RecordController {
    @Autowired
    private RecordServiceImp recordServiceImp;

    Logger LOGGER = LoggerFactory.getLogger(RecordController.class);

    @GetMapping
    public ResponseEntity<List<Record>> getAllRecords() {
        try {
            return recordServiceImp.getAllRecords();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping
    public String saveRecord(@RequestBody RecordDto record) {
        try {
            return recordServiceImp.saveRecord(record);
        } catch (Exception e) {
            return "save failed";
        }
    }

    @PutMapping
    public String updateRecord(@RequestBody RecordDto record) {
        try {
            return recordServiceImp.updateRecord(record);
        } catch (Exception e) {
            return "update failed";
        }
    }
}
