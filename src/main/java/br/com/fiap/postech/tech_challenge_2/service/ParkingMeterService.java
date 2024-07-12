package br.com.fiap.postech.tech_challenge_2.service;

import br.com.fiap.postech.tech_challenge_2.controller.exception.ControllerNotFoundException;
import br.com.fiap.postech.tech_challenge_2.dto.ParkingMeterDTO;
import br.com.fiap.postech.tech_challenge_2.entities.ParkingMeter;
import br.com.fiap.postech.tech_challenge_2.repository.ParkingMeterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ParkingMeterService {

    @Autowired
    private ParkingMeterRepository parkingMeterRepository;

    public ParkingMeterDTO findById(UUID id) {
        var parkingMeter = parkingMeterRepository.findById(id).orElseThrow(() -> new ControllerNotFoundException("Parking meter not found"));
        assert parkingMeter != null;
        return toParkingMeterDTO(parkingMeter);
    }

    public Collection<ParkingMeterDTO> findAll() {
        var parkingMeters = parkingMeterRepository.findAll();
        return parkingMeters
                .stream()
                .map(this::toParkingMeterDTO)
                .collect(Collectors.toList());
    }

    public ParkingMeterDTO create(ParkingMeterDTO parkingMeterDTO){
        ParkingMeter parkingMeter = toParkingMeter(parkingMeterDTO);
        parkingMeter = parkingMeterRepository.save(parkingMeter);
        return toParkingMeterDTO(parkingMeter);
    }

    private ParkingMeterDTO toParkingMeterDTO(ParkingMeter parkingMeter) {
        return new ParkingMeterDTO(parkingMeter.getId(),
                parkingMeter.getAddress());
    }

    private ParkingMeter toParkingMeter(ParkingMeterDTO parkingMeterDTO) {
        return new ParkingMeter(parkingMeterDTO.id(),
                parkingMeterDTO.address());
    }
}
