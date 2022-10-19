package com.soprasteria.springjpacountries.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.soprasteria.springjpacountries.entities.Country;
import com.soprasteria.springjpacountries.entities.Region;
import com.soprasteria.springjpacountries.repo.CountryRepository;
import com.soprasteria.springjpacountries.repo.RegionRepository;

@RestController
@RequestMapping("/country")
public class CountryController {
	
	@Autowired
	private CountryRepository countryRepository;
	
	@Autowired
	private RegionRepository regionRepository;
	
	@GetMapping("/allcountries")
	public List<Country> countries() {
		return (List<Country>) countryRepository.findAll();
	}
	
	@GetMapping("/{countryId}")
	public Country countryById(@PathVariable(value = "countryId") Integer countryId) {
		Optional<Country> country = countryRepository.findById(countryId);
		if(country.isPresent()) {
			return country.get();
		} else {
			return new Country();
		}
	}
	
	@GetMapping("/countriesByRegion/{regionId}")
	public List<Country> countriesByRegion(@PathVariable(value = "regionId", required = true)Integer regionId) {
		Optional<Region> region = regionRepository.findById(regionId);
		if(region.isPresent()) {
			return (List<Country>) countryRepository.findAllByRegion(region.get());
		} else {
			return new ArrayList<>();
		}
		
	}

}
