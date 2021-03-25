package com.demo.tradestore.validators;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.demo.tradestore.dto.TradeDto;
import com.demo.tradestore.exceptions.TradeErrorCode;

@Component
@Order(10)
public class GeneralTradeValidatorImpl implements InputTradeValidator {
    private static final Logger LOGGER = LoggerFactory.getLogger(GeneralTradeValidatorImpl.class);

    @Override
    public List<TradeErrorCode> validate(TradeDto tradeDto) {

        List<TradeErrorCode> erroCodes = new ArrayList<>();

        if(StringUtils.isEmpty(tradeDto.getTradeId())) erroCodes.add(TradeErrorCode.INVALID_TRADE_ID);
        if(StringUtils.isEmpty(tradeDto.getBookId())) erroCodes.add(TradeErrorCode.INVALID_BOOK_ID);
        if(StringUtils.isEmpty(tradeDto.getCounterPartyId())) erroCodes.add(TradeErrorCode.INVALID_COUNTER_PARTY_ID);
        if(ObjectUtils.isEmpty(tradeDto.getMaturityDate())) erroCodes.add(TradeErrorCode.INVALID_MATURITY_DATE);
        if(tradeDto.getVersion() < 1) erroCodes.add(TradeErrorCode.INVALID_VERSION);

        LOGGER.trace("GeneralTradeValidator completed validation for trade id {} ", tradeDto.getTradeId());

        return erroCodes;
    }
}
