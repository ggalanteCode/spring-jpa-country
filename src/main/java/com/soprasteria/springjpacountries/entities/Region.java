package com.soprasteria.springjpacountries.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "regions")
public class Region {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer region_id;
	
	@Column(nullable = false)
	private String name;
	
	@OneToMany(mappedBy = "countries")
	private List<Country> countries;
	
	@ManyToOne
	@JoinColumn(nullable = false, name = "continent_id")
	private Continent continent;

}
