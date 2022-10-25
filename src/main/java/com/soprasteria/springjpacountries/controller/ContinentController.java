package com.soprasteria.springjpacountries.controller;

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
import com.soprasteria.springjpacountries.repo.ContinentRepository;

@RestController
@RequestMapping("/continent")
public class ContinentController {
	
	@Autowired
	private ContinentRepository continentRepository;
	
	@GetMapping("/allcontinents")
	public List<Continent> continents() {
		return (List<Continent>) continentRepository.findAll();
	}
	
	@GetMapping("/{continentId}")
	public Continent continentById(@PathVariable(value = "continentId") Integer continentId) {
		Optional<Continent> region = continentRepository.findById(continentId);
		if(region.isPresent()) {
			return region.get();
		} else {
			return new Continent();
		}
	}
	
	@PostMapping("/insertcontinent")
	public ResponseEntity<Continent> insertNewContinent(@RequestBody Continent continent) {
		return new ResponseEntity<Continent>(continentRepository.save(continent), HttpStatus.OK);
	}

}
