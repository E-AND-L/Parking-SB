package com.eandl.parking.repositories;

import com.eandl.parking.models.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {
    List<Record> findAllByVehicleId_PlateAndParked(String plate, boolean parked);
}
