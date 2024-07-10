package br.com.fiap.postech.tech_challenge_2.dto;

import java.util.UUID;

public record CarDTO(UUID id, String plate, String model, String color) {
}
