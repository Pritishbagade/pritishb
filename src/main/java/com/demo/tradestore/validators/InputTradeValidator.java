package com.demo.tradestore.validators;

import java.util.List;

import com.demo.tradestore.dto.TradeDto;
import com.demo.tradestore.exceptions.TradeErrorCode;

public interface InputTradeValidator {
    List<TradeErrorCode> validate(TradeDto tradedto);
}
