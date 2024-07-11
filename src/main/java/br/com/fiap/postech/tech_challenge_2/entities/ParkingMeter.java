package br.com.fiap.postech.tech_challenge_2.entities;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "parkingMeters")
public class ParkingMeter {
    @Id
    UUID id;
    String address;

    public ParkingMeter() {}

    public ParkingMeter(UUID id, String address) {
        this.id = id;
        this.address = address;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParkingMeter that = (ParkingMeter) o;
        return Objects.equals(id, that.id) && Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address);
    }

    @Override
    public String toString() {
        return "ParkingMeter{" +
                "id=" + id +
                ", address='" + address + '\'' +
                '}';
    }
}
