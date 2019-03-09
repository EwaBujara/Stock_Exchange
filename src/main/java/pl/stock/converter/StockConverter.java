package pl.stock.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.stock.entity.Stock;
import pl.stock.repository.StockRepository;

public class StockConverter implements Converter<String, Stock> {

    @Autowired
    StockRepository stockRepository;

    @Override
    public Stock convert(String s) {
        return stockRepository.findOne(Long.parseLong(s));
    }
}
