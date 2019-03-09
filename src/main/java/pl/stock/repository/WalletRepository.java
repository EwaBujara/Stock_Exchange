package pl.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.stock.entity.Wallet;

public interface WalletRepository extends JpaRepository<Wallet, Long> {
}
