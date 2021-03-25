package com.demo.tradestore.validators;

import java.util.List;

import com.demo.tradestore.dto.TradeDto;
import com.demo.tradestore.entity.Trade;
import com.demo.tradestore.exceptions.TradeErrorCode;

public interface UpdateTradeValidator {
    List<TradeErrorCode> validate(TradeDto trade, Trade tradeEntity);
}
