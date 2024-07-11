package br.com.fiap.postech.tech_challenge_2.service;

//import br.com.fiap.postech.tech_challenge_2.controller.exception.ControllerNotFoundException;
import br.com.fiap.postech.tech_challenge_2.dto.CarDTO;
import br.com.fiap.postech.tech_challenge_2.entities.Car;
import br.com.fiap.postech.tech_challenge_2.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public CarDTO findById(String plate) {
        var car = carRepository.findById(plate).orElse(null);
        assert car != null;
        return toCarDTO(car);
    }

    public Collection<CarDTO> findAll() {
        var cars = carRepository.findAll();
        return cars
                .stream()
                .map(this::toCarDTO)
                .collect(Collectors.toList());
    }

    private CarDTO toCarDTO(Car car) {
        return new CarDTO(car.getPlate(),
                car.getModel(),
                car.getColor());
    }

    private Car toCarrinho(CarDTO carDTO) {
        return new Car(carDTO.plate(),
                carDTO.model(),
                carDTO.color());
    }
}
