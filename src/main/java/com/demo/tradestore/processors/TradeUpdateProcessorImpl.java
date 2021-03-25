package com.demo.tradestore.processors;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.demo.tradestore.dto.TradeDto;
import com.demo.tradestore.entity.Trade;
import com.demo.tradestore.exceptions.TradeErrorCode;
import com.demo.tradestore.exceptions.TradeValidationException;
import com.demo.tradestore.repository.TradeRepository;
import com.demo.tradestore.utility.TradeStoreUtility;
import com.demo.tradestore.validators.UpdateTradeValidator;

@Component
@Order(40)
public class TradeUpdateProcessorImpl implements TradeProcessor {
    private static final Logger LOGGER = LoggerFactory.getLogger(TradeUpdateProcessorImpl.class);

    @Autowired
    private TradeRepository tradeRepository;

   /* @Autowired
    private TradeMapper tradeMapper;*/

    @Autowired
    private List<UpdateTradeValidator> updateTradeValidators;

    @Override
    @Transactional
    public void processTrade(TradeDto tradedto) {
        LOGGER.info("Update trade start");
        Optional<Trade> optionalTrade = tradeRepository.findById(tradedto.getTradeId());
        if(optionalTrade.isPresent()){
            List<TradeErrorCode> tradeExceptionCodes = updateTradeValidators.stream()
                    .flatMap(updateTradeValidator -> updateTradeValidator.validate(tradedto, optionalTrade.get()).stream()).collect(Collectors.toList());
            if(tradeExceptionCodes.size() > 0){
                throw new TradeValidationException(tradedto, tradeExceptionCodes);
            }
        }
      
        Trade tradeEntity = TradeStoreUtility.mapTradeDtoToTradeEntity(tradedto);
        tradeRepository.save(tradeEntity);
        LOGGER.info("Update trade ends");

    }
    
   
}
