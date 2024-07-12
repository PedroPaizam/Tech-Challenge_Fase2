package br.com.fiap.postech.tech_challenge_2.controller;

import br.com.fiap.postech.tech_challenge_2.dto.CarDTO;
import br.com.fiap.postech.tech_challenge_2.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/{plate}")
    public ResponseEntity<CarDTO> findById(@PathVariable String plate) {
        var car = carService.findById(plate);
        return ResponseEntity.ok(car);
    }

    @GetMapping
    public ResponseEntity<Collection<CarDTO>> findAll() {
        var cars = carService.findAll();
        return ResponseEntity.ok(cars);
    }

    @PostMapping()
    public ResponseEntity<CarDTO> create(@RequestBody CarDTO carDTO){
        carDTO = carService.create(carDTO);
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(carDTO);
    }
}
