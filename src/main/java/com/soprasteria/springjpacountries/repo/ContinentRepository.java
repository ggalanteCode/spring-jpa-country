package com.soprasteria.springjpacountries.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.soprasteria.springjpacountries.entities.Continent;

@Repository
public interface ContinentRepository extends CrudRepository<Continent, Integer> {
	
}
