package com.soprasteria.springjpacountries.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

}
