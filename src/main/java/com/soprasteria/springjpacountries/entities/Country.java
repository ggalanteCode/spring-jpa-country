package com.soprasteria.springjpacountries.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "countries")
public class Country {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer country_id;
	
	private String name;
	
	@Column(nullable = false)
	private BigDecimal area;
	
	private LocalDate national_day;
	
	private String country_code2;
	
	private String country_code3;

}
