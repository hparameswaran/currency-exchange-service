package com.harish.microservices.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.harish.microservices.entity.ExchangeValue;
import com.harish.microservices.repository.ExchangeValueRepository;

@RestController
public class CurrencyExchangeController {
	
	@Autowired
	private Environment environment;
	@Autowired
	private ExchangeValueRepository exchangeValueRepository;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retreiveExchangeValue(@PathVariable String from,@PathVariable String to) {
		
		ExchangeValue exchangeValue =  exchangeValueRepository.findByFromAndTo(from, to);
		//ExchangeValue exchangeValue = new ExchangeValue(1000L,from,to,BigDecimal.valueOf(65.55));
		exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		return exchangeValue;
		
		
	}

}
