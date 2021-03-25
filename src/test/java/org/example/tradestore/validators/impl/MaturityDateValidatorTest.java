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
import com.demo.tradestore.exceptions.TradeValidationException;
import com.demo.tradestore.validators.MaturityDateValidatorImpl;

@ExtendWith(MockitoExtension.class)
public class MaturityDateValidatorTest {

    @InjectMocks
    private MaturityDateValidatorImpl maturityDateValidator;

    @Test
    public void shouldThrowExceptionForMaturityDateLessThanToday() {

        TradeDto tradeDto = new TradeDto();
        tradeDto.setTradeId("T1");
        tradeDto.setBookId("B1");
        tradeDto.setCounterPartyId("CP-1");
        tradeDto.setMaturityDate(DateUtils.addDays(new Date(), -3));
        tradeDto.setVersion(1);

        List<TradeErrorCode> errorCodeList = maturityDateValidator.validate(tradeDto);
        Assertions.assertTrue(errorCodeList.size() == 1);
        Assertions.assertTrue(errorCodeList.get(0).equals(TradeErrorCode.INVALID_MATURITY_DATE));

    }

    @Test
    public void shouldNotThrowExceptionForValidMaturityDate() {

    	TradeDto tradeDto = new TradeDto();
    	tradeDto.setTradeId("T1");
    	tradeDto.setBookId("B1");
    	tradeDto.setCounterPartyId("CP-1");
    	tradeDto.setMaturityDate(DateUtils.addDays(new Date(), 3));
    	tradeDto.setVersion(1);

        try {
            maturityDateValidator.validate(tradeDto);
        } catch (TradeValidationException ex) {
            Assertions.fail("Exception not expected");
        }


    }

}