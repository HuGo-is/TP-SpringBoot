package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Hero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String universe;
    private int strength;
    private int defense;
    private int speed;
    private int accuracy;
    private int intelligence;
    private int luck;

    public boolean isValid() {
        return (strength + defense + speed + accuracy + intelligence + luck) <= 300;
    }
}
