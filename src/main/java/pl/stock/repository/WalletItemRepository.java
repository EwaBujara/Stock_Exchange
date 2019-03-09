package pl.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.stock.entity.Stock;
import pl.stock.entity.WalletItem;

public interface WalletItemRepository extends JpaRepository<WalletItem, Long> {
    WalletItem findByStock(Stock stock);
}
