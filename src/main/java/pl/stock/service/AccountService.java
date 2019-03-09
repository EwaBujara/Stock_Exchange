package pl.stock.service;

import org.springframework.stereotype.Service;
import pl.stock.entity.User;

public interface AccountService {
    void withdraw(Double withdraw, User user);

    void deposit(Double deposit, User user);
}
