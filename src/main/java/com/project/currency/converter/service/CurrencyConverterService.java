package com.project.currency.converter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.currency.converter.Repository.CurrencyConverterRepo;
import com.project.currency.converter.entity.CurrencyConverterEntity;

@Service
public class CurrencyConverterService {

	@Autowired
	CurrencyConverterRepo currencyConverterRepo;
	
	public List<CurrencyConverterEntity> getAllCurrencies() {
		
		return currencyConverterRepo.findAll();
	}

	public CurrencyConverterEntity getCurrency(String code) {
		return currencyConverterRepo.findById(code).get();
	}

	public CurrencyConverterEntity addCurrency(CurrencyConverterEntity currencyConverterEntity) {
		if(currencyConverterRepo.findById(currencyConverterEntity.getCode()).isPresent()){
			return null;
		}
		return currencyConverterRepo.save(currencyConverterEntity);
	}

	public String convertCurrency(String currencyCodeFrom,float fromVal, String currencyCodeTo) {
		if(currencyConverterRepo.findById(currencyCodeFrom).isPresent() && currencyConverterRepo.findById(currencyCodeTo).isPresent()){
			float from = currencyConverterRepo.findById(currencyCodeFrom).get().getValue();
			float to = currencyConverterRepo.findById(currencyCodeTo).get().getValue();
			
			float ans = (from * fromVal)/(to);
			return fromVal+" "+currencyCodeFrom+" is equal to "+ ans+ " "+currencyCodeTo;
		}
		return "enter correct codes";
	}

	public CurrencyConverterEntity deleteCurrency(String code) {
		if(currencyConverterRepo.findById(code).isPresent()){
			CurrencyConverterEntity val = currencyConverterRepo.findById(code).get();
			currencyConverterRepo.deleteById(code);
			return val;
		}
		return null;
	}

	public CurrencyConverterEntity updateCurrency(CurrencyConverterEntity currencyConverterEntity) {
		if(currencyConverterRepo.findById(currencyConverterEntity.getCode()).isPresent()){
			return currencyConverterRepo.save(currencyConverterEntity);
		}
		return null;
	}

}
