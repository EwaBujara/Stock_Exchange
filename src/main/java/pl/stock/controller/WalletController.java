package pl.stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.stock.repository.StockRepository;

@Controller
@RequestMapping("/SE")
public class WalletController {

    @Autowired
    StockRepository stockRepository;

    @GetMapping("/wallet")
    public String showWallet(){

        return "wallet/wallet";
    }


    @GetMapping("/stock/{stockId}")
    public String showDetails(@PathVariable Long stockId, Model model){
        model.addAttribute("stock", stockRepository.findOne(stockId));
        return "wallet/stock";
    }
}
