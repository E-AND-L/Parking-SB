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
                return "Registro creado.";
            } else {
                return "El vehiculo ya se encuentra parqueado.";
            }
        } else {
            return "Vehiculo no encontrado";
        }
    }
}
