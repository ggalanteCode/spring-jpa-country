package com.soprasteria.springjpacountries.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.soprasteria.springjpacountries.entities.Country;
import com.soprasteria.springjpacountries.repo.CountryRepository;

@RestController
@RequestMapping("/country")
public class CountryController {
	
	@Autowired
	private CountryRepository countryRepository;
	
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
	
	@GetMapping("/countriesByRegion")
	public List<Country> countriesByRegion(@RequestParam(name = "regionId", required = true)Integer regionId) {
		return (List<Country>) countryRepository.findAllByRegion(regionId);
	}

}
