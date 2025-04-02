package com.example.demo.repositories;

import com.example.demo.entities.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface HeroRepositorie extends JpaRepository<Hero, Long> {

    Optional<Hero> findById(Long id);

    Optional<Hero> findByNameContainingIgnoreCase(String name);
}