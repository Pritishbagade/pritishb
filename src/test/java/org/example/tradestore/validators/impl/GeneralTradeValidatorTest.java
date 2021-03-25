package org.example.tradestore.validators.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.demo.tradestore.dto.TradeDto;
import com.demo.tradestore.exceptions.TradeErrorCode;
import com.demo.tradestore.validators.GeneralTradeValidatorImpl;

@ExtendWith(MockitoExtension.class)
public class GeneralTradeValidatorTest {

    @InjectMocks
    private GeneralTradeValidatorImpl generalTradeValidator;

    @Test
    public void shouldThrowExceptionForEmptyTradeId() {

        TradeDto tradeDto = new TradeDto();
        tradeDto.setBookId("B1");
        tradeDto.setCounterPartyId("CP-1");
        tradeDto.setMaturityDate(DateUtils.addDays(new Date(), 3));
        tradeDto.setVersion(1);


        List<TradeErrorCode> exceptionCodeList = generalTradeValidator.validate(tradeDto);
        Assertions.assertTrue(exceptionCodeList.size() == 1);
        Assertions.assertTrue(exceptionCodeList.get(0).equals(TradeErrorCode.INVALID_TRADE_ID));

    }

    @Test
    public void shouldThrowExceptionForEmptyFieldsOtherThanTradeId() {

    	TradeDto tradeDto = new TradeDto();
    	tradeDto.setTradeId("T1");

        List<TradeErrorCode> exceptionCodeList = generalTradeValidator.validate(tradeDto);
        Assertions.assertTrue(exceptionCodeList.size() == 4);
        Assertions.assertTrue(exceptionCodeList.get(0).equals(TradeErrorCode.INVALID_BOOK_ID));
        Assertions.assertTrue(exceptionCodeList.get(1).equals(TradeErrorCode.INVALID_COUNTER_PARTY_ID));
        Assertions.assertTrue(exceptionCodeList.get(2).equals(TradeErrorCode.INVALID_MATURITY_DATE));
        Assertions.assertTrue(exceptionCodeList.get(3).equals(TradeErrorCode.INVALID_VERSION));


    }

}