package com.harish.microservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harish.microservices.entity.ExchangeValue;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long>{
	
	ExchangeValue findByFromAndTo(String from, String to);
	
}
