package com.demo.tradestore.validators;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.demo.tradestore.dto.TradeDto;
import com.demo.tradestore.exceptions.TradeErrorCode;

@Component
@Order(20)
public class MaturityDateValidatorImpl implements InputTradeValidator {
	private static final Logger LOGGER = LoggerFactory.getLogger(MaturityDateValidatorImpl.class);

	@Override
	public List<TradeErrorCode> validate(TradeDto tradedto) {
		List<TradeErrorCode> errorCodes = new ArrayList<>();
		if (tradedto.getMaturityDate() != null && isBeforeToday(tradedto.getMaturityDate()))
			errorCodes.add(TradeErrorCode.INVALID_MATURITY_DATE);
		LOGGER.trace("MaturityDateValidator completed validation for trade id {} ", tradedto.getTradeId());
		return errorCodes;
	}

	private boolean isBeforeToday(Date maturityDate) {
		return maturityDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().isBefore(LocalDate.now());
	}
}
