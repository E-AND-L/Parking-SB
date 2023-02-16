package com.eandl.parking.services.implement;

import com.eandl.parking.controllers.RecordController;
import com.eandl.parking.models.Record;
import com.eandl.parking.models.Vehicle;
import com.eandl.parking.repositories.RecordRepository;
import com.eandl.parking.repositories.VehicleRepository;
import com.eandl.parking.services.dto.RecordDto;
import com.eandl.parking.services.service.RecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RecordServiceImp implements RecordService {
    Logger LOGGER = LoggerFactory.getLogger(RecordServiceImp.class);
    @Autowired
    private RecordRepository recordRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    public ResponseEntity<List<Record>> getAllRecords() {
        return ResponseEntity.ok(recordRepository.findAll());
    }

    public String saveRecord(RecordDto record) {
        Optional<Vehicle> vehicle = vehicleRepository.findByPlate(record.getPlate());
        if (vehicle.isPresent()) {
            // Validar si el vehiculo ya tiene un registro activo
            List<Record> records = recordRepository.findAllByVehicleId_PlateAndParked(record.getPlate(), true);
            // Si la lista viene vacía, se crea un nuevo registro
            if (records.isEmpty()) {
                Record newRecord = new Record();
                newRecord.setVehicleId(vehicle.get());
                newRecord.setParked(true);
                recordRepository.save(newRecord);
                return "record created";
            } else {
                return "vehicle already parked";
            }
        } else {
            return "vehicle not found";
        }
    }

    public String updateRecord(RecordDto record) {
        // Actualizar registro
        Optional<Record> recordToUpdate = recordRepository.findById(record.getId());
        if (recordToUpdate.isPresent()) {
            if (!recordToUpdate.get().getParked()) {
                return "vehicle is not parked";
            }
            recordToUpdate.get().setParked(false);
            Date date = new Date();
            Timestamp timestamp = new Timestamp(date.getTime());
            recordToUpdate.get().setExitDate(timestamp);
            recordRepository.save(recordToUpdate.get());
            return "update success";
        } else {
            return "update not found";
        }
    }
}
