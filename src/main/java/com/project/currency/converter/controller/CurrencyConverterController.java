package com.project.currency.converter.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.currency.converter.entity.CurrencyConverterEntity;
import com.project.currency.converter.service.CurrencyConverterService;

@RestController
public class CurrencyConverterController {
	
	@Autowired
	CurrencyConverterService currencyConverterService;
	
	@GetMapping("/get-all-currencies")
	public List<CurrencyConverterEntity> getAllCurrencies(){
		return currencyConverterService.getAllCurrencies();
	}
	
	@GetMapping("/get-currency/{code}")
	public CurrencyConverterEntity getCurrency( @PathVariable String code){
		return currencyConverterService.getCurrency(code);
	}
	
	@PostMapping("/add-currency")
	public CurrencyConverterEntity addCurrency(@Valid @RequestBody CurrencyConverterEntity  currencyConverterEntity) {
		return currencyConverterService.addCurrency(currencyConverterEntity);
	}
	
	@GetMapping("/covert-currency/")
	public String convertCurrency(@RequestParam String currencyCodeFrom,@Valid @RequestParam float fromValue, @RequestParam String currencyCodeTo){
		return currencyConverterService.convertCurrency(currencyCodeFrom,fromValue,currencyCodeTo);
	}
	
	@DeleteMapping("/delete-currency/{code}")
	public CurrencyConverterEntity deleteCurrency(@PathVariable String code) {
		return currencyConverterService.deleteCurrency(code);
	}
	
	@PutMapping("update-currency")
	public CurrencyConverterEntity updateCurrency(@Valid @RequestBody CurrencyConverterEntity  currencyConverterEntity) {
		return currencyConverterService.updateCurrency(currencyConverterEntity);
	}
	
	
}
