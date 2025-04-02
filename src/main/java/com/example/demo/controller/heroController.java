package com.example.demo.controller;

import com.example.demo.entities.Hero;
import com.example.demo.services.HeroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.core.service.GenericResponseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hero")
@Tag(name = "Héro API", description = "Gestion des utilisateurs")
public class heroController {

    private HeroService hService;

    public heroController(HeroService hService, GenericResponseService responseBuilder) {
        this.hService = hService;
    }

    @Operation(summary = "Récupérer tous les héros", description = "Retourne la liste complète des héros")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Succès - Liste des héros récupérée"),
            @ApiResponse(responseCode = "500", description = "Erreur serveur")
    })
    @GetMapping
    public List<Hero> getAllHero() {
        return hService.getAllHero();
    }

    @Operation(summary = "Ajoute un héro", description = "endpoint pour ajouter un héro")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Succès - Héro ajouté"),
            @ApiResponse(responseCode = "500", description = "Erreur Serveur")
    })
    @PostMapping
    public Hero addHero(@RequestBody Hero hero) {
        return hService.addHero(hero);
    }

    @Operation(summary = "Recherche par id", description = "endpoint de recherche de héro par id bdd")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Succès - Héro ajouté"),
            @ApiResponse(responseCode = "500", description = "Erreur Serveur")
    })
    @GetMapping("/{id}")
    public Optional<Hero> getHeroById(@PathVariable Long id) {
        return hService.getHeroById(id);
    }

    @Operation(summary = "Récupère un héro", description = "Retourne un héro au hasard")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Succès - Héro ajouté"),
            @ApiResponse(responseCode = "500", description = "Erreur Serveur")
    })
    @GetMapping("/random")
    public Hero getRandomHero() {
        return hService.getRandomHero();
    }

    @Operation(summary = "Chercher un héro", description = "enpoint de recherche d'un héro par son nom")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Succès - Héro ajouté"),
            @ApiResponse(responseCode = "500", description = "Erreur Serveur")
    })
    @GetMapping("/search")
    public Optional<Hero> searchHeroByName(@RequestParam String name) {
        return hService.searchHeroByName(name);
    }
}
























