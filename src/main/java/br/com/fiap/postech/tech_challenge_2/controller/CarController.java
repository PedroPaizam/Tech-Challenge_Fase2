package br.com.fiap.postech.tech_challenge_2.controller;

import br.com.fiap.postech.tech_challenge_2.dto.CarDTO;
import br.com.fiap.postech.tech_challenge_2.entities.Car;
import br.com.fiap.postech.tech_challenge_2.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.UUID;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/{id}")
    public ResponseEntity<CarDTO> findById(@PathVariable UUID id) {
        var cars = carService.findById(id);
        return ResponseEntity.ok(cars);
    }

    @GetMapping
    public ResponseEntity<Collection<CarDTO>> findAll() {
        var cars = carService.findAll();
        return ResponseEntity.ok(cars);
    }
}
