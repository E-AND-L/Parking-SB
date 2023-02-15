package com.eandl.parking.controllers;

import com.eandl.parking.models.Vehicle;
import com.eandl.parking.services.implement.VehicleServiceImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("vehicles")
public class VehicleController {

    Logger LOGGER = LoggerFactory.getLogger(VehicleController.class);

    @Autowired
    private VehicleServiceImp vehicleServiceImp;

    @GetMapping
    public ResponseEntity<List<Vehicle>> getAllVehicles() {
        try {
            LOGGER.info("VEHICLES: Obteniendo todos los vehiculos");
            return ResponseEntity.ok(vehicleServiceImp.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(400).build();
        }

    }

    @PostMapping
    public ResponseEntity<Vehicle> saveVehicle(@RequestBody Vehicle vehicle) {
        try {
            LOGGER.info("VEHICLES: Guardando vehiculo");
            return vehicleServiceImp.saveVehicle(vehicle);
        } catch (Exception e) {
            return ResponseEntity.status(400).build();
        }
    }
}
