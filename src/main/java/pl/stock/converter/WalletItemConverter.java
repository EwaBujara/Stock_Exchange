package pl.stock.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.stock.entity.WalletItem;
import pl.stock.repository.WalletItemRepository;

public class WalletItemConverter implements Converter<String, WalletItem> {

    @Autowired
    WalletItemRepository walletItemRepository;

    @Override
    public WalletItem convert(String s) {
        return walletItemRepository.findOne(Long.parseLong(s));
    }
}
