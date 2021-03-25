package com.demo.tradestore.processors;

import com.demo.tradestore.dto.TradeDto;

public interface TradeProcessor {
    void processTrade(TradeDto tradeDto);
}
