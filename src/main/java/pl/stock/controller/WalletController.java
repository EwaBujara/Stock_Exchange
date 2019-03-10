package pl.stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.stock.entity.Stock;
import pl.stock.entity.User;
import pl.stock.repository.StockRepository;
import pl.stock.repository.WalletItemRepository;
import pl.stock.service.WalletService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/SE")
public class WalletController {

    @Autowired
    StockRepository stockRepository;

    @Autowired
    WalletService walletService;

    @Autowired
    WalletItemRepository walletItemRepository;

    @GetMapping("/wallet")
    public String showWallet(Model model, HttpSession session){
        User currentUser =(User) session.getAttribute("currentUser");
        model.addAttribute("stocks", stockRepository.findAll());
        model.addAttribute("userStocks", walletItemRepository.findAllByWallet(currentUser.getWallet()));
        return "wallet/wallet";
    }


    @GetMapping("/buyStock/{stockId}")
    public String buyStock(@PathVariable Long stockId, Model model){
        Stock stock = stockRepository.findOne(stockId);
        String action = "Buy!";
        model.addAttribute("stock", stock);
        model.addAttribute("action", action);
        return "wallet/stock";
    }

    @PostMapping("/buyStock/{stockId}")
    public String buyStock(@PathVariable Long stockId,
                           HttpSession session,
                           int quantity,
                           HttpServletRequest request){
        User currentUser = (User) session.getAttribute("currentUser");
        Stock stock = stockRepository.findOne(stockId);
        walletService.buyStock(currentUser, stock, quantity);

        return "redirect:"+request.getContextPath()+"/SE/wallet";
    }

    @GetMapping("/sellStock/{stockId}")
    public String sellStock(@PathVariable Long stockId, Model model){
        Stock stock = stockRepository.findOne(stockId);
        String action = "Sell!";
        model.addAttribute("stock", stock);
        model.addAttribute("action", action);
        return "wallet/stock";
    }

    @PostMapping("/sellStock/{stockId}")
    public String sellStock(@PathVariable Long stockId,
                           HttpSession session,
                           int quantity,
                           HttpServletRequest request){
        User currentUser = (User) session.getAttribute("currentUser");
        Stock stock = stockRepository.findOne(stockId);
        walletService.sellStock(currentUser, stock, quantity);

        return "redirect:"+request.getContextPath()+"/SE/wallet";
    }
}
