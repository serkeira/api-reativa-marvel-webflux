package com.digitalinnovation.livecoding.service;

import com.digitalinnovation.livecoding.document.Hero;
import com.digitalinnovation.livecoding.repository.HeroesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class HeroesService {

    @Autowired
    private HeroesRepository heroesRepository;

    public Flux<Hero> findAll() {

        return Flux.fromIterable(heroesRepository.findAll());
    }

    public Mono<Hero> findByIdHero(String id) {

        return Mono.justOrEmpty(heroesRepository.findById(id));
    }


    public Mono<Hero> save(Hero hero) {
        return Mono.justOrEmpty(heroesRepository.save(hero));
    }


    public Mono<Boolean> deletebyIDHero(String id) {
        heroesRepository.deleteById(id);
        return Mono.just(true);

    }

}

