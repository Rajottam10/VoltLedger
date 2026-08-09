package io.voltledger.userservice.repositories;

import io.voltledger.userservice.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
    Stock findStockByStockSymbol(String stockSymbol);
}
