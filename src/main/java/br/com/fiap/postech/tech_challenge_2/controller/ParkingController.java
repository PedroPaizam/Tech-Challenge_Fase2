package br.com.fiap.postech.tech_challenge_2.controller;

import br.com.fiap.postech.tech_challenge_2.dto.ParkingDTO;
import br.com.fiap.postech.tech_challenge_2.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@RestController
@RequestMapping("/park")
public class ParkingController {

    @Autowired
    private ParkingService parkingService;

    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    @PostMapping("/plate={plate};parkingMeter={id};hours={hours}")
    public ResponseEntity<ParkingDTO> park(@PathVariable String plate, @PathVariable UUID id, @PathVariable int hours){
        String entry = LocalDateTime.now().format(dateTimeFormatter);
        String exit = LocalDateTime.now().plusHours(hours).format(dateTimeFormatter);
        ParkingDTO parkingDTO = new ParkingDTO(UUID.randomUUID(), plate, id, entry, exit);
        parkingService.park(parkingDTO);
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(parkingDTO);
    }
}
