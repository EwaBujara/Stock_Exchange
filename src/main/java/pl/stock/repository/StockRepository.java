package pl.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.stock.entity.Stock;


public interface StockRepository  extends JpaRepository<Stock, Long> {
    Stock findByName(String name);

}
