package com.demo.tradestore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.tradestore.dto.TradeDto;
import com.demo.tradestore.service.TradeStoreService;

@RestController
public class TradeController {
	@Autowired
	private TradeStoreService tradeStoreService;

	@PostMapping(value = "/trade")
	public void processTrade(@RequestBody TradeDto tradeDto) {
		tradeStoreService.processTrade(tradeDto);
	}
}