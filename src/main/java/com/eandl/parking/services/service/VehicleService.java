package com.eandl.parking.services.service;

import com.eandl.parking.models.Vehicle;

import java.util.List;

public interface VehicleService {

    List<Vehicle> findAll();

    String saveVehicle(Vehicle vehicle);
}
