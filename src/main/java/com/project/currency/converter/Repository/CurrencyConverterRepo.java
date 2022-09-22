package com.project.currency.converter.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.currency.converter.entity.CurrencyConverterEntity;


@Repository
public interface CurrencyConverterRepo extends JpaRepository<CurrencyConverterEntity,String>{

}
