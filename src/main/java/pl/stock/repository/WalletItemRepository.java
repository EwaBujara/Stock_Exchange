package pl.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.stock.entity.Stock;
import pl.stock.entity.Wallet;
import pl.stock.entity.WalletItem;

import java.util.List;

public interface WalletItemRepository extends JpaRepository<WalletItem, Long> {
    List<WalletItem> findAllByWallet(Wallet wallet);
    WalletItem findByWalletAndStock(Wallet wallet, Stock stock);
}
