package br.com.fiap.postech.tech_challenge_2.controller;

import br.com.fiap.postech.tech_challenge_2.dto.ParkingDTO;
import br.com.fiap.postech.tech_challenge_2.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@RestController
@RequestMapping("/park")
public class ParkingController {

    @Autowired
    private ParkingService parkingService;

    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    @PostMapping("/{plate}/{id}/{hours}")
    public ResponseEntity<ParkingDTO> park(@PathVariable String plate, @PathVariable String id, @PathVariable int hours){
        String entry = LocalDateTime.now().format(dateTimeFormatter);
        String exit = LocalDateTime.now().plusHours(hours).format(dateTimeFormatter);
        UUID id2 = UUID.fromString(id);
        ParkingDTO parkingDTO = new ParkingDTO(plate, id2, entry, exit);
        parkingService.park(parkingDTO);
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(parkingDTO);
    }

    @GetMapping("/isParked/{plate}")
    public ResponseEntity<Boolean> isParked(@PathVariable String plate){
        var parked = parkingService.findById(plate);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        boolean bool = LocalDateTime.now().isBefore(LocalDateTime.parse(parked.exit(), dateTimeFormatter));
        return ResponseEntity.ok(bool);
    }
}
