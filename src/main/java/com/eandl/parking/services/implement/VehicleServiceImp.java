package com.eandl.parking.services.implement;

import com.eandl.parking.models.Vehicle;
import com.eandl.parking.repositories.VehicleRepository;
import com.eandl.parking.services.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImp implements VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;

    public List<Vehicle> findAll() {
        return vehicleRepository.findAll();
    }

    public String saveVehicle(Vehicle vehicle) {
        Optional<Vehicle> isVehicle = vehicleRepository.findByPlate(vehicle.getPlate());
        if (isVehicle.isPresent()) {
            return "vehicle already exists";
        } else {
            vehicleRepository.save(vehicle);
            return "vehicle saved";
        }
    }
}
