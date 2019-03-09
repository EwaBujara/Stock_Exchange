package pl.stock.service;

import org.springframework.stereotype.Service;
import pl.stock.entity.Stock;
import pl.stock.entity.User;
import pl.stock.entity.WalletItem;

import java.util.List;

@Service
public class WalletServiceImpl implements WalletService{

//    @Autowired
//    WalletRepository walletRepository;

    @Override
    public void buyStock(User user, Stock stock, int quantity) {

//        Wallet wallet = walletRepository.findByUser();
////
////        List<WalletItem> walletItems= wallet.getWalletItems();
//
//        if(containsStock(walletItems, stock)){
//            walletItem
//        }

    }

    @Override
    public void sellStock(User user, Stock stock, int quantity){

    }

    public boolean containsStock(List<WalletItem> list, Stock stock){
        return list.stream().map(WalletItem::getStock).filter(stock::equals).findFirst().isPresent();
    }
}
