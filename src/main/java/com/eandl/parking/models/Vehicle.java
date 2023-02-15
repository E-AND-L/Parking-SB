package com.eandl.parking.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
    * @Vehicle: Es una clase que representa un vehículo. <br>
    * id: PK <br>
    * plate: Matrícula del vehículo <br>
    * type: Tipo de vehículo <br>
 */
@Entity
@Table(name = "vehicle")
@Getter
@Setter
public class Vehicle {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true, nullable = false, length = 10)
    private String plate;
    @Column(unique = true, nullable = false, length = 10)
    private String type;
}
