package com.demo.tradestore.processors;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.demo.tradestore.dto.TradeDto;
import com.demo.tradestore.exceptions.TradeErrorCode;
import com.demo.tradestore.exceptions.TradeValidationException;
import com.demo.tradestore.validators.InputTradeValidator;

@Component
@Order(20)
public class TradeValidationProcessorImpl implements TradeProcessor {

    private static final Logger LOGGER = LoggerFactory.getLogger(TradeValidationProcessorImpl.class);

    @Autowired
    private List<InputTradeValidator> tradeValidators;

    @Override
    public void processTrade(TradeDto tradeDto) {

        List<TradeErrorCode> exceptionList = tradeValidators.stream()
                                                                    .flatMap(tradeValidator -> tradeValidator.validate(tradeDto).stream())
                                                                    .collect(Collectors.toList());
        if(exceptionList.size() > 0){
            LOGGER.error("Validation error for trade with id {}", tradeDto.getTradeId());
            throw new TradeValidationException(tradeDto, exceptionList);
        }

    }

}
