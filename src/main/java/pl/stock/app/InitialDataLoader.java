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
//        Privilege adminPrivilege = createPrivilegeIfNotFound("ADMIN_PRIVILEGE");

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
