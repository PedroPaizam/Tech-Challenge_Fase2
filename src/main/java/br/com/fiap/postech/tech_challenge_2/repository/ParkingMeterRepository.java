package br.com.fiap.postech.tech_challenge_2.repository;

import br.com.fiap.postech.tech_challenge_2.entities.ParkingMeter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ParkingMeterRepository extends JpaRepository<ParkingMeter, UUID> {
}
