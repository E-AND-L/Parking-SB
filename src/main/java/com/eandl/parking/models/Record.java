package com.eandl.parking.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

/**
 * @Record: Es una clase que representa un registro de entrada y salida de un vehículo. <br>
 * id: PK <br>
 * entry_date: Fecha de entrada <br>
 * exit_date: Fecha de salida <br>
 * isParked: Indica si el vehículo está aparcado o no <br>
 * vehicle_id: FK
 */
@Entity
@Table(name = "record")
@Getter
@Setter
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "entry_date", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp entryDate;
    @Column(name = "exit_date", nullable = true)
    private Timestamp exitDate;
    @Column(name = "is_parked", nullable = false, columnDefinition = "BOOLEAN DEFAULT TRUE")
    private Boolean parked;
    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicleId;
}
