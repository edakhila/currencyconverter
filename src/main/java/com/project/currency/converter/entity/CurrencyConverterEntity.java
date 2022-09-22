package com.project.currency.converter.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Table(name="currency")
@Entity
public class CurrencyConverterEntity {
	
	@Id
	@NotNull(message = "Code cannot be null")
	private String code;
	
	@Min(value = 0, message = "value should be positive")
	private float value;
	
	@NotNull(message = "Country cannot be null")
	private String country;

	public CurrencyConverterEntity() {
		super();
	}

	public CurrencyConverterEntity(String code, int value, String country) {
		super();
		this.code = code;
		this.value = value;
		this.country = country;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	
}
