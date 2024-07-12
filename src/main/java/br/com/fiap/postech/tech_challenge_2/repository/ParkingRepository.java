package br.com.fiap.postech.tech_challenge_2.repository;

import br.com.fiap.postech.tech_challenge_2.entities.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ParkingRepository extends JpaRepository<Parking, UUID> {
}
