package com.soprasteria.springjpacountries.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.soprasteria.springjpacountries.entities.Country;
import com.soprasteria.springjpacountries.entities.Region;

@Repository
public interface CountryRepository extends CrudRepository<Country, Integer> {
	
	public List<Country> findAllByRegion(Region region);

}
