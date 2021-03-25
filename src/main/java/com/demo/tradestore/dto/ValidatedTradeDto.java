package com.demo.tradestore.dto;

import java.util.List;

import com.demo.tradestore.exceptions.TradeErrorCode;


public class ValidatedTradeDto {
    private TradeDto tradeDto;
    private List<TradeErrorCode> errorCodes;

    public ValidatedTradeDto(TradeDto tradeDto, List<TradeErrorCode> errorCodes) {
        this.tradeDto = tradeDto;
        this.errorCodes = errorCodes;
    }

	public TradeDto getTradeDto() {
		return tradeDto;
	}

	public void setTrade(TradeDto tradeDto) {
		this.tradeDto = tradeDto;
	}

	public List<TradeErrorCode> getErrorCodes() {
		return errorCodes;
	}

	public void setErrorCodes(List<TradeErrorCode> errorCodes) {
		this.errorCodes = errorCodes;
	}
    
    
}
