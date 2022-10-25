package com.soprasteria.springjpacountries.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soprasteria.springjpacountries.entities.Continent;
import com.soprasteria.springjpacountries.entities.Country;
import com.soprasteria.springjpacountries.entities.Region;
import com.soprasteria.springjpacountries.repo.ContinentRepository;
import com.soprasteria.springjpacountries.repo.RegionRepository;

@RestController
@RequestMapping("/region")
public class RegionController {
	
	@Autowired
	private RegionRepository regionRepository;
	
	@Autowired
	private ContinentRepository continentRepository;
	
	@GetMapping("/allregions")
	public List<Region> regions() {
		return (List<Region>) regionRepository.findAll();
	}
	
	@GetMapping("/{regionId}")
	public Region regionById(@PathVariable(value = "regionId") Integer regionId) {
		Optional<Region> region = regionRepository.findById(regionId);
		if(region.isPresent()) {
			return region.get();
		} else {
			return new Region();
		}
	}
	
	@GetMapping("/regionsByContinent/{continentId}")
	public List<Region> regionsByContinent(@PathVariable(value = "continentId", required = true)Integer continentId) {
		Optional<Continent> continent = continentRepository.findById(continentId);
		if(continent.isPresent()) {
			return regionRepository.findAllByContinent(continent.get());
		} else {
			return new ArrayList<>();
		}
	}
	
	@PostMapping("/insertregion")
	public ResponseEntity<Region> insertNewRegion(@RequestBody Region region) {
		return new ResponseEntity<Region>(regionRepository.save(region), HttpStatus.OK);
	}

}
