package pl.stock.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.stock.entity.Wallet;
import pl.stock.repository.WalletRepository;

public class WalletConverter implements Converter<String, Wallet> {

    @Autowired
    WalletRepository walletRepository;
    @Override
    public Wallet convert(String s) {
        return walletRepository.findOne(Long.parseLong(s));
    }
}
