package pl.stock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/stock")
public class WalletController {

    @GetMapping("/wallet")
    public String showWallet(){

        return "wallet/wallet";
    }

    @GetMapping("/account")
    public String showAccount(){
        return "wallet/account";
    }
}
