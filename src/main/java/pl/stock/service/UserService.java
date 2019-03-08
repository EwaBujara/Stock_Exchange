package pl.stock.service;

import pl.stock.entity.User;

public interface UserService {
    void save(User user);

    boolean verify(User user);

}
