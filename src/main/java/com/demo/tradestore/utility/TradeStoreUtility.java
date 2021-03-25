package com.demo.tradestore.utility;

import com.demo.tradestore.dto.TradeDto;
import com.demo.tradestore.entity.Trade;

public class TradeStoreUtility {
	 public static Trade mapTradeDtoToTradeEntity(TradeDto tradedto){
    	 Trade tradeEntity = new Trade();
    	 tradeEntity.setTradeId(tradedto.getTradeId());
    	 tradeEntity.setVersion(tradedto.getVersion());
    	 tradeEntity.setBookId(tradedto.getBookId());
    	 tradeEntity.setCounterPartyId(tradedto.getCounterPartyId());
    	 tradeEntity.setExpired(tradedto.isExpired());
    	 tradeEntity.setMaturityDate(tradedto.getMaturityDate());
    	 tradeEntity.setCreatedDate(tradedto.getCreatedDate());
    	 return tradeEntity;
    }
}
