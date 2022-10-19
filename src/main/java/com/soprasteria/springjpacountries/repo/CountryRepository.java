package com.soprasteria.springjpacountries.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.soprasteria.springjpacountries.entities.Country;

@Repository
public interface CountryRepository extends CrudRepository<Country, Integer> {

}
