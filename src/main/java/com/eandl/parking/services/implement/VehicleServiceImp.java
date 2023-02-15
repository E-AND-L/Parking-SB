package com.eandl.parking.services.implement;

import com.eandl.parking.models.Vehicle;
import com.eandl.parking.repositories.VehicleRepository;
import com.eandl.parking.services.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImp implements VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository; // findALl();

    public List<Vehicle> findAll() {
        return vehicleRepository.findAll();
    }

    public ResponseEntity<Vehicle> saveVehicle(Vehicle vehicle) {
        return ResponseEntity.ok(vehicleRepository.save(vehicle));
    }
}
