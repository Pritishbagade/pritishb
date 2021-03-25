package com.demo.tradestore.service;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.tradestore.dto.TradeDto;
import com.demo.tradestore.processors.TradeProcessor;
import com.demo.tradestore.repository.TradeRepository;

@Service
public class TradeStoreServiceImpl implements TradeStoreService {
	private static final Logger LOG = LoggerFactory.getLogger(TradeStoreServiceImpl.class);
	
	@Autowired
	private TradeRepository tradeRepository;

	@Autowired
	private List<TradeProcessor> tradeProcessors;
	

	@Override
	public void processTrade(TradeDto tradeDto) {
		LOG.info("Start Processing trade with id {} ", tradeDto.getTradeId());
		tradeProcessors.stream().forEach(tradeProcessor -> tradeProcessor.processTrade(tradeDto));
		LOG.info("Processing ends for trade with id {} ", tradeDto.getTradeId());

	}

	@Override
	@Transactional
	public void updateExpireFlag() {
		LOG.info("Before Update");
		tradeRepository.updateExpireFlag(LocalDate.now());
		LOG.info("After Update");
	}

}
