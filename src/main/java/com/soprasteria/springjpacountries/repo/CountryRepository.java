package com.soprasteria.springjpacountries.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.soprasteria.springjpacountries.entities.Country;

@Repository
public interface CountryRepository extends CrudRepository<Country, Integer> {
	
//	@Query("select regions.region_id where ")
	public List<Country> findAllByRegion(Integer region);

}
