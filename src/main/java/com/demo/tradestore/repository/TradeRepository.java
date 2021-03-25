package com.demo.tradestore.repository;


import java.time.LocalDate;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.tradestore.entity.Trade;

@Repository
public interface TradeRepository extends CrudRepository<Trade, String> {

    @Modifying
    @Query("update Trade t set t.expired = true where t.maturityDate < :date")
    void updateExpireFlag(@Param("date") LocalDate date);
}
