package com.soprasteria.springjpacountries.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.soprasteria.springjpacountries.entities.Continent;
import com.soprasteria.springjpacountries.entities.Region;

@Repository
public interface RegionRepository extends CrudRepository<Region, Integer> {
	
	public List<Region> findAllByContinent(Continent continent);

}
