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

    private final HeroRepositorie heroRepositorie;

    public HeroService(HeroRepositorie heroRepositorie) {
        this.heroRepositorie = heroRepositorie;
    }

    public List<Hero> getAllHero() {
        return heroRepositorie.findAll();
    }

    public  Hero addHero(Hero hero) {
        return heroRepositorie.save(hero);
    }

    public  Optional<Hero> getHeroById(Long id) {
        return heroRepositorie.findById(id);
    }

    public  Hero getRandomHero() {
        List<Hero> heroes = heroRepositorie.findAll();
        if (heroes.isEmpty()) {
            return null;
        }
        Random rand = new Random();
        return heroes.get(rand.nextInt(heroes.size()));
    }

    public  Optional<Hero> searchHeroByName(String name) {
        return heroRepositorie.findByNameContainingIgnoreCase(name);
    }
}
