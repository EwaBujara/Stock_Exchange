package pl.stock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/wallet")
public class WalletController {

    @GetMapping("/myWallet")
    public String showWallet(){
        return "wallet/wallet";
    }
}
