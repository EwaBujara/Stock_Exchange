package pl.stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.stock.entity.Stock;
import pl.stock.entity.WalletItem;
import pl.stock.repository.StockRepository;

@Controller
@RequestMapping("/SE")
public class WalletController {

    @Autowired
    StockRepository stockRepository;

    @GetMapping("/wallet")
    public String showWallet(Model model){

        model.addAttribute("stocks", stockRepository.findAll());
        model.addAttribute("userStocks", stockRepository.findAll());
        return "wallet/wallet";
    }


    @GetMapping("/stock/{stockId}")
    public String showDetails(@PathVariable Long stockId, Model model){
        Stock stock = stockRepository.findOne(stockId);
        model.addAttribute("stock", stock);
        WalletItem walletItem = new WalletItem();
        walletItem.setStock(stock);
        model.addAttribute("walletItem",walletItem);
        return "wallet/stock";
    }
}
