package com.digitalinnovation.livecoding.repository;

import com.digitalinnovation.livecoding.document.Hero;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@EnableScan
@Repository
public interface HeroesRepository extends CrudRepository<Hero, String>{
}
