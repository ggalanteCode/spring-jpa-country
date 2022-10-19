package com.soprasteria.springjpacountries.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soprasteria.springjpacountries.entities.Region;
import com.soprasteria.springjpacountries.repo.RegionRepository;

@RestController
@RequestMapping("/region")
public class RegionController {
	
	@Autowired
	private RegionRepository regionRepository;
	
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

}
