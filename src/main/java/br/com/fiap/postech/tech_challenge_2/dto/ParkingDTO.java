package br.com.fiap.postech.tech_challenge_2.dto;

import java.util.Date;
import java.util.UUID;

public record ParkingDTO(UUID id, String car_plate, UUID parkingMeter_id, String entry, String exit) {
}
