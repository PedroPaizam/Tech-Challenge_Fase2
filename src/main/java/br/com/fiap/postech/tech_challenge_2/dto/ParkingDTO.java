package br.com.fiap.postech.tech_challenge_2.dto;

import java.util.UUID;

public record ParkingDTO(String car_plate, UUID parkingMeter_id, String entry, String exit) {
}
