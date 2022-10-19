package com.soprasteria.springjpacountries.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.soprasteria.springjpacountries.entities.Region;

@Repository
public interface RegionRepository extends CrudRepository<Region, Integer> {

}
