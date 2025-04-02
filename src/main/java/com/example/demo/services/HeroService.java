package com.example.demo.services;

import com.example.demo.entities.Hero;
import com.example.demo.repositories.HeroRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class HeroService {

    @Autowired
    private static HeroRepositorie heroRepositorie;

    public static List<Hero> getAllHero() {
        return heroRepositorie.findAll();
    }

    public static Hero addHero(Hero hero) {
        return heroRepositorie.save(hero);
    }

    public static Optional<Hero> getHeroById(Long id) {
        return heroRepositorie.findById(id);
    }

    public static Hero getRandomHero() {
        List<Hero> heroes = heroRepositorie.findAll();
        if (heroes.isEmpty()) {
            return null;
        }
        Random rand = new Random();
        return heroes.get(rand.nextInt(heroes.size()));
    }

    public static Optional<Hero> searchHeroByName(String name) {
        return heroRepositorie.findByNameContainingIgnoreCase(name);
    }
}
