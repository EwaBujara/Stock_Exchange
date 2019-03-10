package pl.stock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.stock.entity.Stock;
import pl.stock.entity.User;
import pl.stock.entity.Wallet;
import pl.stock.entity.WalletItem;
import pl.stock.repository.StockRepository;
import pl.stock.repository.UserRepository;
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

    @Autowired
    UserRepository userRepository;

    @Override
    public void buyStock(User user, Stock stock, int quantity) {

        Wallet wallet = walletRepository.findOne(user.getWallet().getId());

        WalletItem walletItem = walletItemRepository.findByWalletAndStock(wallet, stock);

        if(quantity*stock.getUnit()*stock.getPrice()<user.getMoney() && quantity*stock.getUnit()<stock.getAvailableQuantity()){

            if(walletItem!=null){
                walletItem.setQuantity(walletItem.getQuantity()+(quantity*stock.getUnit()));
                walletItemRepository.save(walletItem);

            } else{
                walletItem = new WalletItem();
                walletItem.setStock(stock);
                walletItem.setQuantity(stock.getUnit()*quantity);
                walletItem.setWallet(wallet);
                walletItemRepository.save(walletItem);

                stock.setAvailableQuantity(stock.getAvailableQuantity()-quantity*stock.getUnit());
                stockRepository.save(stock);

                user.setMoney(user.getMoney()-quantity*stock.getUnit()*stock.getPrice());
                userRepository.save(user);

            }
        }


    }

    @Override
    public void sellStock(User user, Stock stock, int quantity){
        Wallet wallet = walletRepository.findOne(user.getWallet().getId());

        WalletItem walletItem = walletItemRepository.findByWalletAndStock(wallet, stock);
        if(walletItem.getQuantity() >= stock.getUnit()*quantity){

            walletItem.setQuantity(walletItem.getQuantity()-(quantity*stock.getUnit()));
            walletItemRepository.save(walletItem);

            stock.setAvailableQuantity(stock.getAvailableQuantity()+quantity*stock.getUnit());
            stockRepository.save(stock);

            user.setMoney(user.getMoney()+quantity*stock.getUnit()*stock.getPrice());
            userRepository.save(user);

        }
    }

}
