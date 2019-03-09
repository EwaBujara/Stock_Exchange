package pl.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.stock.entity.User;
import pl.stock.entity.Wallet;
import pl.stock.entity.WalletItem;

import java.util.List;

public interface WalletRepository extends JpaRepository<Wallet, Long> {
    Wallet findByUser(User user);

}
