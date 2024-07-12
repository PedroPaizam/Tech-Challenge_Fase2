package br.com.fiap.postech.tech_challenge_2.controller;

import br.com.fiap.postech.tech_challenge_2.dto.ParkingMeterDTO;
import br.com.fiap.postech.tech_challenge_2.entities.ParkingMeter;
import br.com.fiap.postech.tech_challenge_2.service.ParkingMeterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.UUID;

@RestController
@RequestMapping("/parkingMeter")
public class ParkingMeterController {

    @Autowired
    private ParkingMeterService parkingMeterService;

    @GetMapping("/{id}")
    public ResponseEntity<ParkingMeterDTO> getParkingMeter(@PathVariable UUID id) {
        var parkingMeter = parkingMeterService.findById(id);
        return ResponseEntity.ok(parkingMeter);
    }

    @GetMapping
    public ResponseEntity<Collection<ParkingMeterDTO>> getAllParkingMeters() {
        var parkingMeters = parkingMeterService.findAll();
        return ResponseEntity.ok(parkingMeters);
    }

    @PostMapping
    public ResponseEntity<ParkingMeter> create(@RequestBody String address){
        ParkingMeter parkingMeter = new ParkingMeter(address);
        //ParkingMeterDTO parkingMeterDTO = toParkingMeterDTO(parkingMeter);
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(parkingMeter);
    }
}
