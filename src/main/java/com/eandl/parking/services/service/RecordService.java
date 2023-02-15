package com.eandl.parking.services.service;

import com.eandl.parking.models.Record;
import com.eandl.parking.services.dto.RecordDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RecordService {
    ResponseEntity<List<Record>> getAllRecords();

    String saveRecord(RecordDto record);

    String updateRecord(RecordDto record);
}
