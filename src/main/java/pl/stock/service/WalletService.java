package pl.stock.service;

import pl.stock.entity.Stock;
import pl.stock.entity.User;

public interface WalletService {
    void buyStock(User user, Stock stock, int quantity);
}
