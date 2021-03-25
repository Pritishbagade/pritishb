package com.demo.tradestore.exceptions;

import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandler.class);

    @org.springframework.web.bind.annotation.ExceptionHandler(value
            = {TradeValidationException.class})
    protected ResponseEntity<Object> handleValidationError(
            RuntimeException ex, WebRequest request) {
        TradeValidationException tradeValidationException = (TradeValidationException) ex;
        String errorStr = tradeValidationException.getValidatedTrade().getErrorCodes().stream()
                .map(ec -> ec.getMessage()).collect(Collectors.joining());
        LOGGER.error("Error in trade message with trade id {} for error {}",
                tradeValidationException.getValidatedTrade().getTradeDto().getTradeId(), errorStr);
        String bodyOfResponse = errorStr;
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}

