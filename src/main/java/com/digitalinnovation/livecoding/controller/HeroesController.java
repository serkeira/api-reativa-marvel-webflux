package com.digitalinnovation.livecoding.controller;

import com.digitalinnovation.livecoding.document.Hero;
import com.digitalinnovation.livecoding.repository.HeroesRepository;
import com.digitalinnovation.livecoding.service.HeroesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@Slf4j
@RequestMapping("/api/v1/")
public class HeroesController {

    @Autowired
    private HeroesService heroesService;

    @Autowired
    private HeroesRepository heroesRepository;

    private static final org.slf4j.Logger log =
            org.slf4j.LoggerFactory.getLogger(HeroesController.class);


    @GetMapping("/heroes")
    @ResponseStatus(HttpStatus.OK)
    public Flux<Hero> getAllItems() {
        log.info("requesting the list off all heroes");
        return heroesService.findAll();

    }


    @GetMapping("/heroes/{id}")
    public Mono<ResponseEntity<Hero>> findByIdHero(@PathVariable String id) {
        log.info("Requesting the hero with id {}", id);
        return heroesService.findByIdHero(id)
                .map((item) -> new ResponseEntity<>(item, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/heroes")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Hero> createHero(@RequestBody Hero hero) {
        log.info("A new Hero has been created");
        return heroesService.save(hero);

    }

    @DeleteMapping("/heroes/{id}")
    public Mono<HttpStatus> deletebyIDHero(@PathVariable String id) {
        heroesService.deletebyIDHero(id);
        log.info("Deleting the hero with id {}", id);
        return Mono.just(HttpStatus.ACCEPTED);
    }
}
