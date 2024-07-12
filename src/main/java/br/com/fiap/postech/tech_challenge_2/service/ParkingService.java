package br.com.fiap.postech.tech_challenge_2.service;

import br.com.fiap.postech.tech_challenge_2.dto.ParkingDTO;
import br.com.fiap.postech.tech_challenge_2.entities.Parking;
import br.com.fiap.postech.tech_challenge_2.repository.ParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ParkingService {

    @Autowired
    private ParkingRepository parkingRepository;

    public ParkingDTO findById(String plate){
        var parking = parkingRepository.findById(plate).orElse(null);
        assert parking != null;
        return toParkingDTO(parking);
    }

    public void park(ParkingDTO parkingDTO){
        var parking = toParking(parkingDTO);
        parkingRepository.save(parking);
    }

    private ParkingDTO toParkingDTO(Parking parking){
        return new ParkingDTO(parking.getCar_plate(),
                parking.getParkingMeter_id(),
                parking.getEntry(),
                parking.getExit());
    }

    private Parking toParking(ParkingDTO parkingDTO){
        return new Parking(parkingDTO.car_plate(),
                parkingDTO.parkingMeter_id(),
                parkingDTO.entry(),
                parkingDTO.exit());
    }
}
