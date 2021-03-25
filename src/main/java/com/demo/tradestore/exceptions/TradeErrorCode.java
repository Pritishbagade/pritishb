package com.demo.tradestore.exceptions;

public enum TradeErrorCode {
    INVALID_TRADE_ID("Invalid Trade ID."),
    INVALID_BOOK_ID("Invalid Book Id."),
    INVALID_COUNTER_PARTY_ID("invalid counter party."),
    INVALID_MATURITY_DATE("Invalid maturity date."),
    INVALID_VERSION("Invalid version.");

    private final String message;

    TradeErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
