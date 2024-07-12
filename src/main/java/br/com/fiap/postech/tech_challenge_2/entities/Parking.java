package br.com.fiap.postech.tech_challenge_2.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "parking")

public class Parking {
    @Id
    private UUID id;
    private String car_plate;
    private UUID parkingMeter_id;
    private String entry;
    private String exit;

    public Parking(){}

    public Parking(UUID id, String car_plate, UUID parkingMeter_id, String entry, String exit){
        this.car_plate = car_plate;
        this.parkingMeter_id = parkingMeter_id;
        this.entry = entry;
        this.exit = exit;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCar_plate() {
        return car_plate;
    }

    public void setCar_plate(String car_plate) {
        this.car_plate = car_plate;
    }

    public UUID getParkingMeter_id() {
        return parkingMeter_id;
    }

    public void setParkingMeter_id(UUID parkingMeter_id) {
        this.parkingMeter_id = parkingMeter_id;
    }

    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }

    public String getExit() {
        return exit;
    }

    public void setExit(String exit) {
        this.exit = exit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parking parking = (Parking) o;
        return Objects.equals(id, parking.id) && Objects.equals(car_plate, parking.car_plate) && Objects.equals(parkingMeter_id, parking.parkingMeter_id) && Objects.equals(entry, parking.entry) && Objects.equals(exit, parking.exit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, car_plate, parkingMeter_id, entry, exit);
    }

    @Override
    public String toString() {
        return "Parking{" +
                "id=" + id +
                ", car_plate='" + car_plate + '\'' +
                ", parkingMeter_id=" + parkingMeter_id +
                ", entry=" + entry +
                ", exit=" + exit +
                '}';
    }
}
