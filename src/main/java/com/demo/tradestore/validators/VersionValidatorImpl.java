package com.demo.tradestore.validators;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.demo.tradestore.dto.TradeDto;
import com.demo.tradestore.entity.Trade;
import com.demo.tradestore.exceptions.TradeErrorCode;

@Component
@Order(10)
public class VersionValidatorImpl implements UpdateTradeValidator {

    @Override
    public List<TradeErrorCode> validate(TradeDto tradeDto, Trade tradeEntity) {
        ArrayList<TradeErrorCode> errorCodes = new ArrayList<>();
        if(tradeDto.getVersion() < tradeEntity.getVersion()) errorCodes.add(TradeErrorCode.INVALID_VERSION);
        return errorCodes;
    }

}
