package pl.stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.stock.entity.User;
import pl.stock.service.AccountService;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping("/deposit")
    public String depositMoney(){
        return "user/deposit";
    }

    @PostMapping("/deposit")
    public String depositMoney(@ModelAttribute("deposit") Double deposit, HttpSession session){
        User currentUser = (User) session.getAttribute("currentUser");
        accountService.deposit(deposit, currentUser);
        return "user/account";
    }
}