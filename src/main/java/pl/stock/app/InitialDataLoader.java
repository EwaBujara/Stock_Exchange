package pl.stock.app;

import netscape.security.Privilege;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pl.stock.entity.Stock;
import pl.stock.repository.StockRepository;

import javax.transaction.Transactional;


@Component
public class InitialDataLoader implements
        ApplicationListener<ContextRefreshedEvent> {

    boolean alreadySetup = false;

    @Autowired
    StockRepository stockRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {

        if (alreadySetup)
            return;
        Stock fpStock= createStockIfNotFound("Future Processing","FP", 1, 5.1354, 100000);
        Stock fplStock = createStockIfNotFound("FP Lab", "FPL", 100, 3.6434, 1000000);
        Stock pgbStock = createStockIfNotFound("Progress Bar", "PGB", 1, 4.0666, 1000000);
        Stock fpcStock = createStockIfNotFound("FP Coin", "FPC", 50, 16.3821, 1000000);
        Stock fpaStock = createStockIfNotFound("FP Adventure", "FPA", 50, 11.7366, 1000000);
        Stock dl24Stock = createStockIfNotFound("Deadline 24", "DL24", 100, 5.2414, 1000000);
        alreadySetup = true;
    }

    @Transactional
    public Stock createStockIfNotFound(String name, String code, int unit, Double price, int totalQuantity) {

        Stock stock = stockRepository.findByName(name);
        if (stock == null) {
            stock = new Stock();
            stock.setName(name);
            stock.setCode(code);
            stock.setUnit(unit);
            stock.setPrice(price);
            stock.setTotalQuantity(totalQuantity);
            stock.setAvailableQuantity(totalQuantity);
            stockRepository.save(stock);
        }
        return  stock;
    }




}
