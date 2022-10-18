package com.soprasteria.springjpacountries.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "continents")
public class Continent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer continent_id;
	
	@Column(nullable = false)
	private String name;
	
	@OneToMany(mappedBy = "regions")
	private List<Region> regions;

	public Integer getContinent_id() {
		return continent_id;
	}

	public void setContinent_id(Integer continent_id) {
		this.continent_id = continent_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Region> getRegions() {
		return regions;
	}

	public void setRegions(List<Region> regions) {
		this.regions = regions;
	}

}
