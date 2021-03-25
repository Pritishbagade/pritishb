package com.demo.tradestore.exceptions;

import java.util.List;

import com.demo.tradestore.dto.TradeDto;
import com.demo.tradestore.dto.ValidatedTradeDto;


public class TradeValidationException extends RuntimeException {

    private ValidatedTradeDto validatedTrade;

	public ValidatedTradeDto getValidatedTrade() {
		return validatedTrade;
	}

	public void setValidatedTrade(ValidatedTradeDto validatedTrade) {
		this.validatedTrade = validatedTrade;
	}
    
	public TradeValidationException(TradeDto tradeDto, List<TradeErrorCode> errorCodes){
		this.validatedTrade = new ValidatedTradeDto(tradeDto, errorCodes);
	}

}
