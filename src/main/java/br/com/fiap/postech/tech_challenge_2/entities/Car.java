package br.com.fiap.postech.tech_challenge_2.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "cars")

public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String placa;

}
