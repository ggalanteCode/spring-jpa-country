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
	public ResponseEntity<List<Country>> countries() {
		return new ResponseEntity<List<Country>>((List<Country>)countryRepository.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("/{countryId}")
	public ResponseEntity<Country> countryById(@PathVariable(value = "countryId") Integer countryId) {
		Optional<Country> country = countryRepository.findById(countryId);
		if(country.isPresent()) {
			return new ResponseEntity<Country>(country.get(),HttpStatus.OK);
		} else {
			return new ResponseEntity<Country>((Country)null, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/countriesByRegion/{regionId}")
	public ResponseEntity<List<Country>> countriesByRegion(@PathVariable(value = "regionId", required = true)Integer regionId) {
		Optional<Region> region = regionRepository.findById(regionId);
		if(region.isPresent()) {
			return new ResponseEntity<List<Country>>((List<Country>)countryRepository.findAllByRegion(region.get()),HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Country>>((List<Country>)null, HttpStatus.NOT_FOUND);
		}
		
	}
	
	//SE IL COUNTRY NON ESISTE, NON SI PUO' FARE NULLA
	@PostMapping("/insertcountry/{regionID}")
	public ResponseEntity<Country> insertNewCountry(@RequestBody Country country,
													@PathVariable(value = "regionID") Integer regionID) {
		Optional<Region> findById = regionRepository.findById(regionID);
		
		if (findById.isPresent()) {
			country.setRegion(findById.get());
		}
		
		return new ResponseEntity<Country>(countryRepository.save(country), HttpStatus.OK);
	}
	
	@PutMapping("/updatecountry/{countryID}")
	public ResponseEntity<Country> updateACountry(@PathVariable(value = "countryID", required = true) Integer countryID,
												  @RequestBody Country country) {
		Optional<Country> optional = countryRepository.findById(countryID);
		if(optional.isPresent()) {
			country.setCountry_id(countryID);
			return new ResponseEntity<Country>(countryRepository.save(country),HttpStatus.OK);
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