package pl.stock.service;

import org.springframework.stereotype.Service;
import pl.stock.entity.Stock;
import pl.stock.entity.User;
import pl.stock.entity.Wallet;
import pl.stock.entity.WalletItem;

@Service
public class WalletServiceImpl implements WalletService{

    @Override
    public void buyStock(User user, Stock stock, int quantity) {
        WalletItem walletItem = new WalletItem();
        walletItem.setStock(stock);
        walletItem.setQuantity(quantity);

        Wallet wallet = user.getWallet();

        if(user.getMoney()<(quantity*stock.getUnit())*stock.getPrice()){

        }else{

        }

    }

    @Override
    public void sellStock(User user, Stock stock, int quantity){


    }
}
