package org.example.tradestore.validators.impl;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.demo.tradestore.dto.TradeDto;
import com.demo.tradestore.entity.Trade;
import com.demo.tradestore.exceptions.TradeErrorCode;
import com.demo.tradestore.validators.VersionValidatorImpl;

@ExtendWith(MockitoExtension.class)
public class VersionValidatorTest {

    @InjectMocks
    private VersionValidatorImpl versionValidator;

    @Test
    public void shouldAddExceptionIfVersionIsLessThanExisting(){
        TradeDto tradeDto = new TradeDto();
        tradeDto.setVersion(1);

       Trade tradeEntity = new Trade();
        tradeEntity.setVersion(3);

        List<TradeErrorCode> errorCodes = versionValidator.validate(tradeDto, tradeEntity);

        Assertions.assertTrue(errorCodes.size() > 0);
        Assertions.assertTrue(errorCodes.get(0).equals(TradeErrorCode.INVALID_VERSION));
    }

    @Test
    public void shouldNotAddExceptionForSameVersion(){
    	TradeDto tradeDto = new TradeDto();
    	tradeDto.setVersion(1);

        Trade tradeEntity = new Trade();
        tradeEntity.setVersion(1);

        List<TradeErrorCode> errorCodes = versionValidator.validate(tradeDto, tradeEntity);

        Assertions.assertTrue(errorCodes.size() == 0);
    }

    @Test
    public void shouldNotAddExceptionForGreaterVersion(){
        TradeDto tradeDto = new TradeDto();
        tradeDto.setVersion(2);

        Trade tradeEntity = new Trade();
        tradeEntity.setVersion(1);

        List<TradeErrorCode> errorCodes = versionValidator.validate(tradeDto, tradeEntity);

        Assertions.assertTrue(errorCodes.size() == 0);
    }


}