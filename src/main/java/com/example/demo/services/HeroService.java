package com.example.demo.services;

import com.example.demo.entities.Hero;
import com.example.demo.repositories.HeroRepositorie;
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
        if (!hero.isValid()) {
            throw new IllegalArgumentException("La somme des attributs ne doit pas dépasser 300.");
        }
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
        Hero selectedHero = heroes.get(rand.nextInt(heroes.size()));

        return new Hero(
                selectedHero.getId(),
                selectedHero.getName(),
                selectedHero.getUniverse(),
                selectedHero.getStrength(),
                selectedHero.getDefense(),
                selectedHero.getSpeed(),
                selectedHero.getAccuracy(),
                selectedHero.getIntelligence(),
                selectedHero.getLuck()
        );
    }

    public  Optional<Hero> searchHeroByName(String name) {
        return heroRepositorie.findByNameContainingIgnoreCase(name);
    }
}
