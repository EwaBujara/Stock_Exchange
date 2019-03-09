package pl.stock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.stock.entity.User;
import pl.stock.repository.UserRepository;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    UserRepository userRepository;

    @Override
    public void withdraw(Double withdraw, User user) {
        Double userMoney = user.getMoney();
        if(userMoney<withdraw){

        } else {
            user.setMoney(userMoney-withdraw);
            userRepository.save(user);
        }
    }

    @Override
    public void deposit(Double deposit, User user) {
        user.setMoney(user.getMoney()+deposit);
        userRepository.save(user);
    }
}
