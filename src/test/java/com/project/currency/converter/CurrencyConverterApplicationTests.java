package com.project.currency.converter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.currency.converter.entity.CurrencyConverterEntity;
import com.project.currency.converter.service.CurrencyConverterService;


@ExtendWith(MockitoExtension.class)
class CurrencyConverterApplicationTests {

	@Mock
	CurrencyConverterService currencyConverterService;
	
	@Test
	void addCurrency() {
		CurrencyConverterEntity c = new CurrencyConverterEntity("INR",80,"INDIA");
		when(currencyConverterService.addCurrency(c)).thenReturn(c);
		assertEquals(currencyConverterService.addCurrency(c),c);
	}
	
	@Test
	void deleteCurrency() {
		CurrencyConverterEntity c = new CurrencyConverterEntity("INR",80,"INDIA");
		when(currencyConverterService.deleteCurrency("INR")).thenReturn(c);
		assertEquals(currencyConverterService.deleteCurrency("INR"),c);
	}
	
	@Test
	void updateCurrency() {
		CurrencyConverterEntity c = new CurrencyConverterEntity("INR",80,"INDIA");
		when(currencyConverterService.updateCurrency(c)).thenReturn(c);
		assertEquals(currencyConverterService.updateCurrency(c),c);
	}
	
	@Test
	void getCurrency() {
		CurrencyConverterEntity c = new CurrencyConverterEntity("INR",80,"INDIA");
		when(currencyConverterService.getCurrency("INR")).thenReturn(c);
		assertEquals(currencyConverterService.getCurrency("INR"),c);
	}

}
