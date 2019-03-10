package pl.stock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.stock.entity.Stock;
import pl.stock.entity.User;
import pl.stock.entity.Wallet;
import pl.stock.entity.WalletItem;
import pl.stock.repository.StockRepository;
import pl.stock.repository.WalletItemRepository;
import pl.stock.repository.WalletRepository;

import java.util.List;

@Service
public class WalletServiceImpl implements WalletService{

    @Autowired
    WalletRepository walletRepository;

    @Autowired
    WalletItemRepository walletItemRepository;

    @Autowired
    StockRepository stockRepository;

    @Override
    public void buyStock(User user, Stock stock, int quantity) {

        Wallet wallet = walletRepository.findOne(user.getWallet().getId());

        List<WalletItem> walletItems= wallet.getWalletItems();

        if(containsStock(walletItems, stock)){
            WalletItem walletItem = walletItemRepository.findByStock(stock);
            walletItem.setQuantity(walletItem.getQuantity()+(quantity*stock.getUnit()));

        } else {
            WalletItem walletItem = new WalletItem();
            walletItem.setStock(stock);
            walletItem.setQuantity(stock.getUnit()*quantity);
            stock.setAvailableQuantity(stock.getAvailableQuantity()-quantity);
            stockRepository.save(stock);
            walletItemRepository.save(walletItem);
            walletItems.add(walletItem);
            wallet.setWalletItems(walletItems);
            walletRepository.save(wallet);
        }

    }

    @Override
    public void sellStock(User user, Stock stock, int quantity){

    }

    public boolean containsStock(List<WalletItem> list, Stock stock){
        return list.stream().map(WalletItem::getStock).filter(stock::equals).findFirst().isPresent();
    }
}
