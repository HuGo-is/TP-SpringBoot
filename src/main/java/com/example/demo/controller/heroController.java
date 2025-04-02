package com.example.demo.controller;

import com.example.demo.entities.Hero;
import com.example.demo.services.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hero")
public class heroController {

    @Autowired
    private HeroService hService;

    @GetMapping
    public List<Hero> getAllHero() {
        return HeroService.getAllHero();
    }

    @PostMapping
    public Hero addHero(@RequestBody Hero hero) {
        return HeroService.addHero(hero);
    }

    @GetMapping("/{id}")
    public Optional<Hero> getHeroById(@PathVariable Long id) {
        return HeroService.getHeroById(id);
    }

    @GetMapping("/random")
    public Hero getRandomHero() {
        return HeroService.getRandomHero();
    }

    @GetMapping("/search")
    public Optional<Hero> searchHeroByName(@RequestParam String name) {
        return HeroService.searchHeroByName(name);
    }
}
























