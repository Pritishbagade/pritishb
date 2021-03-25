package com.demo.tradestore.service;

import com.demo.tradestore.dto.TradeDto;

public interface TradeStoreService {
    void processTrade(TradeDto tradeDto);

    void updateExpireFlag();
}