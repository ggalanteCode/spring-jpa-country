package com.soprasteria.springjpacountries.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping("/insertcountry")
	public ResponseEntity<Country> insertNewCountry(@RequestBody Country country) {
		return new ResponseEntity<Country>(countryRepository.save(country), HttpStatus.OK);
	}
	
	@PutMapping("/updatecountry/{countryID}")
	public ResponseEntity<Country> updateACountry(@PathVariable(value = "countryID", required = true) Integer countryID,
												  @RequestBody Country country) {
		Optional<Country> optional = countryRepository.findById(countryID);
		if(optional.isPresent()) {
			Country updatedCountry = optional.get();
			updatedCountry.setArea(country.getArea());
			updatedCountry.setCountry_code2(country.getCountry_code2());
			updatedCountry.setCountry_code3(country.getCountry_code3());
			updatedCountry.setName(country.getName());
			updatedCountry.setRegion(country.getRegion());
			return new ResponseEntity<Country>(countryRepository.save(updatedCountry),HttpStatus.OK);
		} else {
			return new ResponseEntity<Country>((Country)null,HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/deletecountry/{countryID}")
	public ResponseEntity<Country> deleteACountry(@PathVariable(value = "countryID") Integer countryID) {
		countryRepository.deleteById(countryID);
		return new ResponseEntity<Country>(HttpStatus.OK);
	}

}